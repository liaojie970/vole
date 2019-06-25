package com.github.vole.passport.server.fegin;

import com.github.vole.passport.server.entity.vo.SysUserVO;
import com.github.vole.passport.server.service.fallback.UserServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "vole-portal-data", fallback = UserServiceFallbackImpl.class)
public interface UserService {
    /**
     * 通过用户名查询用户、角色信息
     *
     * @param loginname 用户名
     * @return UserVo
     */
    @RequestMapping(value = "/user/findUserByLoginname/{loginname}", method = RequestMethod.GET)
    SysUserVO findUserByUsername(@PathVariable("loginname") String loginname);

}
