package com.boot.glief.service.resource;

import com.boot.glief.service.model.Configure;
import com.boot.glief.service.repository.ConfigureRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/rest/configure")
public class ConfigureResource {

    @Autowired
    ConfigureRespository configureRespository;

    @GetMapping("/getConfigure")
    public List<Configure> getAll() {
        return configureRespository.findAll();
    }

    @GetMapping(value = "/getConfigure/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Configure getAll(@PathVariable final Optional<Integer> id) throws ConfiureNotFoundException {
        Optional<Configure> configure = configureRespository.findById(id.get());
        if (!configure.isPresent()) {
            throw new ConfiureNotFoundException("id " + id);
        }
        return configure.get();
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Configure> addConfigure(@RequestBody final Configure configure) {
        configureRespository.save(configure);
        return configureRespository.findAll();
    }

    @DeleteMapping(value = "/removeConfigure/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Configure> removeConfigure(@PathVariable Optional<Integer> id) {
        configureRespository.deleteById(id.get());
        return configureRespository.findAll();
    }

    public String
    private class ConfiureNotFoundException extends Throwable {
        public ConfiureNotFoundException(String s) {
            System.out.println("Exception occured for id" + s);
        }
    }
}
