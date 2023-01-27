package com.whalee.universe.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class CommonResponse<T> {

    private final String code;

    private final String message;

    private final List<T> item;
}
