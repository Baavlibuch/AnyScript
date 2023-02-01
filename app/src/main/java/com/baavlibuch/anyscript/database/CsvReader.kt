package com.baavilbuch.anyscript.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // below is the method for creating a database by a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        // below is a sqlite query, where column names
        // along with their data types is given
//        val query = ("CREATE TABLE " + TABLE_NAME + " ("
//                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                LEVEL_COl + " TEXT," +
//                LETTER_COL + " TEXT )")
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY , "
                + LEVEL_COl + " TEXT,"
                + LETTER_COL + " TEXT)")
val string="CREATE TABLE Letters( id  INTEGER PRIMARY KEY, level INTEGER, letters TEXT)"

        // we are calling sqlite
        // method for executing our query

        db.execSQL(string)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // this method is to check if table already exists
        if(newVersion>oldVersion){
            db.execSQL(" DROP TABLE IF EXISTS $TABLE_NAME")
            onCreate(db)
        }
    }

    // This method is for adding data in our database
    fun addName(level: String?, letters: String? ){

        // below we are creating
        // a content values variable
        val values = ContentValues()

        // we are inserting our values in the form of key-value pair
        //values.put(ID_COL, index)
        values.put(LEVEL_COl, level)
        values.put(LETTER_COL, letters)


        // here we are creating a
        // writable variable of
        // our database as we want to
        // insert value in our database
        val db = this.writableDatabase

        // all values are inserted into database
        db.insert(TABLE_NAME, null, values)

        // at last we are
        // closing our database
       db.close()
    }

    // below method is to get
    // all data from our database
    fun getName(): Cursor? {

        // here we are creating a readable
        // variable of our database
        // as we want to read value from it
        val db = this.readableDatabase

        // below code returns a cursor to
        // read data from the database
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

    }

    companion object{
        // here we have defined variables for our database

        // below is variable for database name
        private const val DATABASE_NAME = "Letters"

        // below is the variable for database version
        private const val DATABASE_VERSION = 1

        // below is the variable for table name
        private const val  TABLE_NAME = "Letters"

        // below is the variable for id column
       private const val  ID_COL = "index"

        // below is the variable for name column
       private const val LEVEL_COl = "level"

        // below is the variable for age column
        private const val LETTER_COL = "letters"
    }

    fun readCourses(): ArrayList<LetterModel>? {
        // on below line we are creating a database for reading our database.
        val db = this.readableDatabase

        // on below line we are creating a cursor with query to read data from database.
        val cursorCourses: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        // on below line we are creating a new array list.
        val courseModelArrayList: ArrayList<LetterModel> = ArrayList()

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModelArrayList.add(
                    LetterModel(
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                    )
                )
            } while (cursorCourses.moveToNext())
            // moving our cursor to next.
        }
        // at last closing our cursor and returning our array list.
        cursorCourses.close()
        return courseModelArrayList
    }


}
