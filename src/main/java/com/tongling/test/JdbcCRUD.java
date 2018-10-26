package com.tongling.test;


import java.sql.*;

/**
 * JDBC增删改查
 * hadoop jar sparkproject-1.0-SNAPSHOT-jar-with-dependencies.jar com.tongling.test.JdbcCRUD
 * Created by 张宝玉 on 2018/10/9.
 */
public class JdbcCRUD {
    public static void main(String[] args) {
//        insert();
        update();
//        delete();
//        select();
//        preparedStatment();
    }

    /**
     * 测试插入数据
     */
    private static void insert() {
        //必须引入java.sql包
        Connection conn = null;
        //定义Statement对象
        //Statement对象其实是底层基于Connection数据库连接
        Statement stmt = null;

        try {
            //第一步：加载数据库驱动
            //Class.forName()是java提供的一种基于反射的方式，直接根据类的全限定名（包+类）
            //从类所在的磁盘文件（.class文件）中加载类对应的内容，并创建对应的class对象
            Class.forName("com.mysql.jdbc.Driver");

            //第二步：获取数据库连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sparkproject",
                    "root",
                    "hadoop");

            //第三步：创建SQL语句执行句柄
            stmt = conn.createStatement();

            String sql = "insert into test_user(name,age) values('张三',25)";
            int rtn = stmt.executeUpdate(sql);
            System.out.println("SQL语句影响了【"+rtn+"】行。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试更新数据
     */
    private static void update() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sparkproject",
                    "root",
                    "hadoop");
            stmt = conn.createStatement();

            String sql = "update test_user set age=27 where name='张三'";
            int rtn = stmt.executeUpdate(sql);

            System.out.println("SQL语句影响了【"+rtn+"】行。 ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * 测试删除数据
     */
    private static void delete() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sparkproject",
                    "root",
                    "hadoop");
            stmt = conn.createStatement();

            String sql = "delete from test_user where name='张三";
            int rtn = stmt.executeUpdate(sql);

            System.out.println("SQL语句影响了【"+rtn+"】行。 ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * 测试查询数据
     */
    private static void select() {
        Connection conn = null;
        Statement stmt = null;
        //对于select查询语句，需要定义ResultSet，代表查询出来的数据
        //需要通过ResultSet对象，来遍历查询出来的每一条数据，然后对数据进行保存或者处理
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sparkproject",
                    "root",
                    "hadoop");
            stmt = conn.createStatement();

            String sql = "select * from test_user";
            rs = stmt.executeQuery(sql);

            //获取到ResultSet以后，就需要对其进行遍历，然后获取查询出来的每一条数据
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                System.out.println("id="+id+",name="+name+",age="+age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void preparedStatment() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sparkproject",
                    "root",
                    "hadoop");
            //第一个，SQL语句中值所在的地方都是用？代表
            String sql = "insert into test_user(name,age) values(?,?)";

            pstmt = conn.prepareStatement(sql);

            //第二个，必须调用PreapredStatement的setX()系列方法，对指定的占位符赋值
            pstmt.setString(1, "张三");
            pstmt.setInt(2, 26);

            //第三个，执行SQL语句时，直接使用executeUpdate（）即可
            int rtn = pstmt.executeUpdate();

            System.out.println("SQL语句影响了【"+rtn+"】行。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
