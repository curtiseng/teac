package teac.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import teac.comm.json.ResultForJson;

/**
 * 处理ajax登陆
 * Created by yangzifeng on 2016/12/17.
 */
@Controller
public class AjaxLoginController {

    @RequestMapping("/ajaxLogin")
    public @ResponseBody ResultForJson execute() {

        return new ResultForJson.Builder<String>().msg("你还没有登陆！").resultStatus(1).build();
    }
}
