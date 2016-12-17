package teac.comm;

/**
 *
 * Created by yangzifeng on 2016/12/14.
 */
public class BaseUtil {

    /**
     * 根据类全名返回Class
     * @param beanName
     * @return
     */
    public static Class getBeanClassName(String beanName){
        try{
            return Class.forName(beanName).newInstance().getClass();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Object.class;
    }

}
