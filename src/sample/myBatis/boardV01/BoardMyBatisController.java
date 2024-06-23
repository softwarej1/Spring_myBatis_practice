package sample.myBatis.boardV01;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

@Controller
public class BoardMyBatisController {

	List<BoardDTO> boardTitleList = new ArrayList<BoardDTO>();

	public List<BoardDTO> BoardTitleList() {
		try {
			Reader reader = Resources.getResourceAsReader("sample/myBatis/boardV01/mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			boardTitleList = sqlSession.selectList("bodSelAll");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardTitleList;
	}

	@RequestMapping(value = "/boardIndex", method = RequestMethod.GET)
	public ModelAndView boardIndex() {

		boardTitleList = BoardTitleList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardTitleList", boardTitleList);
		mav.setViewName("boardSpringMyBatis/boardTitleListFrame");
		return mav;
	}

	@RequestMapping(value = "/boardContent", method = RequestMethod.GET)
	public ModelAndView boardContent(@RequestParam Map<String, Object> map) {
		int bod_no = Integer.parseInt(map.get("bod_no").toString());
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBod_no(bod_no);
		List<BoardDTO> boardConList = null;

		try {
			Reader reader = Resources.getResourceAsReader("sample/myBatis/boardV01/mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			sqlSession.update("bodUpdContent", boardDTO);
			boardConList = sqlSession.selectList("bodSelContent", boardDTO);
			sqlSession.commit();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("boardConList", boardConList);
		mav.setViewName("boardSpringMyBatis/boardContentFrame");

		return mav;
	}

	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public ModelAndView boardList() {
		List<BoardDTO> boardDTOList = null;
		try {
			Reader reader = Resources.getResourceAsReader("sample/myBatis/boardV01/mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			boardDTOList = sqlSession.selectList("bodSelAll");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("boardDTOList", boardDTOList);
		mav.setViewName("boardSpringMyBatis/boardList");

		return mav;
	}

	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public ModelAndView boardWrite() {
		return new ModelAndView("boardSpringMyBatis/boardWriteFrame");
	}

	@RequestMapping(value = "/boardWritePro", method = RequestMethod.GET)
	public ModelAndView boardWritePro(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		String bod_writer = map.get("bod_writer").toString();
		String bod_pwd = map.get("bod_pwd").toString();
		String bod_subject = map.get("bod_subject").toString();
		String bod_email = map.get("bod_email").toString();
		String bod_content = map.get("bod_content").toString();
		String bod_connIp = request.getRemoteAddr();

		try {
			Reader reader = Resources.getResourceAsReader("sample/myBatis/boardV01/mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			int bod_no = 0;

			List<BoardDTO> bodInsSelecList = sqlSession.selectList("bodInsSelec");
			
			if(bodInsSelecList.get(0) == null) {
				bod_no = 1;
			}else {
				bod_no = bodInsSelecList.get(0).getBod_no() + 1;
			}

			BoardDTO boardDTO = new BoardDTO(bod_no, bod_writer, bod_email, bod_subject, bod_pwd, null, bod_content, 0,
					bod_connIp);

			sqlSession.insert("bodInsWrite", boardDTO);
			sqlSession.commit();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/boardIndex");
	}

	@RequestMapping(value = "/boardDelUpd", method = RequestMethod.GET)
	public ModelAndView boardDelUpd() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardSpringMyBatis/boardDelUpdFrame");
		return mav;
	}

	// UpdDelnum == 1 수정, UpdDelnum == 2 삭제
	@RequestMapping(value = "/boardDelUpdPro", method = RequestMethod.GET)
	public ModelAndView boardDelUpdPro(@RequestParam Map<String, Object> map) {
		int UpdDelnum = Integer.parseInt(map.get("UpdDelnum").toString());
		int bod_no = Integer.parseInt(map.get("bod_no").toString());
		ModelAndView mav = new ModelAndView();
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBod_no(bod_no);
		Reader reader;
		SqlSessionFactory sqlSessionFactory;
		SqlSession sqlSession;
		List<BoardDTO> bodSelUpdList = new ArrayList<BoardDTO>();

		switch (UpdDelnum) {
		case 1:
			try {
				reader = Resources.getResourceAsReader("sample/myBatis/boardV01/mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				sqlSession = sqlSessionFactory.openSession();
				bodSelUpdList = sqlSession.selectList("bodSelContent", boardDTO);

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			mav.addObject("bodSelUpdList", bodSelUpdList);
			mav.setViewName("boardSpringMyBatis/boardUpdateFrame");
			break;
		case 2:
			try {
				reader = Resources.getResourceAsReader("sample/myBatis/boardV01/mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				sqlSession = sqlSessionFactory.openSession();
				sqlSession.delete("bodDel", boardDTO);
				sqlSession.commit();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			boardTitleList = BoardTitleList();
			mav.addObject("boardTitleList", boardTitleList);
			mav.setViewName("boardSpringMyBatis/boardTitleListFrame");
			break;
		default:
			break;
		}

		return mav;
	}
	
	@RequestMapping(value = "/boardUpdPro", method = RequestMethod.GET)
	public ModelAndView boardUpdPro(@RequestParam Map<String, Object>map) {
		String bod_writer = map.get("bod_writer").toString();
		String bod_pwd = map.get("bod_pwd").toString();
		String bod_subject = map.get("bod_subject").toString();
		String bod_email = map.get("bod_email").toString();
		String bod_content = map.get("bod_content").toString();
		int bod_no = Integer.parseInt(map.get("bod_no").toString());
		
		BoardDTO boardDTO = new BoardDTO(bod_no, bod_writer, bod_email, bod_subject, bod_pwd, null, bod_content, 0, null);
		
		try {
			Reader reader = Resources.getResourceAsReader("sample/myBatis/boardV01/mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			sqlSession.update("bodUpd", boardDTO);
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		ModelAndView mav = new ModelAndView();
		boardTitleList = BoardTitleList();
		mav.addObject("boardTitleList", boardTitleList);
		mav.setViewName("boardSpringMyBatis/boardTitleListFrame");
		*/
		return new ModelAndView("redirect:/boardIndex");
	}
}
