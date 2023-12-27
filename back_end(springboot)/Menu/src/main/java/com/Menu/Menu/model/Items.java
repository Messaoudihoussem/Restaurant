package com.Menu.Menu.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="items")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private Double price;

    @Column
    private String img;

}
