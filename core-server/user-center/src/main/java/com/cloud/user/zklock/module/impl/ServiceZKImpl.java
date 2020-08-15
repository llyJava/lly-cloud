package com.cloud.user.zklock.module.impl;

import com.cloud.user.zklock.ZkLock;
import com.cloud.user.zklock.module.ServiceTests;

/**
 * @Description: TODO
 * @Author luoliyin
 * @Date 2020/7/30
 **/

public class ServiceZKImpl implements ServiceTests {

    @Override
    @ZkLock(zkHost = "192.168.160.128:2181", bizType = "test", lockKey = "queryKeyValue", timeout = 3000)
    public String queryKeyValue(String bizType, String key) {
        return null;
    }
}
