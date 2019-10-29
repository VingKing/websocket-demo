package com.example.websocket.controller;

import com.example.websocket.server.WebSocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ws")
public class WebSocketController {


    /**
     * 群发消息内容
     * @param message
     * @return
     */
    @GetMapping(value="/sendAll")
    public String sendAllMessage(String message){
        WebSocketServer.BroadCastInfo(message);
        return "ok";
    }
    
    /**
     * 指定会话ID发消息
     * @param message 消息内容
     * @param id 连接会话ID
     * @return
     */
    @GetMapping(value="/sendOne")
    public String sendOneMessage( String message, String id){
        WebSocketServer.SendMessage(message,id);
        return "ok";
    }
}