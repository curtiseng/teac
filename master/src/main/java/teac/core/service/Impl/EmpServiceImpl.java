package teac.core.service.Impl;

import org.springframework.stereotype.Service;
import teac.core.po.EmpPo;
import teac.core.service.EmpService;

import javax.annotation.Resource;

/**
 *
 * Created by yangzifeng on 2016/11/7.
 */
@Service
public class EmpServiceImpl implements EmpService{
    @Resource(name = "empPo")
    private EmpPo empPo;

    public String listEmp() {
        return "master:"+empPo.findAll();
    }
}
