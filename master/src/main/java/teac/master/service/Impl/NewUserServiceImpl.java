package teac.master.service.Impl;

import org.springframework.stereotype.Service;
import teac.comm.json.ResultForJson;
import teac.master.dao.UserDao;
import teac.master.service.NewUserService;

import javax.annotation.Resource;

/**
 * NewUserService实现
 * Created by yangzifeng on 2017/1/18.
 */
@Service
public class NewUserServiceImpl implements NewUserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public ResultForJson<Object> resign(String telephone, String password) {

        userDao.resign(telephone, password);
        return new ResultForJson.Builder<>().resultStatus(0).msg("注册成功").build();
    }
}
