package com.yannicl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestRedisConfiguration.class)
public class ProductRepositoryTest {

    @Autowired
    ProductPriceList productPriceList;

    @Test
    public void quand_la_liste_est_chargee_alors_la_liste_contient_3_produits() {
        assertEquals(3, productPriceList.count());
    }

    @Test
    public void quand_la_liste_est_chargee_et_que_on_recherche_le_moins_cher_alors_la_liste_retourne_le_moins_cher() {
        assertEquals("2", productPriceList.cheapest().getId());
    }

    @Test
    public void quand_la_liste_est_chargee_et_que_on_recherche_le_plus_cher_alors_la_liste_retourne_le_plus_cher() {
        assertEquals("1", productPriceList.mostExpensive().getId());
    }

}
