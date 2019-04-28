package org.ssm.dufy.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Goods implements Serializable {

    private Integer id;
    
    private Integer price;
    
    private Integer num;
    
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
    
    
}
