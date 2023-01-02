package com.newsapp.database;

import com.newsapp.database.autotables.CategoryTable;
import com.newsapp.database.autotables.UserTable;

public class Database {
    public static void run(){
        UserTable.create();
        CategoryTable.create();
    }

    public static void destroy(){
        UserTable.drop();
        CategoryTable.drop();
    }
}
