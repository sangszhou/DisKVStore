//package core.table;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by xinszhou on 2/17/17.
// */
//public class InMemTable implements Table {
//
//    String name;
//
//    public InMemTable(String name) {
//        this.name = name;
//    }
//
//    Map<String, String> data = new HashMap<>();
//
//    @Override
//    public String getName() {
//        return name;
//    }
//
//    public String get(String key) {
//        return data.get(key);
//    }
//
//    public String set(String key, String value) {
//        return data.put(key, value);
//    }
//
//    public int getSize() {
//        return data.size();
//    }
//}
