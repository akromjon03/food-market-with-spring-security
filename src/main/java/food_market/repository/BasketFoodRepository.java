package food_market.repository;


import food_market.model.BasketFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketFoodRepository extends JpaRepository<BasketFood, Integer> {
}
