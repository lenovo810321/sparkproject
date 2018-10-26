package com.tongling.dao;

import com.tongling.domain.Task;

/**
 * 任务管理DAO接口
 * Created by 张宝玉 on 2018/10/13.
 */
public interface ITaskDAO {
    //根据主键查询业务
    Task findById(long taskid);
}
