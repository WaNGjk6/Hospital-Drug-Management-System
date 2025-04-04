package com.javaclimb.drug.common;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.List;



public class ResultMapUtil {

    public static HashMap<String,Object> getHashMapLogin(String msg,String code){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg",msg);
        resultMap.put("code",code);
        if ("1".equals(code)){
            resultMap.put("icon",1);
        }else {
            resultMap.put("icon",3);
        }
        resultMap.put("anim",4);
        return resultMap;
    }

    public static HashMap<String,Object> getHashMapMysqlPage(IPage<?> object){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",object.getTotal());
        resultMap.put("data",object.getRecords());
        return resultMap;
    }

    public static HashMap<String,Object> getHashMapException(Exception e){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg",e.getMessage());

        return resultMap;
    }

    public static HashMap<String,Object> getHashMapSave(int i){
        HashMap<String, Object> resultMap = new HashMap<>();

        if (i == 0){
            resultMap.put("msg","保存失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","保存成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }

        return resultMap;
    }


    public static HashMap<String,Object> getHashMapDel(int i){
        HashMap<String, Object> resultMap = new HashMap<>();

        if (i == 0){
            resultMap.put("msg","删除失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","删除成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }

        return resultMap;
    }


    public static HashMap<String, Object> getHashMapList(List<?> list) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 0);
        if (list != null && list.size() > 0) {
            resultMap.put("msg", "");
        } else {
            resultMap.put("msg", "没有查询到数据");
        }
        resultMap.put("data",list);
        return resultMap;
    }
}
