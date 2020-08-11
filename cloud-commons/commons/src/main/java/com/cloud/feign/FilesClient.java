package com.cloud.feign;

import com.cloud.config.FeignInterceptorConfig;
import com.cloud.utils.ResultHelper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/8.
 */


@FeignClient(value = "files-server",configuration = FeignInterceptorConfig.class,url = "http://127.0.0.1:8090/files")
public interface FilesClient {


    @PostMapping("/info")
    //增加熔断策略 https://blog.csdn.net/feijiing/article/details/100020836?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param
    //https://blog.csdn.net/weixin_43442246/article/details/90675925?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522159714046619724811854340%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=159714046619724811854340&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v3~pc_rank_v2-1-90675925.first_rank_ecpm_v3_pc_rank_v2&utm_term=hystrix+%E7%86%94%E6%96%AD%E7%AD%96%E7%95%A5%E9%85%8D%E7%BD%AE&spm=1018.2118.3001.4187
    @HystrixCommand(commandKey = "hello",fallbackMethod = "com.cloud.files.service.impl.FileInfoServiceImpl.fallback",threadPoolProperties = {
            @HystrixProperty(name = "coreSize",value = "2"), // 线程核心数目
            @HystrixProperty(name = "maxQueueSize",value="3") // 线程池队列大小

    },commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD"), // 使用线程池隔离
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000" ) // hystrix 超时时间
    })
    ResultHelper insertFileInfo(@RequestParam(name = "name") String name,
                                @RequestParam(name = "applicationName") String applicationName,
                                @RequestParam(name = "contentType") String contentType,
                                @RequestParam(name = "size") Long size,
                                @RequestParam(name = "url") String url,
                                @RequestParam(name = "createUser") String createUser) throws Exception ;

    @PostMapping("/selectFilesByIds")
    List<Map> selectFilesByIds(@RequestBody String[] ids);
}
