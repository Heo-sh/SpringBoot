package com.korea.tier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.korea.tier.service.OrderService;
import com.korea.tier.vo.OrderVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order/*")
public class OrderController {
	
	private final OrderService orderservice;
	
//	@GetMapping("order") //localhost:10000/order/order
//	public String order() {
//		OrderVO vo = new OrderVO();
//		vo.setProductId(4);
//		vo.setProductCount(50);
//		//service의 이점: controller와 service 단의 분리로 인해 service에서만 기능을 추가하면
//		//controller에서 dao를 주입받을 이유가 없어진다. 아주 유용함.
//		orderservice.order(vo);
//		return null;
//	}
	
	@GetMapping("done")
	public RedirectView order(OrderVO orderVO) {
		System.out.println("주문개수: " + orderVO.getProductCount());
		orderservice.order(orderVO);
		
		return new RedirectView("/product/list");
	}
	
	@GetMapping("order-list")
	public String o_list(Model model) {
		model.addAttribute("list", orderservice.findAll());
		return "order/order-list";
	}
}
