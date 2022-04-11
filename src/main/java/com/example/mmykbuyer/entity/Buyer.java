package com.example.mmykbuyer.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Accessors(chain = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"name"})
})
@Data
public class Buyer extends AbstractEntity {

    private String phone;

    private String email;

    private String username;

    private String password;

    private String wechatOpenid;

    private Long accountId;

    private Long storeId;

    private String storeName;

//    @JsonIgnore
//    @OneToMany(mappedBy = "site", cascade = {CascadeType.ALL})
//    private List<Account> account = new ArrayList<>();

}
