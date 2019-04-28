package org.ssm.dufy.service;

import java.util.List;

import org.ssm.dufy.entity.Goods;

public interface DemoService {

    
   public  List queryAllRecord(String id);
    
   public void updatePrice(Integer id,Integer price);
}
