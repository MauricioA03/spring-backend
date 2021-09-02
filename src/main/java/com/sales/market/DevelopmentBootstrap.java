package com.sales.market;

import com.sales.market.model.Buy;
import com.sales.market.repository.BuyRespository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DevelopmentBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private BuyRespository buyRespository;

    // injeccion evita hacer instancia   = new Clase();
    // bean pueden tener muchos campos y otros beans asociados
    public DevelopmentBootstrap(BuyRespository buyRespository) {
        this.buyRespository = buyRespository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("evento de spring");
        persistBuy(BigDecimal.TEN);
        persistBuy(BigDecimal.ONE);
    }

    private void persistBuy(BigDecimal value) {
        Buy buy = new Buy();
        buy.setValue(value);
        buyRespository.save(buy);
    }
}