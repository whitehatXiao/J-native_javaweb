package com.whx.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WhitehatXiao
 * @date 2022/9/28
 * @descriptions  购物车对象 ，  a new level of abstraction
 */
public class Cart {


    // private Integer totalCount;
    // private BigDecimal totalPrice;
    // private List<CartItem> items = new ArrayList<>();
    private Map<Integer , CartItem> items = new LinkedHashMap<Integer,CartItem>();

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }


    public void addItem(CartItem cartItem){

        CartItem item = items.get(cartItem.getId());
        if( item == null){
            items.put(cartItem.getId(), cartItem);
        }else {
            item.setCount(cartItem.getCount()+1);
            item.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }

    }

    public void deleteItem(Integer id ){

        items.remove(id);

    }

    public void clear(){
        items.clear();
    }

    public void updateItem( Integer id , int count){
        CartItem cartItem = items.get(id);
        cartItem.setCount(count);
    }


    public Integer getTotalCount() {
        Integer totalCount = 0;

        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount +=entry.getValue().getCount();
        }
        //
        // for (CartItem value : items.values()) {
        //     totalCount += value.getCount();
        // }

        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add( entry.getValue().getTotalPrice());
        }

        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
