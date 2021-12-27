package hello.servlet.domain.member;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Member {

    private Long id;
    private String username;
    private int age;

    public Member() {
    }

    public Member(String name, int age) {
        this.username = name;
        this.age = age;
    }
}
