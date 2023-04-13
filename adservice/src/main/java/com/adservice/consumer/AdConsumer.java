package com.adservice.consumer;

import com.adservice.ad.AdRepository;
import com.adservice.ad.Annuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;

@Component
public class AdConsumer {
    @Autowired
    AdRepository adRepository;
    @Bean
    public Consumer<String> consumer() {
        return (ids) -> {
            String [] ids_array = ids.split(" ");
            setExchange(ids_array);
        };
    }
    public void setExchange(String ids[]){
        System.out.println("i due annunci" + ids[0]+" "+ids[1]);
        Annuncio annuncio = adRepository.findAnnuncioById(ids[0]);
        annuncio.setExchange_id(ids[1]);
        adRepository.save(annuncio);
        annuncio = adRepository.findAnnuncioById(ids[1]);
        annuncio.setExchange_id(ids[0]);
        adRepository.save(annuncio);
    }
}
