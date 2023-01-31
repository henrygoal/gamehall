package com.zxy.gamehall.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

/*
 * @Description: 
 * @Author: luyh
 * @Date: 2023-01-30 17:31:15
 * @LastEditors: luyh
 * @LastEditTime: 2023-01-31 10:49:34
 */
@Data
public class GameHall implements Serializable{

    private static final long serialVersionUID = 6480177714796806954L;
    
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("start_time")
    private Date startTime;

    @TableField("end_time")
    private Date endTime;
}
