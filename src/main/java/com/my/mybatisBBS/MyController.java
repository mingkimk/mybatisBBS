package com.my.mybatisBBS;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.DTO.MemberDTO;
import com.my.service.ControllerToModel;

@Controller
public class MyController {
	
	@Autowired  // bean을 주입하는 방식 이때  ControllerToModel 타입으로 주입
	ControllerToModel tomodel;
	
	@RequestMapping("bbsConlist")
	public String list(Model model) {
		
		model.addAttribute("list", tomodel.selectAll() );
	//	System.out.println("DB에서 가져온 튜플 수 :"+dTOs.size());
		return "/bbs/list";
	}
	@RequestMapping("bbsConinput")
	public String inputform() {
		return "/bbs/input";
	}
	
	@RequestMapping("bbsConinputprocess")
	public String inputDB(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println(id+"/"+name);
		tomodel.insert(id, name);
		//mybatis 접근해서 전달하면 되죠??
		return "redirect:list";
	}
	@RequestMapping("bbsCondel")
	public String del(HttpServletRequest request) {
		String id = request.getParameter("id");
		tomodel.del(id);
		return "redirect:list";
	}
	@RequestMapping("bbsConmodify")
	public String mod(@RequestParam("id") String id, Model model) {
		model.addAttribute("userInfo", tomodel.selectOne(id) );
		return "/bbs/modify";
	}
	@RequestMapping("bbsConmodifyprocess_bak")
	public String modp(@ModelAttribute MemberDTO user) {
		//System.out.println(user.getId());
		//System.out.println(user.getName());
		tomodel.modify(user);
		return "redirect:list";
	}
	
	@RequestMapping("bbsConmodifyprocess")
	public String modpHash(HttpServletRequest request) {
		HashMap<String,String> h=new HashMap();
		h.put("id",request.getParameter("id"));
		h.put("name", request.getParameter("name"));
		tomodel.modifyhash(h);
		//mybatis 접근해서 전달하면 되죠??
		return "redirect:list";
	}
}








