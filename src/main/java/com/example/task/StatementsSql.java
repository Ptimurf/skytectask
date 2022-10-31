package com.example.task;

public class StatementsSql {
    public static String selectClanByIdForUpdate = "SELECT * FROM game.clans WHERE id = %s FOR UPDATE";
    public static String getClanByIdForRead = "SELECT * FROM game.clans WHERE id = %s";
}
