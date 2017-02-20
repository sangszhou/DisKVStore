//package core.broker;
//
//import core.table.InMemTable;
//import core.table.Table;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by xinszhou on 2/17/17.
// */
//public class Broker {
//
//    BrokerInfo brokerInfo;
//
//    Map<String, Table> managedTables;
//
//    public Broker(BrokerInfo brokerInfo) {
//        this.brokerInfo = brokerInfo;
//        this.managedTables = new HashMap<>();
//    }
//
//
//    public BrokerInfo getBrokerInfo() {
//        return brokerInfo;
//    }
//
//    public String get(String tableName, String key) {
//        if (managedTables.get(tableName) == null) {
//            System.out.println("Broker don't have such table: " + tableName);
//            return null;
//        }
//
//        return managedTables.get(tableName).get(key);
//    }
//
//    public void set(String tableName, String key, String value) {
//        checkIfTableExist(tableName);
//        managedTables.get(tableName).set(key, value);
//    }
//
//    public int getSize(String tableName) {
//        checkIfTableExist(tableName);
//        return managedTables.get(tableName).getSize();
//    }
//
//    public boolean createTable(String tableName) {
//        if (managedTables.get(tableName) != null) {
//            System.out.println("create table failed, broker already has such table");
//            return false;
//        } else {
//            managedTables.put(tableName, new InMemTable(tableName));
//            return true;
//        }
//    }
//
//    public boolean deleteTable(String tableName) {
//        checkIfTableExist(tableName);
//        if (managedTables.get(tableName) == null) {
//            System.out.println("delete un-existing table");
//            return false;
//        } else {
//            managedTables.remove(tableName);
//            System.out.println("table deleted");
//            return true;
//        }
//    }
//
//    public void checkIfTableExist(String tableName) {
//        if (managedTables.get(tableName) == null) {
//            System.out.println("Broker don't have such table: " + tableName);
//        }
//    }
//
//}
