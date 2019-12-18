package com.msuk.samplePractice.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

/* 해당 인터페이스는 도메인패키지에서 도메인과 함께 관리 */
public interface PostsRepository extends JpaRepository <Posts, Long> { /* Entity클래스, PK 타입을 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다. */
}

