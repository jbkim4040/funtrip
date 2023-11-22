package com.main.funtrip.user.entity;

import com.main.funtrip.common.Audit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user_m")
public class User extends Audit {

    @Id
    @Column(name = "user_id", length = 15)
    private String id;

    @Column(name = "user_email", length = 30)
    private String email;

    @Column(name = "user_password", length = 200)
    private String password;
}
