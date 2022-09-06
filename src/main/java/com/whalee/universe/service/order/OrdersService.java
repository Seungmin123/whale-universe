package com.whalee.universe.service.order;

import com.whalee.universe.domain.order.Orders;
import com.whalee.universe.domain.order.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public List<Orders> getOrderList(Long id){
        return ordersRepository.getOrderList(id);
    }

    public Page<Orders> getOtherOrderList(String name, Pageable pageable){
        if(name.equals("undefined")) name = "";
        Page<Orders> list = ordersRepository.getOtherOrderList(name, pageable);
        return list;
    }
}

