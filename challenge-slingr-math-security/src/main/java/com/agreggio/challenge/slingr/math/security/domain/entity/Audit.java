package com.agreggio.challenge.slingr.math.security.domain.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
@Getter
@Setter
public class Audit implements Serializable {


    @CreatedDate
    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @Column(name = "DELETE_DATE")
    private Timestamp deleteDate;

    @LastModifiedDate
    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;


}