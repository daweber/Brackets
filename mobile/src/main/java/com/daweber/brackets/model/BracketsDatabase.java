package com.daweber.brackets.model;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * DBFlow Database class
 */
@Database(name = BracketsDatabase.NAME, version = BracketsDatabase.VERSION)
public class BracketsDatabase {
    public static final String NAME = "b64";
    public static final int VERSION = 1;
}
