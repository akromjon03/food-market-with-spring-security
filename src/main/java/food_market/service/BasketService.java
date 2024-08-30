package food_market.service;

;
import food_market.exceptions.NotFoundException;
import food_market.model.Basket;
import food_market.model.enums.BasketStatus;
import food_market.repository.BasketRepository;
import food_market.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    private final ProfileRepository profileRepository;



    public Object create(Integer id) {
        if (!profileRepository.existsById(id)) {
            throw new NotFoundException("User not found");
        }

        Optional<Basket> oldBasket = basketRepository.findByProfileEntityIdAndBasketStatus(id, BasketStatus.BASKET);
        if (oldBasket.isPresent()) {
            return oldBasket.get();
        }

        Basket basket = new Basket();
        basket.setBasketStatus(BasketStatus.BASKET);
        basket.setProfileEntity(profileRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found")));
        basketRepository.save(basket);
        return basket;
    }

    public Object get(Integer userId) {
        if (!profileRepository.existsById(userId)) {
            throw new NotFoundException("User not found");
        }

        Optional<Basket> oldBasket = basketRepository.findByProfileEntityIdAndBasketStatus(userId, BasketStatus.BASKET);
        if (oldBasket.isPresent()) {
            return oldBasket.get();
        }
        return "Current basket not found";
    }

    public Object orderFood(Integer basketId){

        return null;
    }
}
