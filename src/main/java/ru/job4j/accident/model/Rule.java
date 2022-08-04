package ru.job4j.accident.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rules")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Rule() {
    }

    public Rule(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rule rule = (Rule) o;
        return Objects.equals(id, rule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
