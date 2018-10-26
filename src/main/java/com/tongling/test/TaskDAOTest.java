package com.tongling.test;

import com.tongling.dao.ITaskDAO;
import com.tongling.domain.Task;
import com.tongling.dao.factory.DAOFactory;

/**
 * 任务管理DAO测试类
 * Created by 张宝玉 on 2018/10/13.
 */
public class TaskDAOTest {
    public static void main(String[] args) {
        ITaskDAO taskDAO = DAOFactory.getTaskDAO();
        Task task = taskDAO.findById(2);
        System.out.println(task.getTaskName());
    }
}
