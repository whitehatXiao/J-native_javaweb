package com.whx.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public class Cart {

    //
    // private Integer totalCount;
    // private BigDecimal totalPrice;

    private Map<Integer , CartItem> items = new LinkedHashMap<>();

    public Cart() {
    }

    public Cart( Map<Integer, CartItem> items) {
        this.items = items;
    }

    public void addItem(CartItem cartItem){

        CartItem item = items.get(cartItem.getId());

        if(item == null){
            items.put(cartItem.getId() , cartItem);
        }else{
            item.setCount(item.getCount() + 1 );
            // item.setTotalPrice( item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }


    public void deleteItem(Integer id){
        items.remove(id);
    }

    public void clear(){
        items.clear();
    }


    public void updateCount(Integer id , Integer Count){
        CartItem item = items.get(id);
        if(item!=null){
            item.setCount(Count);
        }
    }





    public Integer getTotalCount() {
        Integer totalCount = 0  ;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice =  totalPrice.add(entry.getValue().getTotalPrice());
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
