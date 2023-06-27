package com.korea.tier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.tier.dao.ProductDAO;
import com.korea.tier.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	//xml에서 mapper를 거쳐 dao로 가서 service를 거쳐 impl인 여기까지 오기 위해서
	//productDAO를 생성자로 받는다.
	private final ProductDAO productDAO;
	
	//상품 조회
	@Override
	public List<ProductVO> getList() {
		return productDAO.findAll();
	}

	//상품 추가
	@Override
	public void register(ProductVO productVO) {
		productDAO.save(productVO);
	}

}
