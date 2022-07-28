package com.whalee.springboot.web;

import com.whalee.springboot.config.auth.LoginUser;
import com.whalee.springboot.config.auth.dto.SessionUser;
import com.whalee.springboot.service.posts.PostsService;
import com.whalee.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
    
    /*
    *  서버 재시작할 때마다 로그인 다시 해야되는 문제.
    * 1. 톰캣 세션 사용
    *  - 별다른 설정을 하지 않을 때 기본적으로 선택되는 방식
    *  - 톰캣(WAS)에 세션이 저장되기 때문에 2대 이상의 WAS 가 구동되는 환경에서는 톰캣들 간의 셋녀 공유를 위한 추가 설정이 필요
    * 2. MySQL 같은 데이터베이스를 세션 저장소로 사용
    *  - 여러 WAS 간의 공용 세션을 사용할 수 있는 가장 쉬운 방법
    *  - 많은 설정이 필요 없지만, 결국 로그인 요청마다 DB IO가 발생하여 성능상 이슈가 발생할 수 있음.
    *  - 보통 로그인 요청이 많이 없는 백오피스, 시내 시스템 용도에서 사용
    * 3. Redis, Memcached 와 같은 메모리 DB를 세션 저장소로 사용
    *  - B2C 서비스에서 가장 많이 사용하는 방식
    *  - 실제 서비스로 사용하기 위해서는 Embedded Redis 와 같은 방식이 아닌 외부 메모리  서버가 필요
    * 
    * 
    * */

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
