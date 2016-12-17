package teac.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import teac.web.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 不同权限角色组跳转不同页面
 * 增加Ajax请求处理
 * Created by yangzifeng on 2016/12/5.
 */

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }


    private String determineTargetUrl(Authentication authentication) {
        String url;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roles = authorities.stream()
                .map((Function<GrantedAuthority, String>) GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        if (isSuper(roles)) {
            url = "/super";
        } else if (isAdmin(roles)) {
            url = "/admin";
        } else if(isRun(roles)){
            url = "/run";
        } else if(isOrgan(roles)){
            url = "/organ";
        } else if (isUser(roles)) {
            url = "/home";
        } else {
            url = "/";
        }

        return url;
    }

    private boolean isUser(List<String> roles) {
        return roles.contains("ROLE_USER");
    }

    private boolean isOrgan(List<String> roles){
        return roles.contains("ROLE_ORGAN");
    }

    private boolean isRun(List<String> roles){
        return roles.contains("ROLE_RUN");
    }

    private boolean isAdmin(List<String> roles) {
        return roles.contains("ROLE_ADMIN");
    }

    private boolean isSuper(List<String> roles) {
        return roles.contains("ROLE_SUPER");
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }


    /**
     * ajax登陆返回session
     * @param request
     * @param response
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication auth)
           throws IOException, ServletException {
        if (HttpUtil.isAjaxRequest(request)) {
           response.getWriter().print(
                   "ResultForJson:{success:true, targetUrl : \'"
                            + this.getTargetUrlParameter() + "\'}");
            response.getWriter().flush();
        } else {
            super.onAuthenticationSuccess(request, response, auth);
       }
    }
}



