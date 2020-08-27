package com.example.androidtest.data

object UserLogged {

    private var mUser:User?=null

    fun createUser(name:String, email:String):User?{
        if(mUser==null){
            mUser= User(name, email)
        }
        return mUser
    }

    fun getUser():User?{
        return mUser
    }

}