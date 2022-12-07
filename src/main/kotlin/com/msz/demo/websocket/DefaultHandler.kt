package com.msz.demo.websocket

import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
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
        map[session.id] = session
        session.sendMessage(TextMessage("你好~~~~"))
    }

    /**
     * 接收消息
     * @param session
     * @param message
     * @throws Exception
     */
    @Throws(Exception::class)
    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {

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