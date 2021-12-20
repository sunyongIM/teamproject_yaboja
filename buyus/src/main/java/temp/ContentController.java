package temp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller("contentController")
@RequestMapping("/content/*")
public class ContentController {

//	@Autowired
//	ContentService contentservice;
	
	@ResponseBody
	@RequestMapping(value="/contentSelecterByTitle", method = RequestMethod.GET)
	public ModelAndView contentSelecterByTitle(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView();
		String url = "/App";
		mav.setViewName(url);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/contentSelecterByOtt", method = RequestMethod.GET)
	public ModelAndView contentSelecterByOtt(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView();
		String url = "/App";
		mav.setViewName(url);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/contentSelecterByDate", method = RequestMethod.GET)
	public ModelAndView contentSelecterByDate(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView();
		String url = "/App";
		mav.setViewName(url);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/contentSelecterByProducer", method = RequestMethod.GET)
	public ModelAndView contentSelecterByProducer(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView();
		String url = "/App";
		mav.setViewName(url);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/contentSelecterByProduceCom", method = RequestMethod.GET)
	public ModelAndView contentSelecterByProduceCom(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView();
		String url = "/App";
		mav.setViewName(url);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/contentSelecterByActor", method = RequestMethod.GET)
	public ModelAndView contentSelecterByActor(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView();
		String url = "/App";
		mav.setViewName(url);
		return mav;
	}
}
