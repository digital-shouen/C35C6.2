package com.techacademy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "authentication")
public class Authentication {
    /** 社員番号 */
    @Id
    private String code;

    /** パスワード */
    private String password;

    /** 権限 */
    private String role;

    /** ユーザID */
    @OneToOne
    @JoinColumn(name="employee_id", referencedColumnName="id", nullable = false)
    private Employee employee;
}