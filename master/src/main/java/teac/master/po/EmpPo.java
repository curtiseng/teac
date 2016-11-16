package teac.master.po;

import org.springframework.stereotype.Repository;
import teac.master.data.Emp;

import java.util.List;

/**
 *
 * Created by yangzifeng on 2016/11/7.
 */
@Repository
public interface EmpPo {
    List<Emp> findAll();
}
