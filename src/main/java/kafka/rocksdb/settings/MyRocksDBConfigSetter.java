package kafka.rocksdb.settings;

import org.apache.kafka.streams.state.RocksDBConfigSetter;
import org.rocksdb.Options;

import java.util.Map;

public class MyRocksDBConfigSetter implements RocksDBConfigSetter {
    public MyRocksDBConfigSetter(String path) {
        System.out.println("RocksDBConfigSetterImpl " + path);
    }

    @Override
    public void setConfig(String s, Options options, Map<String, Object> map) {
        System.out.println("RocksDBConfigSetterImpl.setConfig");
    }

    @Override
    public void close(String s, Options options) {
        System.out.println(
                "RocksDBConfigSetterImpl.close"
        );
    }
}
