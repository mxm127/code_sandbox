package com.mxm.ujsojcodesandbox.model;

import lombok.Data;

/**
 * 判题信息
 */
@Data
public class JudgeInfo {

    /**
     * 程序执行信息
     */
    private String message;

    /**
     * 消耗内存（KB）
     */
    private long memory;
    /**
     * 消耗时间（ms）
     */
    private long time;

}
