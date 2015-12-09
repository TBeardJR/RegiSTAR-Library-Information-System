package com.smd.registar;

import java.util.ArrayList;

public class Cart {
	int numOfItems;
	   ArrayList<Item> items = new ArrayList<Item>();
	   double totalPrice;

	   int getNumberOfItems() {
	      return numOfItems;
	   }

	   void addItem(Item i) {
	      items.add(i);
	   } 

	   ArrayList<Item> getItems() {
	      return items;
	   }

	   double getTotalPrice() {
	      return totalPrice;
	   }
}
