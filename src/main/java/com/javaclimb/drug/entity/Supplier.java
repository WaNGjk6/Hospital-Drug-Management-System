package com.javaclimb.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data //@Data注解的作用 @Data注解是lombok.jar包下的注解,该注解通常用在实体bean上,不需要写出set和get方法
@TableName(value = "supplier")
public class Supplier implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private String content;

    private Date createtime;
}
