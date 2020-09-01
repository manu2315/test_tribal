package com.example.androidtest.data.objects

import com.example.androidtest.data.models.User

object UserLogged {

    private var mUser: User?=null

    fun createUser(name:String, email:String,photoUrl:String): User?{
        if(mUser ==null){
            mUser = User(name, email,photoUrl)
        }
        return mUser
    }

    fun getUser(): User?{
        return mUser
    }

}