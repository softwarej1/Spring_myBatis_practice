package sample.spring.MemV01;

import java.util.Map;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemController {

	// RequestMapping() -> value = url에서 접근할 값 Ex] springMemV01/index 형식, method =
	// get 형식으로
	@RequestMapping(value = "/index", method = RequestMethod.GET)

	// ModelAndView return 타입 -> ModelAndView() -> "springMemV01/index" -> 파일로 접근
	public ModelAndView memIndex() {
		return new ModelAndView("springMemV01/index");
	}

	@RequestMapping(value = "/memLog", method = RequestMethod.GET)
	public ModelAndView memLog() {
		return new ModelAndView("springMemV01/MemLobFrame");
	}

	@RequestMapping(value = "/frmLog", method = RequestMethod.GET)
	public ModelAndView frmLog(@RequestParam Map<String, Object> map) {
		String vId = map.get("mem_id").toString();
		String vPwd = map.get("mem_pwd").toString();
		String msg = "";

		MemDAO memDAO = new MemDAO();
		MemDTO memDTO = new MemDTO(vId, vPwd);

		boolean su = memDAO.memLog(memDTO);

		if (su) {
			msg = vId + " 님 로그인 성공 !!";
		} else {

			msg = vId + " 님 로그인 실패 !!";
		}

		System.out.println("msg >> : " + msg);
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("springMemV01/msgChk");

		return mav;

	}

	@RequestMapping(value = "/memDel", method = RequestMethod.GET)
	public ModelAndView memDel() {
		return new ModelAndView("springMemV01/MemDelFrame");
	}

	@RequestMapping(value = "/frmDel", method = RequestMethod.GET)
	public ModelAndView frmDel(@RequestParam Map<String, Object> map) {
		String vId = map.get("mem_id").toString();
		String vPwd = map.get("mem_pwd").toString();
		String vName = map.get("mem_name").toString();
		String msg = "";

		MemDAO memDAO = new MemDAO();
		MemDTO memDTO = new MemDTO(vId, vPwd);
		int su = memDAO.memDel(memDTO);

		if (su != 0) {
			msg = vName + " 님 삭제되었습니다.";
		} else {
			msg = vName + " 님 삭제되지 않았습니다.";
		}

		System.out.println("msg >> : " + msg);
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("springMemV01/msgChk");

		return mav;
	}

	@RequestMapping(value = "/memIns", method = RequestMethod.GET)
	public ModelAndView memIns() {
		return new ModelAndView("springMemV01/MemInsFrame");
	}

	@RequestMapping(value = "/frmIns", method = RequestMethod.GET)
	public ModelAndView frmIns(@RequestParam Map<String, Object> map) {
		String vName = map.get("mem_name").toString();
		String vId = map.get("mem_id").toString();
		String vPwd = map.get("mem_pwd").toString();
		String vEmail = map.get("mem_email").toString();
		String vPhone = map.get("mem_phone").toString();
		String vAddr = map.get("mem_addr").toString();
		String msg = "";

		MemDAO memDAO = new MemDAO();
		MemDTO memDTO = new MemDTO(vId, vPwd, vName, vEmail, vPhone, vAddr);

		int su = memDAO.memDel(memDTO);

		if (su != 0) {
			msg = vName + " 님 회원 가입되었습니다.";
		} else {
			msg = vName + " 님 회원 가입되지 않앗습니다.";
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("springMemV01/msgChk");

		return mav;
	}

	@RequestMapping(value = "/memUpd", method = RequestMethod.GET)
	public ModelAndView memUpd() {
		return new ModelAndView("springMemV01/MemUpdFrame");
	}

	@RequestMapping(value = "/frmUpd", method = RequestMethod.GET)
	public ModelAndView frmUpd(@RequestParam Map<String, Object> map) {
		String vName = map.get("mem_name").toString();
		String vId = map.get("mem_id").toString();
		String vPwd = map.get("mem_pwd").toString();
		String vEmail = map.get("mem_email").toString();
		String vPhone = map.get("mem_phone").toString();
		String vAddr = map.get("mem_addr").toString();
		String msg = "";
		
		MemDAO memDAO = new MemDAO();
		MemDTO memDTO = new MemDTO(vId, vPwd, vName, vEmail, vPhone, vAddr);
		
		int su = memDAO.memUpd(memDTO);		
		
		if (su != 0) {
			msg = vName + " 님 업데이트 되었습니다.";
		}else {
			msg = vName + " 님 업데이트 되지 않았습니다.";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("springMemV01/msgChk");
		
		return mav;

	}

	@RequestMapping(value = "/memSel", method = RequestMethod.GET)
	public ModelAndView memSel() {
		MemDAO memDAO = new MemDAO();
		java.util.List<MemDTO> memDtoL = memDAO.memSelList();
		// String vId, vPwd, vEmail, vName, vPhone, vAddr;

		ModelAndView mav = new ModelAndView();

		mav.addObject("memDtoL", memDtoL);
		mav.setViewName("springMemV01/MemSelFrame");

		return mav;

	}

}