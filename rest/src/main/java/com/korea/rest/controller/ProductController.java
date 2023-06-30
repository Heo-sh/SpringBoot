package com.korea.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PostMapping("new")
	@ResponseBody //Ajax를 사용할 때 쓰는 어노테이션
	//@RequestBody: ProductVO에 있는 필드들이 JSON의 Key값으로 잡힌다.
	public void register(@RequestBody ProductVO productVO) {
		productService.register(productVO);
	}
	
	@GetMapping("/{productId}")
	@ResponseBody
	public ProductVO getProductVO(@PathVariable("productId") int productId) {
		return productService.getProduct(productId);
	}
}
