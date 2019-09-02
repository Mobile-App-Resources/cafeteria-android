package org.inu.cafeteria.injection

import android.content.Context
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import okhttp3.OkHttpClient
import org.inu.cafeteria.injection.Private.Companion.serverUrl
import org.inu.cafeteria.service.CafeteriaNetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    companion object {
        fun createCafeteriaNetworkService(context: Context): CafeteriaNetworkService {
            val cookieJar = PersistentCookieJar(
                SetCookieCache(),
                SharedPrefsCookiePersistor(context)
            )
            val okHttpClient = OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .build()

            val builder = Retrofit.Builder()

            val retrofit = builder
                .baseUrl(serverUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            return retrofit.create(CafeteriaNetworkService::class.java)
        }
    }
}