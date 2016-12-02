package com;

import org.junit.Test;
import teac.comm.json.ResultForJson;

/**
 *
 * Created by yangzifeng on 2016/11/16.
 */
public class TestCase {

    @Test
    public void test() {
        ResultForJson<String> resultForJson =
                new ResultForJson.Builder<String>().resultStatus(0).data("hello").msg("test").build();

        System.out.println(resultForJson);
    }

}
