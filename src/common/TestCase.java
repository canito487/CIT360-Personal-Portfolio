package common;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by alex.hernandez on 6/3/16.
 */

@Entity
@Table(name = "test_case")
public class TestCase {

    @Id
    @GeneratedValue
    private Integer id;
    private String tcname;
    private Integer tcversion;
    private Integer fsnumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tc_join",
            joinColumns = { @JoinColumn(name = "tc_id") },
            inverseJoinColumns = @JoinColumn(name = "fs_id")
    )
    private Set<FeatureSuite> fsNumbers;

    public TestCase() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTcname() {
        return tcname;
    }

    public void setTcname(String tcname) {
        this.tcname = tcname;
    }

    public Integer getTcversion() {
        return tcversion;
    }

    public void setTcversion(Integer tcversion) {
        this.tcversion = tcversion;
    }

    public Integer getFsnumber() {
        return fsnumber;
    }

    public void setFsnumber(Integer fsnumber) {
        this.fsnumber = fsnumber;
    }

    public Set<FeatureSuite> getFsNumbers() {
        return fsNumbers;
    }

    public void setFsNumbers(Set<FeatureSuite> fsNumbers) {
        this.fsNumbers = fsNumbers;
    }

}
