package bj.ninjas.generator.properties;

import java.util.Map;

import lombok.Data;

@Data
public class UnmappedProperties{

    private Map<String, String> properties;

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    
    public void add(String key, String value) {
        properties.put(key, value);
    }

}
