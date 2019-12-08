package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Student;
import com.example.demo.service.ServiceI;



@Controller
public class HomeController {

	@Autowired
	private ServiceI s;
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("reg")
	public String register(@ModelAttribute Student student)
	{
		System.out.println("In reg controller");
		s.addStudent(student);
		return "index";
		
	}
	
	@RequestMapping("log")
	public String log(@ModelAttribute Student student, Model m)
	{
		System.out.println("in log controller");
		
		List<Student> list= s.login(student);
		
		m.addAttribute("data", list);
		for (Student stu : list) {
			if(student.getUname().equals(stu.getUname()) && student.getPass().equals(stu.getPass()))
			{
				System.out.println("Checked");
				return "success";
			}
		}
		return "index";	
		
	}
	
	@RequestMapping("edit")
	public String editData(@RequestParam("rd") int id, Model m)
	{
		System.out.println("In Edit controller");
		System.out.println(id);
		Student s1=s.edit(id);
		m.addAttribute("data", s1);
		return "edit";
		
	}
	
	@RequestMapping("up")
	public String update(@ModelAttribute Student student, Model m)
	{
		System.out.println("In Controller Update");
		List<Student> list= s.update(student);
		m.addAttribute("data", list);
		return "success";
		
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam ("rd")int id, Model m)
	{
		System.out.println(id);
		System.out.println("In Controller Delete");
		List<Student> list= s.delete(id);
		m.addAttribute("data", list);
		return "success";
		
	}
}
