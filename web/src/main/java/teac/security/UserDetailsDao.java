package teac.security;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import teac.comm.BaseUtil;
import teac.master.entity.UserInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义User
 * Created by yangzifeng on 2016/12/14.
 */
public class UserDetailsDao extends JdbcDaoImpl {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetails> users = loadUsersByUsername(username);

        if (users.size() == 0) {
            logger.debug("Query returned no results for user '" + username + "'");

            throw new UsernameNotFoundException(messages.getMessage(
                    "JdbcDaoImpl.notFound", new Object[] { username },
                    "Username {0} not found"));
        }

        UserDetails user = users.get(0);

        Set<GrantedAuthority> dbAuthsSet = new HashSet<>();

        if (getEnableAuthorities()) {
            dbAuthsSet.addAll(loadUserAuthorities(user.getUsername()));
        }

        if (getEnableGroups()) {
            dbAuthsSet.addAll(loadGroupAuthorities(user.getUsername()));
        }

        List<GrantedAuthority> dbAuths = new ArrayList<>(dbAuthsSet);

        addCustomAuthorities(user.getUsername(), dbAuths);

        if (dbAuths.size() == 0) {
            logger.debug("User '" + username
                    + "' has no authorities and will be treated as 'not found'");

            throw new UsernameNotFoundException(messages.getMessage(
                    "JdbcDaoImpl.noAuthority", new Object[] { username },
                    "User {0} has no GrantedAuthority"));
        }

        return createUserDetails((MyUser) user, dbAuths);
    }


    @Override
    protected List<UserDetails> loadUsersByUsername(String username) {
        return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[] { username },
                (rs, rowNum) -> {
                    String username1 = rs.getString("username");
                    String password = rs.getString("password");
                    boolean enabled = rs.getBoolean("enabled");
                    MyUser user =  new MyUser(username1, password, enabled, true, true, true,
                            AuthorityUtils.NO_AUTHORITIES);

                    user.setUserInfo((UserInfo) new BeanPropertyRowMapper(
                            BaseUtil.getBeanClassName("teac.master.entity.UserInfo")).mapRow(rs, rowNum));
                    return user;
                });
    }

    protected UserDetails createUserDetails(MyUser myUser, List<GrantedAuthority> combinedAuthorities) {
        String returnUsername = myUser.getUsername();

        MyUser newUser = new MyUser(returnUsername, myUser.getPassword(),
                myUser.isEnabled(), true, true, true, combinedAuthorities);
        newUser.setUserInfo(myUser.getUserInfo());

        return newUser;
    }
}
