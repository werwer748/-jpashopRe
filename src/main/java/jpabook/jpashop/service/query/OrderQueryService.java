package jpabook.jpashop.service.query;

import jpabook.jpashop.api.OrderApiController;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderQueryService {
    /**
     * OSIV: open-in-view - 애플리케이션 설정에서 적용
     * false일 경우 트랜잭션 내에서만 영속성 컨텍스트가 유지된다.
     * true라면 요청의 시작부터 끝까지 영속성 컨텍스트가 유지 됨
     * false로 두고 쓰는 것이 커넥션 풀 관리에 유리한면이 있다
     * 하지만 영속성 컨텍스트가 살아있는 동안 DB 관련 로직이 처리되어야 하기 떄문에 관심사를 철저히 나누어
     * 서비스 계증과 컨트롤러 계층을 나누는 것이 중요하다.
     */

    private final OrderRepository orderRepository;

    public List<OrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithItem();

        for (Order order : orders) {
            System.out.println("order = " + order + " id= " + order.getId());
        }

        List<OrderDto> list = orders.stream()
                .map(o -> new OrderDto(o))
                .toList();
        return  list;
    }

}
