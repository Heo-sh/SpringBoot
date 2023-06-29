package com.korea.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korea.rest.service.ProductService;
import com.korea.rest.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product/*")
public class ProductController {
	
	private final ProductService productService;
	
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("productForm", new ProductVO());
		model.addAttribute("list", productService.getList());
		return "product/product-list";
	}
}
