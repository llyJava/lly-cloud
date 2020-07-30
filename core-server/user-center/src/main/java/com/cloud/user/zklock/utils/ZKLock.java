package com.cloud.user.zklock.utils;

/**
 * @Description: TODO
 * @Author luoliyin
 * @Date 2020/7/30
 **/

import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * zk分布式锁
 */
public class ZKLock implements DistributedLock {
    private CuratorFramework client;

    private InterProcessMutex lock;

    public ZKLock(String host, String bizType, String lockKey) {
        client = CuratorFrameworkFactory.newClient(host,new ExponentialBackoffRetry(ZKLockConstant.BASE_SLEEP_TIME_MS, ZKLockConstant.MAX_RETRIES));
        client.start();

        String path = ZKLockConstant.ZK_SEPERATOR + StringUtils.join(Arrays.asList(ZKLockConstant.ZK_LOCK_BASE_PREFIX, bizType, lockKey), ZKLockConstant.ZK_SEPERATOR);
        lock = new InterProcessMutex(client, path);
    }

    @Override
    public void lock() {
        try {
            lock.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean tryLock() {
        return tryLock(0);
    }

    @Override
    public boolean tryLock(long timeout) {
        try {
            return lock.acquire(timeout, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void unLock() throws Exception {
        lock.release();
    }

    @Override
    public void shutdown() {
        client.close();
    }
}
