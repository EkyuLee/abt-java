package com.prjf17.springjava17.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //repository 는 interface로 생성하고, JPARepository를 사용하여 db 를 연결한다.
            //JpaRepository 를 상속 받을때 entity의 id의 형태를 뒤에 넣어준다.
public interface MemberRepository extends JpaRepository<Member, Long> {
}
