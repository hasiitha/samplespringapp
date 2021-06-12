package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private MovieRepository movieRepository;

    @CrossOrigin
    @GetMapping(value = "/")
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @GetMapping(value ="/{movieId}")
    public Movie
    getMovieById(@PathVariable String movieId){
        return movieRepository.findMovieById(movieId);
    }


    @PostMapping(value = "/create")
    public Movie addMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    @PutMapping(value = "/update/{movieId}")
    public Movie updateMovie(@PathVariable String movieId,@RequestBody Movie movie){
        return movieRepository.save(movie);
    }
    @DeleteMapping(value = "/delete/{movieId}")
    public void deleteMovie(@PathVariable String movieId){
        movieRepository.deleteById(movieId);
    }

}
