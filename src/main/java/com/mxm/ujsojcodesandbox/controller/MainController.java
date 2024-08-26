package com.mxm.ujsojcodesandbox.controller;

import com.mxm.ujsojcodesandbox.JavaCodeSandboxTemplate;
import com.mxm.ujsojcodesandbox.JavaDockerCodeSandBox;
import com.mxm.ujsojcodesandbox.JavaNativeCodeSandBox;
import com.mxm.ujsojcodesandbox.model.ExecuteCodeRequest;
import com.mxm.ujsojcodesandbox.model.ExecuteCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MainController {

    public static final String AUTH_REQUEST_HEADER = "auth";

    public static final String AUTH_REQUEST_SECRET = "secretKey";

    @Resource
    private JavaCodeSandboxTemplate javaNativeCodeSandBox;

    @Resource
    private JavaDockerCodeSandBox javaDockerCodeSandBox;

    @GetMapping("/health")
    public String healthCheck() {
        return "ok";
    }

    @PostMapping("/executeCode")
    public ExecuteCodeResponse executeCode(@RequestBody ExecuteCodeRequest executeCodeRequest, HttpServletRequest request, HttpServletResponse response) {
        String authHeader = request.getHeader(AUTH_REQUEST_HEADER);
        if (!AUTH_REQUEST_SECRET.equals(authHeader)) {
            response.setStatus(403);
            return null;
        }
        if (executeCodeRequest == null) {
            throw new RuntimeException("请求参数为空");
        }
        return javaNativeCodeSandBox.executeCode(executeCodeRequest);
    }
}
