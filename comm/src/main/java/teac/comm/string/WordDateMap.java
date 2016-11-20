package teac.comm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据可供做时间，已预约时间解析类
 *
 * 前端检查数据，如过有了14，就不能选择11，12，13
 * 如果选了81，就不能选择1~5
 *
 * Created by yangzifeng on 2016/11/16.
 */
public class WordDateMap {
    public static List<String> getWorkDate(String timeString) {
        List<String> list = new ArrayList<>();
        String[] strings = timeString.split(",");
        for (String s: strings) {
            switch (s){
                case "81" : list.add("周一到周五");

                case "11" : case "12" : case "13" :
                case "14" : parseTime(s,list,"周一",1); break;

                case "21" : case "22" : case "23" :
                case "24" : parseTime(s,list,"周二",2); break;

                case "31" : case "32" : case "33" :
                case "34" : parseTime(s,list,"周三",3); break;

                case "41" : case "42" : case "43" :
                case "44" : parseTime(s,list,"周四",4); break;

                case "51" : case "52" : case "53" :
                case "54" : parseTime(s,list,"周五",5); break;

                case "82" : list.add("周六周日"); break;

                case "61" : case "62" : case "63" :
                case "64" : parseTime(s,list,"周六",6); break;

                case "71" : case "72" : case "73" :
                case "74" : parseTime(s,list,"周日",7); break;
            }
        }
        return list;
    }

    private static void parseTime(String s, List<String> list, String week, int i){
        if((i+"4").equals(s)){
            list.add(week + "全天");
        }else if ((i+"1").equals(s)){
            list.add(week + "上午");
        }else if ((i+"2").equals(s)){
            list.add(week + "下午");
        }else if ((i+"3").equals(s)){
            list.add(week + "晚上");
        }

    }

    public static void main(String args[]) {
        List<String> list = getWorkDate("14,11,24,54");
        System.out.println(list.toString());
    }
}
