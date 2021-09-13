package com.sales.market.services;

import com.sales.market.model.Buy;
import com.sales.market.repository.BuyRepository;
import org.springframework.stereotype.Service;

@Service
public class BuyService {
    //otros servicios
    //servicioItemDetails
    private final BuyRepository buyRepository;  // nunca debes tener acceso a otros repositorios que no sean en este caso
    // Buy

    public BuyService(BuyRepository buyRepository) {
        this.buyRepository = buyRepository;
    }

    public Buy getById(Long id) {
        return buyRepository.getById(id);
    }

    public Buy save(Buy buy) {
        // llamada a un endpoint que nos diga mas informacion de buy
        // BuyExtraDetails   -> Buy

        //item details   llamar a otro microservicio  ofertas especiales de la fecha en particular
        //servicioItemDetails.ofertas  -> descuento precui del item  en buy
        //servicioItemDetails.getcoupon   -X%desc     persiste  cliente vendiendo
        // llamadas a BD mas info de configuran
        Buy savePersisted = buyRepository.save(buy);
        return savePersisted;
    }
}
