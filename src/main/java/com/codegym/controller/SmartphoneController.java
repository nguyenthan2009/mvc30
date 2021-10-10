package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }
//    @GetMapping
//    public ResponseEntity<Page<Smartphone>> allPhones(@PageableDefault(sort = "producer", size = 2) Pageable pageable) {
//        return new ResponseEntity<>(smartphoneService.findAll(pageable), HttpStatus.OK);
//    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage(@PageableDefault(sort="producer" ,size = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll(pageable));
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
//        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
//        if (!smartphoneOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        smartphoneService.remove(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> updateSmartPhone(@PathVariable Long id){
        Optional<Smartphone> smartphone1 = smartphoneService.findById(id);
        return new ResponseEntity<>(smartphone1.get(), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<?> findAllByTitle(@RequestParam("producer") String producer){
        return new ResponseEntity<>(smartphoneService.finebyProduct(producer),HttpStatus.OK);
    }

}
