package com.airtel.ytl.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_generator")
    private Integer id;

    @Column(unique = true)
    private String key;

   // @Column(nullable = false)
    //@NotNull
    private String value;

    private String profile;
    private String type;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
