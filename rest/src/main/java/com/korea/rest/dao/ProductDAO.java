package com.korea.rest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.korea.rest.mapper.ProductMapper;
import com.korea.rest.vo.OrderVO;
import com.korea.rest.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
	
	//기존에는 session을 주입받아 xml에 접근했다면 이제는 mapper를 통해 xml에 접근한다.
	//DAO는 mapper를 생성자를 통해 주입받는다.
	private final ProductMapper productMapper;
	
	//상품 조회
	public List<ProductVO> findAll() {
		return productMapper.selectAll();
	}
	
	//상품 추가
	public void save(ProductVO productVO) {
		productMapper.insert(productVO);
	}
	
	//상품 재고 수정
	public void setProductStock(OrderVO orderVO) {
		productMapper.updateStock(orderVO);
	}
	
	//주문한 상품 조회
	public ProductVO getProduct(int productId) {
		return productMapper.select(productId);
	}
}
