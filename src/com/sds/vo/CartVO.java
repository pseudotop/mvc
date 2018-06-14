package com.sds.vo;

import java.util.ArrayList;

public class CartVO {
		
		ArrayList<String> items = new ArrayList<>(); 
		
		private String id;
		private String name;
		private double price;

		public CartVO() {
			super();
		}

		public CartVO(ArrayList<String> items, String id, String name, double price) {
			this.items = items;
			this.id = id;
			this.name = name;
			this.price = price;
		}
		
		public CartVO(ArrayList<String> items) {
			this.items = items;
		}

		public ArrayList<String> getItems() {
			return items;
		}

		public void setItems(ArrayList<String> items) {
			this.items = items;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "CartVO [items=" + items + ", id=" + id + ", name=" + name + ", price=" + price + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((items == null) ? 0 : items.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CartVO other = (CartVO) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (items == null) {
				if (other.items != null)
					return false;
			} else if (!items.equals(other.items))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
				return false;
			return true;
		}
}
