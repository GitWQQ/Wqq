package org.ssm.dufy.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import org.ssm.dufy.entity.Goods;

public interface DemoDao {
    
    public List queryAllRecord(Integer id);    
    
    public void updatePrice(Goods goods);
}
