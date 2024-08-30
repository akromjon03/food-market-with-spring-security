package food_market.service;

import food_market.DTO.BasketFoodDTO;
import food_market.exceptions.NotFoundException;
import food_market.model.Basket;
import food_market.model.BasketFood;
import food_market.model.Food;
import food_market.repository.BasketFoodRepository;
import food_market.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketFoodService {
    private final BasketFoodRepository basketFoodRepository;
    private final BasketRepository basketRepository;
    private final FoodService foodService;


    public Object create(BasketFoodDTO basketFoodDTO) {

        Basket basket = basketRepository.findById(basketFoodDTO.basketId()).orElseThrow(() -> new NotFoundException("Not found basket"));
        Food food = foodService.getFoodById(basketFoodDTO.foodId());

        BasketFood basketFood = new BasketFood();
        basketFood.setBasket(basket);
        basketFood.setFood(food);
        basketFood.setCount(basketFoodDTO.count());

        return basketFoodRepository.save(basketFood);

    }


    public Object get(Integer id) {
        return basketFoodRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found basketFood"));
    }
}
