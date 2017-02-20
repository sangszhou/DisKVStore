package core.table;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by xinszhou on 2/17/17.
 */
public class Table {

    public Table(int localBrokerId) {
        this.localBrokerId = localBrokerId;
    }

    Map<Integer, Replica> assignedReplicaMap = new HashMap<>();

    Optional<Integer> replicaId = Optional.empty();
    int localBrokerId;

    public Optional<Replica> leaderReplicaIfLocal() {
        if (replicaId.isPresent() && replicaId.get() == localBrokerId) {
            return getReplica(localBrokerId);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Replica> getReplica(int replicaId) {
        return Optional.ofNullable(assignedReplicaMap.get(replicaId));
    }


    String getName() {
        if (replicaId.isPresent()) {
            return
        }
    }

    String get(String key);

    String set(String key, String value);

    int getSize();

}
