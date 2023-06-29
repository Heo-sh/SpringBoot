package com.korea.tier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("list")				//@RequestParam(required = false): 해당 파라미터의 null값을 허용하겠다.
	public String list(Model model, @RequestParam(required = false)String sort) {
		if (sort == null) {
			sort = "recent";
		}
		model.addAttribute("sort", sort);
		model.addAttribute("orders", orderservice.getList(sort));
		return "order/order-list";
	}
}
