package core.controller;

import core.protocol.Broker;
import core.table.Table;

import java.util.List;
import java.util.Map;

/**
 * Created by xinszhou on 2/17/17.
 */
public class Controller {

    // table name -> broker
    Map<String, Broker> tableBrokerInfo;

    List<Broker> onLineBrokers;

    List<Broker> onlineBrokers() {
        return onLineBrokers;
    }

    public void createTable(String tableName) {

    }

    public void deleteTable(String tableName) {

    }



}
