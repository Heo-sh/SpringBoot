package com.korea.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.rest.dao.OrderDAO;
import com.korea.rest.dao.ProductDAO;
import com.korea.rest.vo.OrderDTO;
import com.korea.rest.vo.OrderVO;

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
	
	//주문 내역 조회하기
	public List<OrderDTO> getList(String sort) {
		return orderDAO.findAll(sort);
	}
}
