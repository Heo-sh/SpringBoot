package com.korea.tier.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.korea.tier.mapper.ProductMapper;
import com.korea.tier.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
	
	//기존에는 session을 주입받아 xml에 접근했다면 이제는 mapper를 통해 xml에 접근한다.
	//DAO는 mapper를 생성자를 통해 주입받는다.
	private final ProductMapper productMapper;
	
	//상품 조회
	public List<ProductVO> findAll() {
		return productMapper.select();
	}
	
	//상품 추가
	public void save(ProductVO productVO) {
		productMapper.insert(productVO);
	}
}
