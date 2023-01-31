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
 * @Date: 2023-01-30 17:31:28
 * @LastEditors: luyh
 * @LastEditTime: 2023-01-31 10:49:52
 */
@Data
public class GameHallLog implements Serializable {
    
    private static final long serialVersionUID = 6944739585282525029L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("gid")
    private Long gid;

    @TableField("start_time")
    private Date startTime;

    @TableField("end_time")
    private Date endTime;
}

