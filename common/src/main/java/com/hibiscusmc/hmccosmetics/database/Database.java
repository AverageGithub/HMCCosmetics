package com.hibiscusmc.hmccosmetics.database;

import com.hibiscusmc.hmccosmetics.config.DatabaseSettings;
import com.hibiscusmc.hmccosmetics.database.types.Data;
import com.hibiscusmc.hmccosmetics.database.types.MySQLData;
import com.hibiscusmc.hmccosmetics.database.types.SQLiteData;
import com.hibiscusmc.hmccosmetics.user.CosmeticUser;
import com.hibiscusmc.hmccosmetics.user.CosmeticUsers;
import com.hibiscusmc.hmccosmetics.util.MessagesUtil;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Database {

    private static Data data;

    private static final MySQLData MYSQL_DATA = new MySQLData();
    private static final SQLiteData SQLITE_DATA = new SQLiteData();

    public Database() {
        String databaseType = DatabaseSettings.getDatabaseType();
        data = SQLITE_DATA; // default
        if (databaseType.equalsIgnoreCase("MySQL")) {
            data = MYSQL_DATA;
        }
        /* SQLite is the default database. Might change in the future, so keep code here in case.
        if (databaseType.equalsIgnoreCase("sqlite")) {
            data = SQLITE_DATA;
        }
         */
        MessagesUtil.sendDebugMessages("Database is " + data);

        setup();
    }

    public static void setup() {
        data.setup();
    }

    public static void save(CosmeticUser user) {
        data.save(user);
    }

    public static void save(Player player) {
        data.save(CosmeticUsers.getUser(player));
    }

    public static CosmeticUser get(UUID uniqueId) {
        return data.get(uniqueId);
    }

    public static Data getData() {
        return data;
    }

    public static void clearData(UUID uniqueId) {
        data.clear(uniqueId);
    }
}
