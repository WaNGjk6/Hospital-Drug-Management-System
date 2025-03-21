package com.javaclimb.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName(value = "problem")
public class Problem implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    
    private String dname;
    
    private Integer dcount;
    
    private Float dprice;
    
    private String reason;
    
    private Date createtime;


}
