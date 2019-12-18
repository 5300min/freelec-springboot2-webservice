package com.msuk.samplePractice.web.domain.posts;

import com.msuk.samplePractice.domain.post.Posts;
import com.msuk.samplePractice.domain.post.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class) /* SpringRunner 실행자 사용 / Springboot 테스트와 JUnit 연결자 */
@SpringBootTest /* 해당 어노테이션을 사용할 경우 H2 데이터베이스를 자동으로 실행함. */
public class PostRepositoryTest {


    @Autowired
    PostsRepository postsRepository;

    @After /*  Junit에서 단위테스트가 끝날때마다 수행되는 메소드 지정 / 배포전 전체테스트시 테스트간 데이터 침범을 막기 위해 사용 */
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void board_read() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        /* 쿼리로 보고싶다면 src/main/resource 디렉토리 아래에 application.properties 파일을 생성하여 아래와 같이 설정한다.
        * spring.jpa.show_sql=true;
        * 설정 후 콘솔에서 쿼리를 확인할 수 있따.
        *  */

        // given
        postsRepository.save(Posts.builder() /* 테이블 posts에 insert, update 쿼리 실행 (save) / id가 있다면 update, 없다면 insert */
                .title(title)
                .content(content)
                .author("msuk@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); /* 테이블 posts에 있는 모든 데이터를 조회 */

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
