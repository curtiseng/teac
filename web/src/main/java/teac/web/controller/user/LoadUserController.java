package teac.web.controller.user;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import teac.comm.json.ResultForJson;
import teac.master.entity.UserInfo;
import teac.security.MyUser;

/**
 *
 * Created by yangzifeng on 2016/12/14.
 */

@RequestMapping("/user")
@Controller
public class LoadUserController {

    @RequestMapping("/load")
    public @ResponseBody ResultForJson loadUser(){
        MyUser user = (MyUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        UserInfo userInfo = user.getUserInfo();
        System.out.println(userInfo);
        System.out.println(user);
        return new ResultForJson.Builder<MyUser>().data(user).msg("success").resultStatus(0).build();
    }
}
