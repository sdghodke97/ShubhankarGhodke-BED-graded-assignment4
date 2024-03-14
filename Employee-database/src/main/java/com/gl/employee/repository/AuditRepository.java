package com.gl.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employee.Entity.AuditLog;

@Repository
public interface AuditRepository extends JpaRepository<AuditLog, Integer>{

}
