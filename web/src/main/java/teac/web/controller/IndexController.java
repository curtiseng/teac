package teac.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import teac.web.util.ControllerUtil;
import teac.web.util.HttpUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 进入首页
 * Created by yangzifeng on 2016/12/6.
 */
@Controller
public class IndexController {

    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request, HttpServletResponse response) {
        if (HttpUtil.isAjaxRequest(request)){
            return "forward:/ajaxLogin";
        }
        return ControllerUtil.getView("login");
    }

    @RequestMapping(value = {"/", "/home"})
    public String toIndex() {
        return ControllerUtil.getView("index");
    }

    @RequestMapping(value = {"/admin","/admin/index"})
    public String toAdminIndex() {
        return "admin/index";
    }

    @RequestMapping(value = {"/organ","/organ/index"})
    public String toOrganIndex() {
        return "organ/index";
    }

    @RequestMapping(value = {"/run","/run/index"})
    public String toRunIndex() {
        return "run/index";
    }
}
