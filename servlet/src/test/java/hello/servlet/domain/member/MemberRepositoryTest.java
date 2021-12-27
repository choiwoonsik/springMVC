package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();
    Member member = Member.builder()
            .username("woonsik")
            .age(28)
            .build();

    @AfterEach
    void end() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        memberRepository.save(member);
        assertThat(memberRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    void findById() {
        long id = memberRepository.save(member);
        assertThat(memberRepository.findById(id).getId()).isEqualTo(member.getId());
        assertThat(memberRepository.findById(id).getUsername()).isEqualTo(member.getUsername());
    }

    @Test
    void findAll() {
        memberRepository.save(new Member(0L, "woonsik1", 28));
        memberRepository.save(new Member(0L, "woonsik2", 29));
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
        for (Member member1 : memberRepository.findAll()) {
            System.out.println(member1.getUsername());
        }
    }

    @Test
    void clearStore() {
        memberRepository.clearStore();
        assertThat(memberRepository.findAll().size()).isEqualTo(0);
    }

    @Test
    public void 저장() throws Exception
    {
        //given
        Member member = new Member("hello", 20);
        long id = memberRepository.save(member);

        //when
        Member byId = memberRepository.findById(id);

        //then
        assertThat(member.getUsername()).isEqualTo(byId.getUsername());
    }
}