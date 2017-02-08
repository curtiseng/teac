package teac.master.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 普通用户注册
 * Created by yangzifeng on 2017/1/16.
 */
@Repository
public interface UserDao {
    void resign(@Param("telephone") String telephone, @Param("password") String password);
    String checkByTelephone(String telephone);
}
