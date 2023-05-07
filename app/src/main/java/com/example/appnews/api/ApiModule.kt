package com.example.appnews.api

import com.example.appnews.commons.preference.PreferenceModule
import com.example.appnews.utils.ConstansKotlin.Companion.ENVIRONMENT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class RetrofitTryDistri

    @Singleton
    @RetrofitTryDistri
    @Provides
    fun provideRetrofit(preferenceModule: PreferenceModule): Retrofit {

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain: Interceptor.Chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader(
                        "Authorization",
                        "Bearer "
                    )
                    .build()
                chain.proceed(newRequest)
            }
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(ENVIRONMENT)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}