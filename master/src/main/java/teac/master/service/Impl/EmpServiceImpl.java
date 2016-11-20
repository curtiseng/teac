package teac.master.service.Impl;

import org.springframework.stereotype.Service;
import teac.master.dao.EmpPo;
import teac.master.service.EmpService;

import javax.annotation.Resource;

/**
 *
 * Created by yangzifeng on 2016/11/7.
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Resource(name = "empPo")
    private EmpPo empPo;

    public String listEmp() {
        return "master:"+empPo.findAll();
    }
}
