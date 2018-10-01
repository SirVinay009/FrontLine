package com.frontline.dao;

import java.util.List;

import com.frontline.model.CartItemPurchase;

public interface CartItemDAO {

	public boolean addCartItemPurchase(CartItemPurchase cartitempurchase);
	public boolean deleteCartItemPurchase(CartItemPurchase cartitempurchase);
	public boolean updateCartItemPurchase(CartItemPurchase cartitempurchase);
	public List<CartItemPurchase> retrieveCartItemsPurchase(String username);
	public CartItemPurchase getCartItemPurchase(int cartitempurchaseid);
	
}
