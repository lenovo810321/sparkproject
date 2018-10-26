package com.tongling.dao.impl;

import com.tongling.dao.ITaskDAO;
import com.tongling.domain.Task;
import com.tongling.jdbc.JDBCHelper;

import java.sql.ResultSet;

/**
 * 任务管理DAO实现类
 * Created by 张宝玉 on 2018/10/13.
 */
public class TaskDAOImpl implements ITaskDAO {

    /**
     * 根据主键查询任务
     * @param taskid
     * @return
     */
    @Override
    public Task findById(long taskid) {
        final Task task = new Task();

        String sql = "select * from task where task_id=?";
        Object[] params = new Object[]{taskid};

        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        jdbcHelper.executeQuery(sql, params, new JDBCHelper.QueryCallback() {
            @Override
            public void process(ResultSet rs) throws Exception {
                if (rs.next()) {
                    long taskid = rs.getLong(1);
                    String taskName = rs.getString(2);
                    String createTime = rs.getString(3);
                    String startTime = rs.getString(4);
                    String finishiTime = rs.getString(5);
                    String taskType = rs.getString(6);
                    String taskStatus = rs .getString(7);
                    String taskParama = rs.getString(8);

                    task.setTaskid(taskid);
                    task.setTaskName(taskName);
                    task.setCreateTime(createTime);
                    task.setStartTime(startTime);
                    task.setFinishTime(finishiTime);
                    task.setTaskType(taskType);
                    task.setTaskStatus(taskStatus);
                    task.setTaskParam(taskParama);
                }
            }
        });
        return task;
    }

















}
