package com.example.tacocloud.Entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Taco_Order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Date placedAt;
    @NotBlank(message = "Введите имя")
    private String name;
    @NotBlank(message = "Введите улицу")
    private String street;
    @NotBlank(message = "Введите город")
    private String city;
    @NotBlank(message = "Введите штат")
    private String state;
    @NotBlank(message = "Введите индекс")
    private String zip;
    @CreditCardNumber(message = "Введён некорректный номер катры")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message = "Формат: ММ/ГГ")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Неверный CVV")
    private String ccCVV;

    @ManyToMany(targetEntity= Taco.class)
    private List<Taco> tacos = new ArrayList<>();
    public void addDesign(Taco design) {
        this.tacos.add(design);
    }
    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}