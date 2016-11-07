package teac.core.service.Impl;

import org.springframework.stereotype.Service;
import teac.core.service.EmpService;
import teac.core.service.OEmpService;

import javax.annotation.Resource;

/**
 *
 * Created by yangzifeng on 2016/11/7.
 */
@Service
public class OEmpServiceImpl implements OEmpService {
    @Resource(name = "empServiceImpl")
    private EmpService empService;
    public String listEmp() {
        String str = empService.listEmp();
        return "organ:" + str.substring(str.indexOf("["));
    }
}
