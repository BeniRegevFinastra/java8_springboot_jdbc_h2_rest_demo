package com.finastra.java8_springboot_jdbc_h2_rest_demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.Country;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name", length = 255, unique = true)
    private String firstName;
    private String lastName;
    private int age;
    private Country country;

    @Override
    public String toString() {
        return this.toJson();
    }
    public String toJson() {
        return "User \n{ " +
                "\n\t\"id\": " + id +
                ", \n\t\"firstName\": \"" + firstName + "\"" +
                ", \n\t\"lastName\": \"" + lastName + "\"" +
                ", \n\t\"age\": " + age +
                ", \n\t\"country\": {" +
                "\n\t\t\"name\": " + country + "\"" +
                ", \n\t\t\"countryCode\": +" + country.getCountryCode() +
                ", \n\t\t\"country Currency\": \"" + country.getCurrency() + "\"" +
                ", \n\t\t\"country Language\": \"" + country.getLanguage() + "\"" +
                ", \n\t\t\"country Alpha-2 code\": \"" + country.getShort2ch() + "\"" +
                "\n\t}" +
                "\n}";
    }

}
