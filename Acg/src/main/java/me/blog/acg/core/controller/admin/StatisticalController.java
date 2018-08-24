package me.blog.acg.core.controller.admin;

import me.blog.acg.commons.CommonResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class StatisticalController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getUserStatistical")
    public CommonResponse getUserStatistical(){
        return new CommonResponse();
    }
}
