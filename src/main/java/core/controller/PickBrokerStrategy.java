package core.controller;

import core.broker.Broker;

import java.util.List;

/**
 * Created by xinszhou on 2/17/17.
 */
public class PickBrokerStrategy {

    Broker pickBroker(List<Broker> brokers) {
        int min = 0, max = brokers.size() - 1;

        int index = min + (int) (Math.random() * ((max - min) + 1));

        return brokers.get(index);
    }
}
