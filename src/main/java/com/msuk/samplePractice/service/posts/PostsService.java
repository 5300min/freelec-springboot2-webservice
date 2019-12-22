package com.msuk.samplePractice.service.posts;

import com.msuk.samplePractice.domain.post.PostsRepository;
import com.msuk.samplePractice.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor /* Bean을 주입받는 방식 중 생성자를 통한 방식으로 사용 / 해당 어노테이션으로 생성자가 생성되었다. */
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
