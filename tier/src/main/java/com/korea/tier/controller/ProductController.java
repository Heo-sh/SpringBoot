package com.korea.tier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.korea.tier.mapper.ProductMapper;
import com.korea.tier.service.ProductService;
import com.korea.tier.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // 생성자 주입을 위한 어노테이션
@RequestMapping("/product/*") //product 폴더 안에 잇는 모든 파일
public class ProductController {

//	@Autowired
//	private final ProductMapper productMapper;
	
	//interface
	private final ProductService productService;
	
	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("productVO", new ProductVO());
		return "product/product-register"; //html경로
	}

	@PostMapping("register")
	public RedirectView register(ProductVO productVO) {
		System.out.println(productVO.getProductName());
		productService.register(productVO);
		return new RedirectView("/product/list"); //mapping을 한 경로: 무조건 앞에 "/"를 붙여줘야 한다.
	}
	
	@GetMapping("list")
	public String list(Model model) {
		List<ProductVO> list = productService.getList(); 
		model.addAttribute("list", list);
		
		return "product/product-list";
	}
}
