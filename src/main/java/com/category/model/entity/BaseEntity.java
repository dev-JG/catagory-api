package com.category.model.entity;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class BaseEntity {

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;
}