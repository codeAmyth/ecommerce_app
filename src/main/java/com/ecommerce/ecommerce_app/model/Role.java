package com.ecommerce.ecommerce_app.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @ToString.Exclude
    @Column(length = 20, name = "role_name")
    @Enumerated(EnumType.STRING) // by default enum sends int so converted into string
    private AppRole roleName;

    public Role(AppRole roleName) {
        this.roleName = roleName;
    }


}
