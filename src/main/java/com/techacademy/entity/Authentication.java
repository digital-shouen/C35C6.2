package com.techacademy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


import lombok.Data;

@Data
@Entity
@Table(name = "authentication")
public class Authentication {
    /** 性別用の列挙型 */
    public static enum Role {
        一般, 管理者
    }
    /** 社員番号 */
    @Id
    private String code;

    /** パスワード */
    @Autowired
    private String password;

    /** 権限 */
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Role role;

    /** ユーザID */  
    @OneToOne
    @JoinColumn(name="employee_id", referencedColumnName="id", nullable = false)
    private Employee employee;
}