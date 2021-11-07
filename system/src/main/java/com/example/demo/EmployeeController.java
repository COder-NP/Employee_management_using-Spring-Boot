package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class EmployeeController {

	@Autowired
	private EmployeService serve;

	@GetMapping("/home")
	public String home(Model m)
	{

		List<Employee> emp =serve.getAllEmp();
		m.addAttribute("emp",emp);
		return"index";
	}

	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return"add_emp";
	}

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.println(e);

		serve.AddEmp(e);
		session.setAttribute("msg", "Employee Added Sucessfully....!");
		return"redirect:/home";


	}


	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		Employee  e=serve.getEMpById(id);
		m.addAttribute("emp",e);
		return"edit";
	}


	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session)
	{
		serve.AddEmp(e);

		session.setAttribute("msg", "Employee data updated Sucessfully....!");
		return"redirect:/home";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session)
	{

		serve.deleteEMp(id);
		session.setAttribute("msg", "Employee data delete Sucessfully....!");
		return "redirect:/home";
	}
	
	@GetMapping("/view/{id}")
	public String ViewEmp(@PathVariable int id, Model m)
	{
		Employee  e =serve.getEMpById(id);
		m.addAttribute("emp",e);
		return"view";
	}
}
