package com.cloud.user.zklock.utils;

/**
 * @Description: TODO
 * @Author luoliyin
 * @Date 2020/7/30
 **/

public interface DistributedLock {
    /**
     * 阻塞式锁
     * @return
     */
    void lock();

    /**
     * 非阻塞式锁
     * @return
     */
    boolean tryLock();

    /**
     * 带超时时间的阻塞式锁
     * @param timeout
     * @return
     */
    boolean tryLock(long timeout);

    /**
     * 解锁
     */
    void unLock() throws Exception;

    /**
     * 释放资源
     */
    void shutdown();

}
