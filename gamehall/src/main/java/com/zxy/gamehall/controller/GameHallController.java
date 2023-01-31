/*
 * @Description: 
 * @Author: luyh
 * @Date: 2023-01-30 17:26:00
 * @LastEditors: luyh
 * @LastEditTime: 2023-01-31 17:01:39
 */
package com.zxy.gamehall.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zxy.gamehall.entity.GameHall;
import com.zxy.gamehall.entity.GameHallLog;
import com.zxy.gamehall.mapper.GameHallLogMapper;
import com.zxy.gamehall.mapper.GameHallMapper;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/gamHall")
public class GameHallController {

    @Autowired
    private GameHallMapper gameHallMapper;

    @Autowired
    private GameHallLogMapper logMapper;

    @GetMapping("")
    public Mono<List<GameHall>> list() {

        return Mono.fromSupplier(() -> gameHallMapper.selectList(null));
    }

    @GetMapping("/create/{name}")
    public void create(@PathVariable String name) {

        GameHall gameHall = new GameHall();
        gameHall.setName(name);
        gameHallMapper.insert(gameHall);
    }

    @GetMapping("/update/{id}")
    public void update(@PathVariable String id) {

        GameHall gameHall = gameHallMapper.selectById(Long.parseLong(id));
        if (gameHall != null) {

            if (gameHall.getStartTime() == null||(gameHall.getStartTime()!=null&& gameHall.getEndTime()!=null)) {
                gameHall.setStartTime(new Date());
                gameHall.setEndTime(null);

                LambdaUpdateWrapper<GameHall> wrapper = Wrappers.lambdaUpdate();
                wrapper.set(GameHall::getEndTime, null).eq(GameHall::getId, gameHall.getId());
                gameHallMapper.update(gameHall, wrapper);


                GameHallLog log = new GameHallLog();
                log.setStartTime(gameHall.getStartTime());
                log.setGid(gameHall.getId());
                logMapper.insert(log);
            } else {
                gameHall.setEndTime(new Date());

                LambdaQueryWrapper<GameHallLog> wrapper = new  LambdaQueryWrapper<>();
                wrapper.eq(
                        GameHallLog::getGid, gameHall.getId()).eq(GameHallLog::getStartTime, gameHall.getStartTime());
                GameHallLog log = logMapper.selectOne(wrapper);
                if(log!=null){
                    log.setEndTime(gameHall.getEndTime());
                    logMapper.updateById(log);
                }
            }
            gameHallMapper.updateById(gameHall);
        }
    }
}
