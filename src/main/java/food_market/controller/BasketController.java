package food_market.controller;


import food_market.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/evos/basket")
public class BasketController {
    private final BasketService basketService;
    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createBasket(@PathVariable Integer userId){

        return ResponseEntity.ok(basketService.create(userId));
    }

    @GetMapping("get/{userId}")
    public ResponseEntity<?> getCurrentBasket(@PathVariable Integer userId){
        return ResponseEntity.ok(basketService.get(userId));
    }

    @PutMapping("orderFood/{baskedId}")
    public ResponseEntity<?> orderFood(@PathVariable Integer baskedId){
        return ResponseEntity.ok(basketService.orderFood(baskedId));
    }
}
