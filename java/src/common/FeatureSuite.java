package common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by alex.hernandez on 6/3/16.
 */

@Entity
@Table(name = "feature_suite")
public class FeatureSuite {

    @Id
    @GeneratedValue
    private Integer id;
    private String fs;

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

}
