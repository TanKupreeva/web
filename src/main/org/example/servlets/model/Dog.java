package main.org.example.servlets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    private Integer id;
    private Integer age;
    private String name;
    private String breed;

}
