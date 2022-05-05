package com.trustrace.circularity.repository;

import com.trustrace.circularity.entity.AuditLogs;
import org.springframework.data.repository.CrudRepository;

public interface AuditLogRepository extends CrudRepository<AuditLogs,Long> {
}
