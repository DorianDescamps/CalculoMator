package com.example.calculomator.database;

import android.content.Context;

public class LeaderboardBaseHelper extends DataBaseHelper {


    public LeaderboardBaseHelper(Context context) {
        super(context, "Leaderboard", 1);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS Scores ("+
                "id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name" + " VARCHAR(255) NOT NULL," +
                "Score" + " INTEGER NOT NULL " +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
