package core.server;

import core.table.InMemTable;
import core.table.Table;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinszhou on 2/20/17.
 */
public class ReplicaManager {

    Map<String, Table> managedTables = new HashMap<>();

    public String get(String tableName, String key) {
        if (managedTables.get(tableName) == null) {
            System.out.println("Broker don't have such table: " + tableName);
            return null;
        }

        return managedTables.get(tableName).get(key);
    }

    public void set(String tableName, String key, String value) {
        checkIfTableExist(tableName);
        managedTables.get(tableName).set(key, value);
    }

    public int getSize(String tableName) {
        checkIfTableExist(tableName);
        return managedTables.get(tableName).getSize();
    }

    public boolean createTable(String tableName) {
        if (managedTables.get(tableName) != null) {
            System.out.println("create table failed, broker already has such table");
            return false;
        } else {
            managedTables.put(tableName, new InMemTable(tableName));
            return true;
        }
    }

    public boolean deleteTable(String tableName) {
        checkIfTableExist(tableName);
        if (managedTables.get(tableName) == null) {
            System.out.println("delete un-existing table");
            return false;
        } else {
            managedTables.remove(tableName);
            System.out.println("table deleted");
            return true;
        }
    }

    public void checkIfTableExist(String tableName) {
        if (managedTables.get(tableName) == null) {
            System.out.println("Broker don't have such table: " + tableName);
        }
    }


}
