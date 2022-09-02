package com.whalee.universe.domain.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT o FROM Orders o WHERE member_id = :member_id ORDER BY o.id desc")
    public List<Orders> getOrderList(@Param("member_id") Long id);

    @Query(value = "with USER_DATA as (\n" +
            "select member_id, name\n" +
            "from member\n" +
            "where name like %:name%\n" +
            "or email like %:name%\n" +
           ")\n" +
           "select created_date,order_num, item_name, name, id, modified_date, member_id \n" +
           "from (\n" +
            "select max(created_date) over (partition by o.member_id) as max_date, created_date, o.order_num, o.item_name, u.name, o.id, o.modified_date, u.member_id\n" +
            "from orders o\n" +
             "inner join USER_DATA u on u.member_id = o.member_id\n" +
           ") v\n" +
           "where v.max_date = v.created_date",
            countQuery = "with USER_DATA as (\n" +
                    "select member_id, name\n" +
                    "from member\n" +
                    "where name like %:name%\n" +
                    "or email like %:name%\n" +
                    ")\n" +
                    "select count(*) \n" +
                    "from (\n" +
                    "select max(created_date) over (partition by o.member_id) as max_date, created_date, o.order_num, o.item_name, u.name, o.id, o.modified_date, u.member_id\n" +
                    "from orders o\n" +
                    "inner join USER_DATA u on u.member_id = o.member_id\n" +
                    ") v\n" +
                    "where v.max_date = v.created_date",
            nativeQuery = true)
    public Page<Orders> getOtherOrderList(@Param("name") String name, Pageable pageable);

//    @Query(value = "select * from orders", nativeQuery = true)
//    public List<Object[]> getOtherOrderList(@Param("name") String name);

}
