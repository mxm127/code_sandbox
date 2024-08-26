package com.mxm.ujsojcodesandbox;

import com.mxm.ujsojcodesandbox.model.ExecuteCodeRequest;
import com.mxm.ujsojcodesandbox.model.ExecuteCodeResponse;

public interface CodeSandBox {

    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
