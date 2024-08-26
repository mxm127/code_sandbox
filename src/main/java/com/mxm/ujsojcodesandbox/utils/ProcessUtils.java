package com.mxm.ujsojcodesandbox.utils;

import com.mxm.ujsojcodesandbox.model.ExecuteMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StopWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessUtils {

    /**
     * 执行进程并获取信息
     * @param runProcess
     * @param opName
     * @return
     */
    public static ExecuteMessage runProcessAndGetMessage(Process runProcess,String opName) {

        ExecuteMessage executeMessage = new ExecuteMessage();
        StopWatch stopWatch = new StopWatch();

        //            等待程序执行，并获取返回值

        try {
            stopWatch.start();
            int exitValue = runProcess.waitFor();
            stopWatch.stop();
            executeMessage.setTime(stopWatch.getLastTaskTimeMillis());
            executeMessage.setExitValue(exitValue);
            if (exitValue == 0) {
                System.out.println(opName + "成功");
//                获取进程的正常输出
                BufferedReader compileBufferedReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
                List<String> outputStrList = new ArrayList<>();
//                逐行读取
                String compileOutputLine;
                while ((compileOutputLine = compileBufferedReader.readLine()) != null) {
                    outputStrList.add(compileOutputLine);
                }
                executeMessage.setMessage(StringUtils.join(outputStrList,"\n"));
            } else {
                System.out.println(opName + "失败");
                //                获取进程的正常输出
                BufferedReader compileBufferedReader = new BufferedReader(new InputStreamReader(runProcess.getErrorStream()));
                List<String> outputStrList = new ArrayList<>();
//                逐行读取
                String compileOutputLine;
                while ((compileOutputLine = compileBufferedReader.readLine()) != null) {
                    outputStrList.add(compileOutputLine);
                }
                executeMessage.setMessage(StringUtils.join(outputStrList,"\n"));

//                获取进程的错误输出
                BufferedReader errorBufferedReader = new BufferedReader(new InputStreamReader(runProcess.getErrorStream()));
                List<String> outputErrStrList = new ArrayList<>();
//                逐行读取
                String compileErrOutputLine;
                while ((compileErrOutputLine = compileBufferedReader.readLine()) != null) {
                    outputErrStrList.add(compileErrOutputLine);
                }
                executeMessage.setErrorMessage(StringUtils.join(outputErrStrList,"\n"));
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return executeMessage;
    }
}
