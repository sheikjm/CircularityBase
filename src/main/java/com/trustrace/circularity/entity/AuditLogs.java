package com.trustrace.circularity.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Table(name = "audit_logs")
@Entity
@Data
@NoArgsConstructor
public class AuditLogs {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String controler;
    private String methodName;
    private String request;

    @CreationTimestamp
    private Date createdAt;

}
