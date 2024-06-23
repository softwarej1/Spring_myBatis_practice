package sample.myBatis.MemV01;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemMyBatisController {

	@RequestMapping(value = "/myBatisIndex", method = RequestMethod.GET)
	public ModelAndView memIndex() {
		return new ModelAndView("memSpringMyBatis/index");
	}

	@RequestMapping(value = "/myBatisMemDel", method = RequestMethod.GET)
	public ModelAndView memDel() {
		return new ModelAndView("memSpringMyBatis/MemDelFrame");
	}
	
	@RequestMapping(value = "/myBatisfrmDel", method = RequestMethod.GET)
	public ModelAndView frmDel(@RequestParam Map<String, Object> map) {
		String mem_id = map.get("mem_id").toString();
		String mem_pwd = map.get("mem_pwd").toString();
		String mem_name = map.get("mem_name").toString();
		String msg = "";
		
		MemDTO memDTO = new MemDTO(mem_id, mem_pwd);
		
		try {
			Reader reader = Resources.getResourceAsReader("sample/myBatis/MemV01/mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sqlSessionFactory.openSession();
			int su = session.delete("memDel", memDTO);
			session.commit();
			
			if(su != 0) {
				msg = mem_name + " 님 회원삭제 완료";
			}else {
				msg = mem_name + " 님 회원삭제  실패";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("memSpringMyBatis/msgChk");
		
		return mav;
	}

	@RequestMapping(value = "/myBatisMemIns", method = RequestMethod.GET)
	public ModelAndView memIns() {
		return new ModelAndView("memSpringMyBatis/MemInsFrame");
	}
	
	@RequestMapping(value = "/myBatisfrmIns", method = RequestMethod.GET)
	public ModelAndView frmIns(@RequestParam Map<String, Object> map) {
		String mem_name = map.get("mem_name").toString();
		String mem_id = map.get("mem_id").toString();
		String mem_pwd = map.get("mem_pwd").toString();
		String mem_email = map.get("mem_email").toString();
		String mem_phone = map.get("mem_phone").toString();
		String mem_addr = map.get("mem_addr").toString();
		
		String msg = "";
		
		MemDTO memDTO = new MemDTO(mem_id, mem_pwd, mem_name, mem_email, mem_phone, mem_addr);
		
		try {
			Reader reader = Resources.getResourceAsReader("sample/myBatis/MemV01/mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			int su = sqlSession.insert("memInsAll", memDTO);
			sqlSession.commit();
			
			if(su != 0) {
				msg = mem_name + " 님 회원가입 완료";
			}else {
				msg = mem_name + " 님 회원가입 실패";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("memSpringMyBatis/msgChk");
		
		return mav;
		
	}

	@RequestMapping(value = "/myBatisMemLog", method = RequestMethod.GET)
	public ModelAndView memLog() {
		return new ModelAndView("memSpringMyBatis/MemLobFrame");
	}
	
	@RequestMapping(value = "/myBatisfrmLog", method = RequestMethod.GET)
	public ModelAndView frmLog(@RequestParam Map<String, Object> map) {
		
		String mem_id = map.get("mem_id").toString();
		String mem_pwd = map.get("mem_pwd").toString();
		String msg = "";
		
		MemDTO memDTO = new MemDTO(mem_id, mem_pwd);
		try {
			Reader reader = Resources.getResourceAsReader("sample/myBatis/MemV01/mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			List<MemDTO> memLogList = sqlSession.selectList("memLog", memDTO);
			
			if(memLogList.size() != 0) {
				msg = mem_id + " 님 로그인 성공!!";
			}else {
				msg = mem_pwd + " 님 로그인 실패!!";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("memSpringMyBatis/msgChk");
		
		return mav;
	}

	@RequestMapping(value = "/myBatisMemSel", method = RequestMethod.GET)
	public ModelAndView memSel() {
		
		List<MemDTO> memDtoL = null;
		try {
			Reader reader = Resources.getResourceAsReader("sample/myBatis/MemV01/mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sqlSessionFactory.openSession();
			memDtoL = session.selectList("memSelAll");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("memDtoL", memDtoL);
		mav.setViewName("memSpringMyBatis/MemSelFrame");
		
		return mav;
	}

	@RequestMapping(value = "/myBatisMemUpd", method = RequestMethod.GET)
	public ModelAndView memUpd() {
		return new ModelAndView("memSpringMyBatis/MemUpdFrame");
	}
	
	@RequestMapping(value = "/myBatisfrmUpd", method = RequestMethod.GET)
	public ModelAndView frmUpd(@RequestParam Map<String, Object> map) {
		String mem_name = map.get("mem_name").toString();
		String mem_id = map.get("mem_id").toString();
		String mem_pwd = map.get("mem_pwd").toString();
		String mem_email = map.get("mem_email").toString();
		String mem_phone = map.get("mem_phone").toString();
		String mem_addr = map.get("mem_addr").toString();
		String msg = "";
		
		MemDTO memDTO = new MemDTO(mem_id, mem_pwd, mem_name, mem_email, mem_phone, mem_addr);
		
		try {
			Reader reader = Resources.getResourceAsReader("sample/myBatis/MemV01/mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			int su = sqlSession.update("memUpd", memDTO);
			sqlSession.commit();
			
			if (su != 0) {
				msg = mem_name + " 님 업데이트 되었습니다.";
			}else {
				msg = mem_name + " 님 업데이트 실패!";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("memSpringMyBatis/msgChk");
		return mav;
	}
	
}