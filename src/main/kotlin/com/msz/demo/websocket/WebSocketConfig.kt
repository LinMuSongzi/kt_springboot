package com.msz.demo.websocket

import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import javax.annotation.Resource


@EnableWebSocket // [1]
@Configuration
class WebSocketConfig : WebSocketConfigurer {
    @Resource
    lateinit var defaultHandler : WebSocketHandler

    @Resource
    lateinit var defaultInterceptor: DefaultInterceptor
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry
            .addHandler(defaultHandler,"/ws") // todo  [2]
            .addInterceptors(defaultInterceptor) // todo  [3]
            .setAllowedOrigins("*") // 解决跨域问题 [4]
    }
}