package core.controller;

import core.broker.Broker;

import java.util.List;
import java.util.Map;

/**
 * Created by xinszhou on 2/17/17.
 */
public class Controller {

    PickBrokerStrategy pickBrokerStrategy;

    // table name -> broker
    Map<String, Broker> tableBrokerInfo;

    List<Broker> onLineBrokers;

    List<Broker> onlineBrokers() {
        return onLineBrokers;
    }

    public void onTableCreation(String tableName) {
        Broker choosenBroker = pickBrokerStrategy.pickBroker(onlineBrokers());
        choosenBroker.createTable(tableName);
    }

    public void onTableDeletion(String tableName) {
        Broker choosenBroker = tableBrokerInfo.get(tableName);
        choosenBroker.deleteTable(tableName);
    }

    public void onBrokerStartup(List<Broker> liveBrokers) {
        System.out.println("broker online");
        onLineBrokers.addAll(liveBrokers);

        liveBrokers.forEach(broker -> {
            System.out.println("broker online: " +
                    broker.getBrokerInfo().getHost() + ":" + broker.getBrokerInfo().getPort());
        });
    }

    public void onBrokerShutdown(List<Broker> deadBrokers) {
        System.out.println("broker offline");
        onLineBrokers.removeAll(deadBrokers);

        deadBrokers.forEach(broker -> System.out.println("delete broker: " +
                broker.getBrokerInfo().getHost() + ":" + broker.getBrokerInfo().getPort()));
    }


}
