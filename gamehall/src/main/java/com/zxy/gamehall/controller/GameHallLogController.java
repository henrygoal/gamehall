/*
 * @Description: 
 * @Author: luyh
 * @Date: 2023-01-30 17:26:58
 * @LastEditors: luyh
 * @LastEditTime: 2023-01-31 17:12:47
 */
package com.zxy.gamehall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxy.gamehall.entity.GameHallLog;
import com.zxy.gamehall.mapper.GameHallLogMapper;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/log")
public class GameHallLogController {

    @Autowired
    private GameHallLogMapper mapper;
    
    // @GetMapping(value="",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    // public Flux<GameHallLog> list() {

    //     return Flux.fromStream(mapper.selectList(null).stream());

    // }

    @GetMapping("")
    public Mono<List<GameHallLog>> list2() {

        return Mono.fromSupplier(() -> mapper.selectList(null));
    }

}
