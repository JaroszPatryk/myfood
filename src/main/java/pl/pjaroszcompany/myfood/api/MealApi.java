package pl.pjaroszcompany.myfood.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.pjaroszcompany.myfood.domain.meal.Meal;
import pl.pjaroszcompany.myfood.domain.meal.MealService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/meal")
@AllArgsConstructor
public class MealApi {

    private MealService mealService;

    @GetMapping
    public List<Meal> getAll() {
        return mealService.getAll();
    }

    @GetMapping("/{mealId}")
    public ResponseEntity<Meal> getOne(@PathVariable Long mealId) {
        return mealService.getMealById(mealId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createMeal(@RequestBody @Valid Meal meal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(er -> er.getDefaultMessage())
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errors);
        }
        mealService.create(meal);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    public void updateMeal(@RequestBody Meal meal) {
        mealService.update(meal);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMeal(@RequestParam Long mealId) {
        mealService.delete(mealId);
    }
}
