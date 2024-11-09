package vn.iuh.edu.fit.week07_springdata.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerName;
    private double balance;
}
