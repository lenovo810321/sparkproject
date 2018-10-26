package com.tongling.dao.factory;

import com.tongling.dao.ISessionAggrStatDAO;
import com.tongling.dao.ITaskDAO;
import com.tongling.dao.impl.SessionAggrStatDAOImpl;
import com.tongling.dao.impl.TaskDAOImpl;

/**
 * DAO工厂类
 * 可以避免以后改变DAO实现类时修改多处代码
 * Created by 张宝玉 on 2018/10/13.
 */
public class DAOFactory {
    public static ITaskDAO getTaskDAO(){

        return new TaskDAOImpl();
    }

    public static ISessionAggrStatDAO getSessionAggrStatDAO() {
        return new SessionAggrStatDAOImpl();
    }
}
