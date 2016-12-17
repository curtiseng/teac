package teac.web.util;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by yangzifeng on 2016/12/17.
 */
public class HttpUtil {

    public static boolean isAjaxRequest(HttpServletRequest request) {

        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            return true;
        }
        return false;
    }
}
