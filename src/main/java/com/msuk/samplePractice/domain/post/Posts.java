package com.msuk.samplePractice.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor /* 기본 생성자 자동 추가 */
@Entity /* JPA 어노테이션 / 테이블과 링크될 클래스임을 명시 / 클래스의 카멜케이스명을 언더스코어(_)네이밍으로 테이블 이름 매칭 [기본값] */
public class Posts {

    @Id /* PK 필드 */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* PK 생성규칙*/
    private Long id;

    @Column(length = 500, nullable = false) /* 기본적으로는 굳이 선언하지 않아도 되는 어노테이션 / 변경이 필요한 옵션이 있을경우 사용하기 위해 사용 */
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder /* 빌더 패턴 클래스 생성 / 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함됨. */
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
