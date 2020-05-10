package com.cloud.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.cloud.model.user.SmsVerify;

import java.util.List;

/**
 * <p>
 * 验证码发送记录 服务类
 * </p>
 *
 * @author luoliyin
 * @since 2018-06-25
 */
public interface ISmsVerifyService extends IService<SmsVerify> {

    /**
     * 根据手机号 验证码 和验证码类型查询
     * @param mobile 手机号
     * @param captcha 验证码
     * @param type 1：登录验证，2：注册验证，3：修改密码，4：修改账号
     * @return
     */
    List<SmsVerify> getByMobileAndCaptchaAndType(String mobile, String captcha, Integer type);
}
