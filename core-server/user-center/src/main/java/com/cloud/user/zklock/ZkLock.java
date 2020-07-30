package com.cloud.user.zklock;

/**
 * @Description: TODO
 * @Author luoliyin
 * @Date 2020/7/30
 **/

import java.lang.annotation.*;

/**
 * ZK分布式锁注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZkLock {
    /**
     * zk地址
     *
     * @return
     */
    String zkHost();

    /**
     * 业务类型
     */
    String bizType();

    /**
     * 锁名称
     *
     * @return
     */
    String lockKey();

    /**
     * 超时时间
     *
     * @return
     */
    long timeout();
}