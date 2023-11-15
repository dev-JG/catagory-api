package com.category.model.enums;

import lombok.Getter;

@Getter
public enum DisplayStatus {

    NEW("NEW", "신규생성"),
    WAIT("WAIT", "판마대기중"),
    SALE("SALE", "판매중"),
    SOLD_OUT("SOLD_OUT", "매진"),
    DISCONTINUED("DISCONTINUED", "판매중단");

    private String status;
    private String description;

    DisplayStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }
}
