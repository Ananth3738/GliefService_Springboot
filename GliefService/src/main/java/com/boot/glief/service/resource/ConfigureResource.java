package com.boot.glief.service.resource;

import com.boot.glief.service.model.Configure;
import com.boot.glief.service.repository.ConfigureRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/rest/configure")
public class ConfigureResource {

    private static final int PORT = 8080;
    @Autowired
    ConfigureRespository configureRespository;
//access.net.abnamro.com/accelerated_pac_base.pac
    private final String PROXY_URL = "nl-userproxy-access.net.abnamro.com";

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

    //    public String
    private class ConfiureNotFoundException extends Throwable {
        public ConfiureNotFoundException(String s) {
            System.out.println("Exception occured for id" + s);
        }
    }

    @GetMapping(value = "/lei/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String fecthGliefDetails(@PathVariable final Optional<String> id) throws IOException {
        StringBuilder url = new StringBuilder("https://leilookup.gleif.org/api/v2/leirecords?lei=");
        url.append(id.get());
        StringBuilder builder = new StringBuilder();
        try {
            URL conn = new URL(url.toString());
            URLConnection urlConnection = null;
            if (this.PROXY_URL != null) {
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_URL, PORT));
                urlConnection = conn.openConnection(proxy);
                if (urlConnection != null) {
                    InputStream inputStream = urlConnection.getInputStream();
                    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                        String val;
                        while ((val = bufferedReader.readLine()) != null) {
                            builder.append(val);
                        }
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
