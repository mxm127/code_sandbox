package com.mxm.ujsojcodesandbox.securitymanager;

public class MySecurityManager extends SecurityManager{
    /**
     * 限制执行
     * @param cmd   the specified system command.
     */
    @Override
    public void checkExec(String cmd) {
        super.checkExec(cmd);
    }

    /**
     * 限制读
     * @param file   the system-dependent file name.
     */
    @Override
    public void checkRead(String file) {
        super.checkRead(file);
    }

    /**
     * 限制写
     * @param file   the system-dependent filename.
     */
    @Override
    public void checkWrite(String file) {
        super.checkWrite(file);
    }

    /**
     * 限制网络连接
     * @param host   the host name port to connect to.
     * @param port   the protocol port to connect to.
     */
    @Override
    public void checkConnect(String host, int port) {
        super.checkConnect(host, port);
    }
}
