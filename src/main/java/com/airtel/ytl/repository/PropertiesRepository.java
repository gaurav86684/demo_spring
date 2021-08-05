package com.airtel.ytl.repository;


import com.airtel.ytl.entity.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties,Integer> {
 //   List<Properties> fetchProfile(String profile);

    public Properties findByKey(String Key);
}
