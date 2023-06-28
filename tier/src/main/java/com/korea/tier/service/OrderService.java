package com.korea.tier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.tier.dao.OrderDAO;
import com.korea.tier.dao.ProductDAO;
import com.korea.tier.vo.OrderVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderDAO orderDAO;
	//재고 수정을 위한 ProductDAO 주입
	private final ProductDAO productDAO;
	
//	//주문하기
//	public void order(OrderVO orderVO) {
//		orderDAO.save(orderVO);
//	}

	//주문하기 & 재고 수정
	public void order(OrderVO orderVO) {
		orderDAO.save(orderVO); //주문
		productDAO.setProductStock(orderVO); //상품 재고 수정
	}
	
	//조회하기
	public List<OrderVO> findAll() {
		return orderDAO.findAll();
	}
}
