package teac.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import teac.master.service.EmpService;
import teac.organ.service.OEmpService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by yangzifeng on 2016/11/7.
 */
@Controller
public class EmpController {
    //子模块master中的service
    @Resource(name = "empServiceImpl")
    private EmpService empService;
    //子模块organization里的service
    @Resource(name = "OEmpServiceImpl")
    private OEmpService oEmpService;

    @RequestMapping("master")
    public String getEmp(HttpServletRequest request) {
        String str = empService.listEmp();
        request.setAttribute("msg",str);
        return "show";
    }

    @RequestMapping("organ")
    public String getOEmp(HttpServletRequest request) {
        String str = oEmpService.listEmp();
        request.setAttribute("msg",str);
        return "show";
    }

}
