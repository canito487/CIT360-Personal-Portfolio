package common.TCDBOutofSync.TCDB;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestCase {

    @JsonProperty("Id")
    private int Id;
    
    @JsonProperty("Version")
    private short Version;
    
    @JsonProperty("Id")
    public int getId() {
        return Id;
    }
    
    @JsonProperty("Id")
    public void setId(int Id) {
        this.Id = Id;
    }
    
    @JsonProperty("Version")
    public short getVersion() {
        return Version;
    }
    
    @JsonProperty("Version")
    public void setVersion(short Version) {
        this.Version = Version;
    }
}
