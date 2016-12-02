package teac.master.dao;

import org.springframework.stereotype.Repository;
import teac.master.entity.Emp;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by yangzifeng on 2016/11/7.
 */
@Repository
public interface EmpPo {
    List<Emp> findAll();
}
