package mc.sn.buyus.ybjController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import mc.sn.buyus.ybjService.CountService;
import mc.sn.buyus.ybjVO.CountVO2;

@Controller("countController")
public class CountController {

	@Autowired
	private CountService service;

	
	
// 하나씩
//	@ResponseBody
//	@RequestMapping(value = "count/{Genre}", method = RequestMethod.GET)
//	public void countGenre1(@PathVariable("Genre") String genre){
//		service.countGenre(genre);
//	}
	
	@ResponseBody
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public String countGenre1(){
		CountVO2 vo=new CountVO2();
		vo=service.countGenre();
		String json=new Gson().toJson(vo);
		System.out.println(json);
		return json;
	}
}
