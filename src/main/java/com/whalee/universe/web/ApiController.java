package com.whalee.universe.web;

import com.whalee.universe.domain.order.Orders;
import com.whalee.universe.domain.user.Member;
import com.whalee.universe.domain.user.dto.MemberFormDto;
import com.whalee.universe.domain.util.Paging;
import com.whalee.universe.service.order.OrdersService;
import com.whalee.universe.service.user.MemberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "posts", description = "HTBeyond API")
@RequiredArgsConstructor
@RestController
public class ApiController {

    private final OrdersService ordersService;

    @ApiOperation(value="로그인한 유저의 정보 API", notes="현재 로그인한 유저의 정보")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/api/v1/user/info")
    public Member getMyInfo(){
        return (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @ApiOperation(value="로그인한 유저의 주문 정보 API", notes="현재 로그인한 유저의 주문 정보")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/api/v1/order/list/{id}")
    public List<Orders> getOrderList(@PathVariable Long id) {
        List<Orders> list = ordersService.getOrderList(id);

        return list;
    }

    @ApiOperation(value="다른 사람의 주문 정보 API", notes="다른 사람의 name 또는 email 정보를 String, 페이지 정보를 입력 받아 주문 정보 반환")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/api/v1/order/otherList/{name}")
    public List<Orders> getOtherOrderList(@PathVariable String name, @RequestBody Paging pageClass){
        Pageable pageable = PageRequest.of(pageClass.getPageNumber(), pageClass.getPageSize());
        List<Orders> list = ordersService.getOtherOrderList(name, pageable).getContent();

        return list;
    }
}