package com.study;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
public class Customer {

    @Id
    @SequenceGenerator( //여기 들어가서 int allocationSize() default 50;부분을 확인, 숫자가 50을 텀으로 번호 자동생성된다는 말.
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence",
            allocationSize = 1 //이걸 해주면 자동으로 생성되는 숫자의 텀은 1로 할 수 있음
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    //아래는 컬럼 정의
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    public Customer(Integer id,
                    String name,
                    String email,
                    Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Customer() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) && name.equals(customer.name) && email.equals(customer.email) && age.equals(customer.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, age);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
