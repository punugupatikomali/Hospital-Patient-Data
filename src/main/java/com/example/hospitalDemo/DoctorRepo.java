package com.example.hospitalDemo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.hospitalDemo.Doctor;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

	// @Query(value = "SELECT * FROM DoctorData WHERE specialization = :specialization", nativeQuery = true)
    // public List<Doctor> getDocDetails(@Param("specialization") String specialization);
    List<Doctor> findBySpecialization(String specialization);

}
