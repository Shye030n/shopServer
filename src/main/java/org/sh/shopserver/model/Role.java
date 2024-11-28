package org.sh.shopserver.model;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum Role {
    User, Admin;

//    @Enumerated(EnumType.ORDINAL)
//        User,Admin 적은 순서에 따라 DB에 저장
//    @Enumerated(EnumType.STRING)
//        DB에 String 형태로 저장
}
