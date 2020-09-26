package com.examplespring.demo.controller;

import com.examplespring.demo.Component.Utilities;
import com.examplespring.demo.model.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api2")
public class PathRestIndexController {
    public PathRestIndexController(Utilities utilities) {
        this.utilities = utilities;
    }

    private Utilities utilities;

    @GetMapping("/sub/{liczba1}/{liczba2}")
    public ResponseEntity<Object> sub(@PathVariable(name = "liczba1") int l11, @PathVariable(name = "liczba2") int l22) {

        return ResponseEntity.ok(l22 - l11);
    }

    @GetMapping("/add/{liczba1}/{liczba2}")
    public ResponseEntity<Object> add(@PathVariable(name = "liczba1") int l1, @PathVariable(name = "liczba2") int l2) {

        return ResponseEntity.ok(l1 + l2);
    }


    // 3. Stwórz endpoint pod adresem /prime który sprawdza czy liczba jest pierwsza i w odpowiedzi zwraca "Yes" lub "No" wewenątrz APIResponse.
    @GetMapping("/prime/{liczba1}")
    public ResponseEntity<Object> prime(@PathVariable(name = "liczba1") int l1) {


        return ResponseEntity.ok(utilities.isPrime(l1) ? "Yes" : "No");
    }

    // 4. Stwórz endpoint pod adresem /check który sprawdza czy pierwsza liczba jest większa od drugiej. Wynik zwróć opakowany w APIResponse
    @GetMapping("/check/{liczba1}/{liczba2}")
    public ApiResponse check(@PathVariable(name = "liczba1") int l1, @PathVariable(name = "liczba2") int l2) {
        return new ApiResponse(l1 > l2 ? "yes" : "no");
    }


    // 5. Stwórz endpoint pod adresem /compare ktory zwraca wieksza liczbe. Wynik zwróć nieopakowany.
    @GetMapping("/compare/{liczba1}/{liczba2}")
    public int compare(@PathVariable(name = "liczba1") int l1, @PathVariable(name = "liczba2") int l2) {
        return l1 > l2 ? l1 : l2;
    }

// 6. Stworz endpoint pod adresem /div który dzieli liczby. Jeśli dzielnik = 0, to zwróć kod błędu 400 - bez ciała odpowiedzi

    @GetMapping("/div/{liczba1}/{liczba2}")
    public ResponseEntity<Object> div(@PathVariable(name = "liczba1") int l1, @PathVariable(name = "liczba2") int l2) {

        return l2==0 || l1 ==0? ResponseEntity.badRequest().body("400"):ResponseEntity.ok(l1/l2);
    }

    // 7. Stwórz metodę, która pobiera przez @RequestParam listę wartości i ją sortuje. Wynik zwraca bezpośrednio (nieopakowany)


}
