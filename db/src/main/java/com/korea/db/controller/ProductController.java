package com.korea.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.korea.db.mapper.ProductMapper;
import com.korea.db.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //생성자 주입을 위한 어노테이션
public class ProductController {

	@Autowired
	private final ProductMapper productMapper;
	
	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("productVO", new ProductVO());
		return "product-register";
	}
}
