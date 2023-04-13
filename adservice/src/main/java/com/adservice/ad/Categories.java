package com.adservice.ad;

import org.springframework.stereotype.Component;
import java.util.*;


@Component
public class Categories {
    private final HashMap<String,List<String>> categories = new HashMap<>(){{

        put("Elettronica",List.of("Informatica","Console e Videogiochi","Smartphone e tablet"));
        put("Arredamento e Casalinghi",List.of("Elettrodomestici","Giardino"));
        put("Sports e hobby",List.of("Animali","Intrattenimento", "Strumenti Musicali"));
        put("Per la persona",List.of("Abbigliamento e Accessori"));

    }};

    public boolean isValid(List<String> cats) {
        //soluzione sempliciotta
        int count=0;
        for (List<String> strings : categories.values().stream().toList()) {
            for (String cat : cats) if (strings.contains(cat)) count++;
        }
        return count == cats.size();
    }

}
