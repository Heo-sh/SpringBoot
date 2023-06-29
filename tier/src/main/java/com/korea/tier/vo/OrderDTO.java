package com.korea.tier.vo;

import lombok.Data;

@Data
public class OrderDTO {
	//ProductVO의 필드와 OrderVO의 모든 필드
	//ProductVO
	private int productId;
	private String productName;
	private int productStock;
	private int productPrice;
	private String registerDate;
	private String updateDate;
	
	//OrderVO
	private int orderId;
	private int productCount;
	private String orderDate;
	private int orderPrice;
}
