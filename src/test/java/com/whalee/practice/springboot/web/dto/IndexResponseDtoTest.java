package com.whalee.practice.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class IndexResponseDtoTest {

    @Test
    public void lombok_func_test(){
        //given
        String name = "whalee";
        int amount = 1000;

        //when
        IndexResponseDto dto = new IndexResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
