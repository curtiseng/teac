package teac.master.service;

import teac.comm.json.ResultForJson;

/**
 * 新用户注册
 * Created by yangzifeng on 2017/1/18.
 */
public interface NewUserService {
    ResultForJson<Object> resign(String telephone, String password);
}
