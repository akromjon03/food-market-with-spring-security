package food_market.controller;


import food_market.DTO.BasketFoodDTO;
import food_market.service.BasketFoodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/evos/basketFood")
public class BasketFoodController {
    private final BasketFoodService basketFoodService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody BasketFoodDTO basketFoodDTO){
        return ResponseEntity.ok(basketFoodService.create(basketFoodDTO));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id){
        return ResponseEntity.ok(basketFoodService.get(id));
    }



}
