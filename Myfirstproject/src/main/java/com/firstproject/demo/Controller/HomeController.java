package com.firstproject.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.firstproject.demo.entity.Laptop;
import com.firstproject.demo.repository.LaptopRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private LaptopRepository laptopRepository;
	
@GetMapping("/")
	public String Home() {
		return "/index";
	}
@GetMapping("/register")
    public String register() {
    	return "/Register";
    }
@GetMapping("/updateData")
    public String update() {
    	return "/updateData";
    }
	/*
	 * @PostMapping("/saveLaptopdata")
	 * 
	 * @ResponseBody
	 * 
	 * public String saveData(@RequestParam("id") int id,@RequestParam("brand")
	 * String brand,@RequestParam("price") String price) { Laptop laptop=new
	 * Laptop(id,brand,price); Laptop lap1=laptopRepository.save(laptop);
	 * System.out.println(lap1); return "Data saved successfully"; }
	 */
@PostMapping("/saveLaptopdata")
@ResponseBody
    public String saveData(Laptop laptop) {
	      laptopRepository.save(laptop);
	return "Data saved successfully";
}
@GetMapping("/getSingleLaptop/{id}")
public String getSingleLaptop(@PathVariable int id, HttpSession session) {
	Optional<Laptop> findById = laptopRepository.findById(id);
	Laptop laptop=findById.get();  
	session.setAttribute("laptop", laptop);
	return "/showSingleData";
	}

@GetMapping("/getAllLaptop")
public ModelAndView getAllLaptop(){
	ModelAndView mv=new ModelAndView();
	List<Laptop>findAllLaptop= laptopRepository.findAll();
	mv.addObject("AllLaptop", findAllLaptop);
	mv.setViewName("/showAllLaptopList");
	return mv;
}  
@PostMapping("/updateData")
@ResponseBody
public String updateLaptopData(Laptop laptop) {
	Laptop laptop1 = laptopRepository.save(laptop);
	System.out.println(laptop1); 
	return "Updated Successfully";
}

@GetMapping("/deleteData/{id}")
@ResponseBody
public String deleteData(@PathVariable int id) {
	Optional<Laptop> findById = laptopRepository.findById(id);
	Laptop laptop=findById.get();  
	if(laptop!=null) {
		laptopRepository.delete(laptop);
		
	}
	
	return "Data Deleted Successfully";
}
}
