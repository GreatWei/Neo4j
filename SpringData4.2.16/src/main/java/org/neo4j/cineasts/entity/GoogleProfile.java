package org.neo4j.cineasts.entity;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
@NodeEntity
public class GoogleProfile {
    @GraphId Long id;
    private String name;
    private String address;
    private String sex;
    private String dob;   public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean equals(Object other) {

        if (this == other)
            return true;      if (id == null)
            return false;      if (! (other instanceof GoogleProfile))
            return false;      return id.equals(((GoogleProfile) other).id);
    }

    public int hashCode() {
        return id == null ? System.identityHashCode(this) : id.hashCode();
    }

    public String toString(){
        return "Profile[id:"+ id +",name:"+ name +",sex:" + sex+ ",address:" + address + ",dob:" + dob +"]";
    }
}