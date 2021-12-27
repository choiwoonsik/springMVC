package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemberRepository {
    private static HashMap<Long, Member> repo = new HashMap<>();
    private static Long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {
    }

    // CRUD
    public long save(Member member) {
        member.setId(++sequence);
        repo.put(member.getId(), member);
        return sequence;
    }

    public Member findById(long id) {
        return repo.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(repo.values());
    }

    public void clearStore() {
        repo.clear();
    }
}
