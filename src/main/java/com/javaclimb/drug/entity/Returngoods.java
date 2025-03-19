package com.javaclimb.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.javaclimb.drug.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName(value = "returngoods")
public class Returngoods implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String dname;
    
    private Integer count;

    
    private String reason;
    
    private Float total;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    public String createtimeStr() {
        return DateUtil.dateConvert(createtime);
    }
}
