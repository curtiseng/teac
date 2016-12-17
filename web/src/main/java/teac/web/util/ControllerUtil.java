package teac.web.util;

/**
 *
 * Created by yangzifeng on 2016/12/6.
 */
public class ControllerUtil {

    /**
     * 切换themes下的模版，默认default
     * @param url
     * @return
     */
    public static String getView(String url) {
        return "default/"+url;
    }
}
