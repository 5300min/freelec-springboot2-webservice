package com.msuk.samplePractice.web;

import com.msuk.samplePractice.service.posts.PostsService;
import com.msuk.samplePractice.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PutMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        return postsService.save(postSaveRequestDto);
    }
}
