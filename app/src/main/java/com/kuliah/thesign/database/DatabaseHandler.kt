package com.kuliah.thesign.database

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.kuliah.thesign.model.ForumModelClass
import com.kuliah.thesign.model.ReplyModelClass

class DatabaseHandler(context: Context): SQLiteOpenHelper(context,
    DATABASE_NAME,null,
    DATABASE_VERSION
) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "TheSignDatabase"

        private val TABLE_ACCOUNT = "AccountTable"
        private val KEY_ACCOUNT_ID = "account_id"
        private val KEY_EMAIL = "email"
        private val KEY_UNAME = "username"
        private val KEY_PASSWORD = "password"
        private val KEY_LOGGED_IN = "logged_in"

        private val TABLE_FORUM = "ForumTable"
        private val KEY_FORUM_ID = "forum_id"
        private val KEY_USERNAME = "username"
        private val KEY_TOPIC = "topic"
        private val KEY_CONTENT = "content"
        private val KEY_REPLIES = "replies"

        private val TABLE_REPLY = "ReplyTable"
        private val KEY_REPLY_ID = "reply_id"
        private val KEY_REPLY_FORUM_ID = "forum_id"
        private val KEY_REPLY_USERNAME = "reply_username"
        private val KEY_REPLY = "reply"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        // creating table with fields
        val CREATE_ACCOUNT_TABLE = ("CREATE TABLE $TABLE_ACCOUNT($KEY_ACCOUNT_ID INTEGER PRIMARY KEY, $KEY_UNAME TEXT, $KEY_PASSWORD TEXT, $KEY_EMAIL TEXT, $KEY_LOGGED_IN INTEGER)")
        db?.execSQL(CREATE_ACCOUNT_TABLE)

        val CREATE_FORUM_TABLE = ("CREATE TABLE $TABLE_FORUM($KEY_FORUM_ID INTEGER PRIMARY KEY, $KEY_USERNAME TEXT, $KEY_TOPIC TEXT, $KEY_CONTENT TEXT, $KEY_REPLIES INTEGER)")
        db?.execSQL(CREATE_FORUM_TABLE)

        val CREATE_REPLY_TABLE = ("CREATE TABLE $TABLE_REPLY($KEY_REPLY_ID INTEGER PRIMARY KEY, $KEY_REPLY_FORUM_ID INTEGER, $KEY_REPLY_USERNAME TEXT, $KEY_REPLY TEXT)")
        db?.execSQL(CREATE_REPLY_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_ACCOUNT")
        onCreate(db)
    }

    // Create akun
    fun createAccount(email: String, pass: String, uname: String): Boolean {
        val db = this.writableDatabase
        val getQuery = "SELECT * FROM $TABLE_ACCOUNT WHERE $KEY_EMAIL = '$email';"
        val getQuery2 = "SELECT * FROM $TABLE_ACCOUNT WHERE $KEY_UNAME = '$uname';"
        val cursorCheck: Cursor = db.rawQuery(getQuery, null)
        val cursorCheck2: Cursor = db.rawQuery(getQuery2, null)
//        val res: Int
        if (cursorCheck.count > 0 || cursorCheck2.count > 0) {
            Log.d("CREATION", "Failed create account, uname:$email $uname used")
            cursorCheck.close()
            db.close()
            return false
        } else {
            val addQuery = "INSERT INTO $TABLE_ACCOUNT($KEY_UNAME, $KEY_PASSWORD, $KEY_EMAIL, $KEY_LOGGED_IN) values('$email', '$pass', '$uname', -1);"
            val cursor: Cursor = db.rawQuery(addQuery, null)

            Log.d("CREATION", "Create account, uname:$uname, email:$email, pass:$pass")
            Log.d("CREATION", addQuery)
            Log.d("CREATION", getQuery)
            cursorCheck.close()
            try {
                if (cursor.moveToFirst()) {
                }
            } finally {
                cursor.close()
            }
            db.close()
            return true
        }
    }

    // Login akun
    fun loginAccount(email: String, pass: String): Boolean {
        val db = this.writableDatabase

        val getQuery = "SELECT * FROM $TABLE_ACCOUNT WHERE $KEY_EMAIL = '$email';"
        val cursor: Cursor = db.rawQuery(getQuery, null)
        var res = true
        if (cursor.count > 0) {
            val updateQuery = "UPDATE $TABLE_ACCOUNT SET $KEY_LOGGED_IN = 1 WHERE $KEY_EMAIL = '$email' ;"
            val cursor2 = db.rawQuery( updateQuery,null )
            try {
                if (cursor2.moveToFirst()) {
                }
            } finally {
                cursor2.close()
            }
        } else {
            res = false
        }

        Log.d("CREATION", "Login account, email:$email, pass:$pass")
        cursor.close()
        db.close()
        return res
    }

    // Logout akun
    fun logoutAccount(id: Int): Boolean {
        val db = this.writableDatabase

        val getQuery = "SELECT * FROM $TABLE_ACCOUNT WHERE $KEY_ACCOUNT_ID = $id;"
        val cursor: Cursor = db.rawQuery(getQuery, null)
        var res = true
        if (cursor.count > 0) {
            val updateQuery = "UPDATE $TABLE_ACCOUNT SET $KEY_LOGGED_IN = -1 WHERE $KEY_ACCOUNT_ID = $id ;"
            val cursor2 = db.rawQuery( updateQuery,null )
            try {
                if (cursor2.moveToFirst()) {
                }
            } finally {
                cursor2.close()
            }
        } else {
            res = false
        }

        Log.d("CREATION", "Logout account, id:$id")
        try {
            if (cursor.moveToFirst()) {
            }
        } finally {
            cursor.close()
        }
        db.close()
        return res
    }

    // Check is logged in
    fun checkAccount(): Int {
        val db = this.writableDatabase

        val checkQuery = "SELECT * FROM $TABLE_ACCOUNT WHERE $KEY_LOGGED_IN = 1 LIMIT 1;"
        val cursor: Cursor = db.rawQuery(checkQuery, null)
        var loggedAccount = -1
        if (cursor.count > 0) {
            if (cursor.moveToFirst()) {
                do {
                    loggedAccount = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ACCOUNT_ID))
                } while (cursor.moveToNext())
            }
        }
        Log.d("CREATION", "Account logged id:$loggedAccount")
        cursor.close()
        db.close()
        return loggedAccount
    }

    fun getUname(id: Int): String {
        val db = this.readableDatabase

        val getQuery = "SELECT * FROM $TABLE_ACCOUNT WHERE $KEY_ACCOUNT_ID = $id;"
        val cursor: Cursor = db.rawQuery(getQuery, null)
        var unameAccount = ""
        if (cursor.count > 0) {
            if (cursor.moveToFirst()) {
                do {
                    unameAccount = cursor.getString(cursor.getColumnIndexOrThrow(KEY_UNAME))
                } while (cursor.moveToNext())
            }
        }
        Log.d("CREATION", "Account logged uname:$unameAccount")
        cursor.close()
        db.close()
        return unameAccount
    }

    // Create new Forum
    fun createForum(uname:String, topic: String, content: String): Boolean {
        val db = this.writableDatabase
        val addQuery = "INSERT INTO $TABLE_FORUM($KEY_USERNAME, $KEY_TOPIC, $KEY_CONTENT, $KEY_REPLIES) values('$uname', '$topic', '$content', 0);"
        val cursor: Cursor = db.rawQuery(addQuery, null)

        Log.d("CREATION", "Create forum, uname:$topic")
        Log.d("CREATION", addQuery)
        try {
            if (cursor.moveToFirst()) {
            }
        } finally {
            cursor.close()
        }
        db.close()
        return true
    }

    // GET list forum
    fun getForum(): List<ForumModelClass> {
        val empList: ArrayList<ForumModelClass> = ArrayList<ForumModelClass>()
        val selectQuery = "SELECT * FROM $TABLE_FORUM "
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        if (cursor.moveToFirst()) {
            do {
                val emp = ForumModelClass(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_FORUM_ID)),
                    username = cursor.getString(cursor.getColumnIndexOrThrow(KEY_USERNAME)) ,
                    topic = cursor.getString(cursor.getColumnIndexOrThrow(KEY_TOPIC)),
                    content = cursor.getString(cursor.getColumnIndexOrThrow(KEY_CONTENT)),
                    replies = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_REPLIES)),
                    )
                empList.add(emp)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return empList
    }

    // Create new Reply
    fun createReply(forum_id: Int, uname:String,  content: String): Boolean {
        val db = this.writableDatabase
        val addQuery = "INSERT INTO $TABLE_REPLY($KEY_REPLY_FORUM_ID, $KEY_REPLY_USERNAME, $KEY_REPLY) values('$forum_id', '$uname', '$content');"
        val updateQuery = "UPDATE $TABLE_FORUM SET $KEY_REPLIES = $KEY_REPLIES + 1 WHERE $KEY_FORUM_ID = $forum_id ;"
        var cursor: Cursor = db.rawQuery(addQuery, null)
        var cursor2: Cursor = db.rawQuery(updateQuery, null)

        Log.d("CREATION", "Create reply, forum:$forum_id uname:$uname")
        Log.d("CREATION", addQuery)
        Log.d("CREATION", updateQuery)
        try {
            if (cursor.moveToFirst()) {
            }
        } finally {
            cursor.close()
        }
        try {
            if (cursor2.moveToFirst()) {
            }
        } finally {
            cursor2.close()
        }
        db.close()
        return true
    }

    // GET list reply
    fun getReply(id: Int): List<ReplyModelClass> {
        val empList: ArrayList<ReplyModelClass> = ArrayList()
        val selectQuery = "SELECT * FROM $TABLE_REPLY WHERE $KEY_REPLY_FORUM_ID = $id"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        if (cursor.moveToFirst()) {
            do {
                val emp = ReplyModelClass(
                    username = cursor.getString(cursor.getColumnIndexOrThrow(KEY_REPLY_USERNAME)) ,
                    reply = cursor.getString(cursor.getColumnIndexOrThrow(KEY_REPLY)),
                )
                empList.add(emp)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return empList
    }

}