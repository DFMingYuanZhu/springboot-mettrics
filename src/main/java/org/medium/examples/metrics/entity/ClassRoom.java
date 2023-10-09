package org.medium.examples.metrics.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author ：zhumingyuan
 * @description：TODO
 * @date ：2023/10/5 16:19
 */
@Entity
public class ClassRoom implements Serializable {

    @Id
    private String id;
    private String name;
    private String location;

    public ClassRoom(){}

    public ClassRoom(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
