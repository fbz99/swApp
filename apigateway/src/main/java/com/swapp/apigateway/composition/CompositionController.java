package com.swapp.apigateway.composition;

import com.swapp.apigateway.feign.AnnuncInterface;
import com.swapp.apigateway.feign.MatcherInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/annuncio")
public class CompositionController {

    @Autowired
    private AnnuncInterface annuncInterface;
    @Autowired
    private MatcherInterface matcherInterface;

    @GetMapping("/{id}")
    public CompositionResult getAnnuncio(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
           String username = request.getHeaders("username").nextElement();
           Annuncio annuncio= annuncInterface.getAnnuncio(id);
                if(annuncio == null) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "ad not found");
                    return null;
                }
                List<Annuncio> vectorD = new ArrayList<>();
                List<Annuncio> vectorL = new ArrayList<>();
                CompositionResult compositionResult = new CompositionResult();
                VectorM vectorM = matcherInterface.getVectors(id);
                if(vectorM != null) {
                    List<String> vectorF = new ArrayList<String>();
                    if (vectorM.getVector_f() != null) vectorF.addAll(vectorM.getVector_f());
                    if (vectorM.getVector_d() != null && annuncio.getOwner().equals(username)) {
                        for (String ad : vectorM.getVector_d()) {
                            Annuncio annuncio1 = annuncInterface.getAnnuncio(ad);
                            annuncio1.setLiked(false);
                            if (vectorF.contains(ad)) annuncio1.setLiked(true);
                            vectorD.add(annuncio1);
                        }
                        compositionResult.setVectorD(vectorD);
                    }
                    if (vectorM.getVector_l() != null) {
                        for (String ad : vectorM.getVector_l()) {
                            vectorL.add(annuncInterface.getAnnuncio(ad));
                        }
                        compositionResult.setVectorL(vectorL);
                    }
                }
                compositionResult.setMainAnnuncio(annuncio);
                return compositionResult;
    }
}
