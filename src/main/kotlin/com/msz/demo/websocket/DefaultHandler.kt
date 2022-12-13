package com.msz.demo.websocket

import org.springframework.stereotype.Component
import org.springframework.web.socket.BinaryMessage
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.PingMessage
import org.springframework.web.socket.PongMessage
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

@Component
class DefaultHandler : WebSocketHandler {

    val map :ConcurrentMap<String,WebSocketSession> = ConcurrentHashMap()

    /**
     * 建立连接
     * @param session
     * @throws Exception
     */
    @Throws(Exception::class)
    override fun afterConnectionEstablished(session: WebSocketSession) {
        // 缓存用户信息: userInfo
        val id = session.id
        map[id] = session
        println("sessione id = $id")
        session.sendMessage(TextMessage("连接成功,你的id = $id"))
        Thread{
            var time = 0
            while (time <= 6000) {
                time += 1500
                Thread.sleep(1500)
                val s = map[id]
                if(s!= null && s.isOpen) {
                    s.sendMessage(TextMessage("连接时长 ，时间 $time"))
                }
            }
        }.start()
    }

    /**
     * 接收消息
     * @param session
     * @param message
     * @throws Exception
     */
    @Throws(Exception::class)
    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        when(message){
            is TextMessage->{
                println("recevier message type TextMessage ")
                session.sendMessage(TextMessage("SpringBoot服务器返回 ：'${String(message.asBytes())}'"))
            }
            is PingMessage->{
                println("recevier message type PingMessage ")
            }
            is PongMessage->{
                println("recevier message type PongMessage ")
            }
            is BinaryMessage->{
                println("recevier message type BinaryMessage ")
            }

        }
    }

    /**
     * 发生错误
     * @param session
     * @param exception
     * @throws Exception
     */
    @Throws(Exception::class)
    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        // 清除用户缓存信息
    }

    /**
     * 关闭连接
     * @param session
     * @param closeStatus
     * @throws Exception
     */
    @Throws(Exception::class)
    override fun afterConnectionClosed(session: WebSocketSession, closeStatus: CloseStatus) {
        // 清除用户缓存信息
        map[session.id] = null
        println(closeStatus)
    }

    override fun supportsPartialMessages(): Boolean {
        return false
    }
}