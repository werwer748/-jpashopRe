package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

//    @NotEmpty // 빈값이 오면 에러 - dto에서 잡자
    private String name;

    @Embedded
    private Address address;

    @JsonIgnore // 엔티티조회시 이 필드 빼고 전달
    @OneToMany(mappedBy = "member") // 읽기전용
    private List<Order> orders = new ArrayList<>();
}
