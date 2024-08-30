package food_market.repository;


import food_market.model.Basket;
import food_market.model.enums.BasketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

    Optional<Basket> findByProfileEntityIdAndBasketStatus(Integer id, BasketStatus basketStatus);
}
