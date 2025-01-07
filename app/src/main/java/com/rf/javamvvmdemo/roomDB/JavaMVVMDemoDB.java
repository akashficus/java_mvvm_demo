package com.rf.javamvvmdemo.roomDB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.rf.javamvvmdemo.roomDB.dao.JavaMVVMDemoDao;
import com.rf.javamvvmdemo.roomDB.model.ArticleModel;

@Database(
        entities = {
                ArticleModel.class
        },
        version = 1
)
public abstract class JavaMVVMDemoDB extends RoomDatabase {

    public abstract JavaMVVMDemoDao fioDao();

    private static volatile JavaMVVMDemoDB INSTANCE;

    public static JavaMVVMDemoDB getDatabase(@NonNull final Context context) {
        if (INSTANCE == null) {
            synchronized (JavaMVVMDemoDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    JavaMVVMDemoDB.class,
                                    "Javamvvmdemo.db"
                            )
                            .allowMainThreadQueries() // Use with caution; ideally, database queries should be off the main thread.
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}