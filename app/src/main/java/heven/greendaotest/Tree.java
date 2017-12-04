package heven.greendaotest;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by PC-201711161643$ on 2017/11/20 0020.
 */

@Entity
public class Tree {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String name;
    @Property
    private double height;
    @Generated(hash = 221099123)
    public Tree(Long id, String name, double height) {
        this.id = id;
        this.name = name;
        this.height = height;
    }
    @Generated(hash = 439989092)
    public Tree() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getHeight() {
        return this.height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
}
