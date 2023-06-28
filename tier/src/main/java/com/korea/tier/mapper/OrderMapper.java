package com.korea.tier.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.tier.vo.OrderVO;

@Mapper
public interface OrderMapper {
	
	//주문하기
	public void insert(OrderVO orderVO);
	
	//조회하기
	public List<OrderVO> select();
}
