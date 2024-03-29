//package com.whalee.springboot.domain.posts;
//
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest // 별다른 설정 없이 쓰면 H2 데이터베이스를 자동으로 실행해줌.
//public class PostsRepositoryTest {
//
//    @Autowired
//    PostsRepository postsRepository;
//
//    @After //JUnit 단위 테스트 끝날 때마다 수행되는 메소드
//    // 보통은 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용
//    public void cleanup() {
//        postsRepository.deleteAll();
//    }
//
//    @Test
//    public void load_saved_contents(){
//        //given
//        String title = "테스트 게시글";
//        String content = "테스트 본문";
//
//        // 테이블 posts에 insert / update 쿼리를 실행
//        // id 값이 있다면 update, 없다면 insert 실행
//        postsRepository.save(Posts.builder()
//                .title(title)
//                .content(content)
//                .author("whalee@gmail.com")
//                .build());
//
//        //when
//        // 테이블 posts에 있는 모든 데이터 조회
//        List<Posts> postsList = postsRepository.findAll();
//
//        //then
//        Posts posts = postsList.get(0);
//        assertThat(posts.getTitle()).isEqualTo(title);
//        assertThat(posts.getContent()).isEqualTo(content);
//    }
//
//    @Test
//    public void baseTimeEntity_add(){
//        //given
//        LocalDateTime now = LocalDateTime.of(2022, 7, 28, 0, 0, 0);
//        postsRepository.save(Posts.builder()
//                .title("title")
//                .content("content")
//                .author("author")
//                .build());
//
//        //when
//        List<Posts> postsList = postsRepository.findAll();
//
//        //then
//        Posts posts = postsList.get(0);
//
//        System.out.println(">>>>>>>>>>>>>>>>>create Date=" + posts.getCreatedDate()
//                + ", modifiedDate=" + posts.getModifiedDate());
//
//        assertThat(posts.getCreatedDate()).isAfter(now);
//        assertThat(posts.getModifiedDate()).isAfter(now);
//    }
//}
