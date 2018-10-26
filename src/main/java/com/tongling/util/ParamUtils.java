package com.tongling.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 参数工具类
 * 有从命令行参数中提取任务id以及从JSON对象中提取参数的功能
 * Created by 张宝玉 on 2018/10/9.
 */
public class ParamUtils {

    /**
     * 从命令行参数中提取任务id
     * @param args 命令行参数
     * @return 任务id
     */
    public static Long getTaskIdFromArgs(String[] args) {
        try{
            if(args != null && args.length > 0) {
                return Long.valueOf(args[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从JSON对象中提取参数
     * @param jsonObject JSON对象
     * @param field 字段名
     * @return 参数
     */
    public static String getParam(JSONObject jsonObject, String field) {
        JSONArray jsonArray = jsonObject.getJSONArray(field);
        if(jsonArray != null && jsonArray.size() > 0) {
            return jsonArray.getString(0);
        }
        return null;
    }
}
