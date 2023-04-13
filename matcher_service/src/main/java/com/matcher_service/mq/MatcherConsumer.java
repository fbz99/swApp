package com.matcher_service.mq;
import com.matcher_service.db.Annuncio;
import com.matcher_service.db.VectorD;
import com.matcher_service.db.VectorDRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
@Component
public class MatcherConsumer {

    @Autowired
    VectorDRepo vectorDRepo;
    @Bean
    public Consumer<Annuncio> onReceive() {
        return (annuncio) -> {
            System.out.println(annuncio.getId());
            Match(annuncio);
        };
    }
    public void Match(Annuncio annuncio){
        VectorD vectorD = new VectorD();
        List<VectorD> vectorDList = new ArrayList<>(vectorDRepo.findByCategoriesInAndOwnerNot(annuncio.getCategorie(),annuncio.getOwner()));
        List<String> vector = new ArrayList<>(vectorDList.stream().map(VectorD::getAd_id).toList());
        vectorD.setVector_d(vector);
        vectorD.setCategories(annuncio.getCategorie());
        vectorD.setAd_id(annuncio.getId());
        vectorD.setOwner(annuncio.getOwner());
        vectorDRepo.save(vectorD);
        // FARE REFACTORING DEL CODICE SOTTOSTANTE
        for( VectorD vectord : vectorDList){
            vector.clear();

            if(!annuncio.getOwner().equals(vectord.getOwner())) {
                vector.addAll(vectord.getVector_d());
                vector.add(vectorD.getAd_id());
                vectord.setVector_d(vector);
                vectorDRepo.save(vectord);
            }
        }
    }

}