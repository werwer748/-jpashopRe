package jpabook.jpashop.service.query;

import jpabook.jpashop.api.OrderApiController;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter // getter만 열어줘도 일단 결과가 들어옴
public class OrderDto {

    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;
    private List<OrderItemDto> orderItems;

    public OrderDto(Order order) {
        orderId = order.getId();
        name = order.getMember().getName();
        orderDate = order.getOrderDate();
        orderStatus = order.getStatus();
        address = order.getDelivery().getAddress();
        /**
         * order는 dto가 나가는데 정작 orderItem은 모든 데이터가 나가버림
         * 귀찮더라도 모두 dto로 감싸서 내보내기
         */
        // order.getOrderItems().stream().forEach(o -> o.getItem().getName());

        orderItems = order.getOrderItems().stream()
                .map(OrderItemDto::new).toList();
    }
}