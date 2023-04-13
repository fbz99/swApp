package com.adservice.controller;
import com.adservice.ad.Annuncio;
import com.adservice.service.AdService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ComponentScan("com.adservice.service")
@RestController
public class AdController {
    @Autowired
    AdService adService;
    StreamBridge streamBridge;

    public AdController(StreamBridge streamBridge){
        this.streamBridge = streamBridge;
    }
    @GetMapping("/myads")
    public ArrayList<Annuncio> getAds(HttpServletRequest request)
    {
       return adService.getAnnunci(Objects.requireNonNull(request.getHeaders("username").nextElement()));
    }
    @GetMapping("/ads")
    public List<Annuncio> getAllAds(HttpServletRequest request)
    {
        return adService.getAllAds(Objects.requireNonNull(request.getHeaders("username").nextElement()));
    }
    @PostMapping("/ad")
    public Annuncio createAnnuncio(@RequestBody Annuncio annuncio, HttpServletResponse response,HttpServletRequest request) throws IOException
    {
        System.out.println(request.getHeaders("username").nextElement());
        annuncio.setOwner(request.getHeaders("username").nextElement());
        if (!adService.createAnnuncio(annuncio)) response.sendError(Response.SC_BAD_REQUEST,"error while saving swap ad");
        else streamBridge.send("annunciqueue", annuncio);
        return annuncio;
    }

    @PostMapping("/ad/{id}")
    public void createAndLike(@RequestBody Annuncio annuncio,@PathVariable String id ,HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(!adService.createAndLike(annuncio,id,streamBridge,request.getHeaders("username").nextElement()))  response.sendError(Response.SC_BAD_REQUEST,"error while saving ad");

    }

    @GetMapping("/ad/{id}")
    public Annuncio getAnnuncio(@PathVariable String id) {
        return adService.getAnnuncio(id);
    }

    @PostMapping("/ad/{id}/like")
    public void like(@PathVariable String id, HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id_dest = request.getReader().readLine();
        String username = request.getHeaders("username").nextElement();
        if(!adService.like(id,id_dest,username))  response.sendError(Response.SC_BAD_REQUEST,"error while saving ad");
        streamBridge.send("likequeue",id +" "+ id_dest + " false");
    }

}
