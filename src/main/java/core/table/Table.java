package core.table;

import java.util.Map;

/**
 * Created by xinszhou on 2/17/17.
 */
public interface Table {

    String getName();

    String get(String key);

    String set(String key, String value);

    String getSize();

}
