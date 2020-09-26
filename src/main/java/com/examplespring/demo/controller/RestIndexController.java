package com.examplespring.demo.controller;

import com.examplespring.demo.Component.Utilities;
import com.examplespring.demo.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//prefix dla wszystkich metod w klasie
public class RestIndexController {
//zwraca tylko trsc json
    Utilities utilities;

    public RestIndexController(Utilities utilities) {
        this.utilities = utilities;
    }

    @GetMapping("/")
    public ApiResponse index(){
        return new ApiResponse("Sieema mordo");

        //Reqquest param
        //Path variable


    }
//localhost:8080/api/welcome?imieTwe=...
    @GetMapping("/welcome")
        public ApiResponse welcome(@RequestParam(name="imieTwe")String imie){

        return new ApiResponse("Welcome "+imie+" !");
    }


//1.  Stwórz endpoint pod adresem /add który pobiera dwa parametry i dodaje je do siebie, po czym zwraca wynik nie opakowany w APIResponse
//2.  Stwórz endpoint pod adresem /sub który pobiera dwa parametry i odejmuje ich wartości od siebie, po czym zwraca wynik opakowany w APIResponse


    @GetMapping("/sub")
    public ApiResponse sub(@RequestParam(name="liczba1")int l11, @RequestParam(name="liczba2")int l22){

        return new ApiResponse(String.valueOf(l11-l22));
    }

    @GetMapping("/add")
    public int add(@RequestParam(name="liczba1")int l1, @RequestParam(name="liczba2")int l2){

        return l1+l2;
    }

    // 3. Stwórz endpoint pod adresem /prime który sprawdza czy liczba jest pierwsza i w odpowiedzi zwraca "Yes" lub "No" wewenątrz APIResponse.
    @GetMapping("/prime")
    public ApiResponse prime(@RequestParam(name="l1")int l1){

        return new ApiResponse(utilities.isPrime(l1)?"Yes":"No");
    }

    // tablice
// 4. Funkcja do sumowania wartości
// http://localhost:8080/api/sum?tablica=3.0,4.0,5.0

    @GetMapping("/sum")
    public double sum(@RequestParam(name="tablica") List<Double> tablica){
        return tablica.stream().mapToDouble(Double::doubleValue).sum();
    }


    // PathVariable
    private static int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    // http://localhost:8080/api/tablica/3
    // http://localhost:8080/student?studentId=3 => // http://localhost:8080/student/3
    @GetMapping("/tablica/{indeks}")
    public ResponseEntity<Object> zwrocZTablicy(@PathVariable(name = "indeks") int index) {
        if (index < 0 || index > array.length) {
//            return ResponseEntity.badRequest().build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
//        return ResponseEntity.ok(array[index]);
        return ResponseEntity.status(HttpStatus.OK).body(array[index]);
    }
}
