package food_market.controller;


import food_market.DTO.FoodDTO;
import food_market.service.FoodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/evos/food")
public class FoodController {
    private final FoodService foodService;

    @PostMapping("/create")
    public ResponseEntity<?> createFood(@Valid @RequestBody FoodDTO foodDTO) {
        return ResponseEntity.ok(foodService.create(foodDTO));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getFoodById(@PathVariable Integer id) {
        return ResponseEntity.ok(foodService.getFoodById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllFoods() {
        return ResponseEntity.ok(foodService.getAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFood(@Valid @RequestBody FoodDTO foodDTO, @PathVariable Integer id) {
        return ResponseEntity.ok(foodService.updateFood(foodDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFood(@PathVariable Integer id){
        return ResponseEntity.ok(foodService.delete(id));
    }


}
