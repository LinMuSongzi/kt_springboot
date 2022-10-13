package com.msz.demo.service

import com.msz.demo.IHolderInjection
import com.msz.demo.service.impl.AppServiceImpl
import org.springframework.beans.factory.annotation.InjectionMetadata
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.primaryConstructor

class MszServiceManager : IHolderInjection {

    val map = HashMap<KClass<*>, Any?>()

    companion object {
        val MANGER = MszServiceManager()

        inline fun <reified T> getServiceImpl(): T {
            return MANGER.holderService()
        }
    }

    inline fun <reified T : Any> holderService(): T {
        var service = map[T::class]
        if (service == null) {
            service = instanceService(T::class)
        }
        map[T::class] = service
        return (service as T)
    }

    inline fun <reified T : Any> instanceService(kClass: KClass<T>): T {
        when (kClass) {
            AppService::class -> {
                return instanceServiceImple(kClass) as T
            }
            UtilHelpService::class -> {
                return instanceServiceImple(kClass) as T
            }
        }
        throw IllegalAccessError("service not find");
    }

    fun instanceServiceImple(kClass: KClass<*>): Any {
        return kClass.createInstance()
    }

}




