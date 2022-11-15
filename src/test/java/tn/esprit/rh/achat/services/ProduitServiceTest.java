package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Produit;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.services.IProduitService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceTest {
    
    @Autowired
    private IProduitService produitService;

    @Test
    @Order(1)
     void retrieveAllProduitTest() throws ParseException {
        List<Produit> produitList= produitService.retrieveAllProduits();
        Long count=produitRepository.count();
        Assertions.assertEquals(count,produitList.size());
    }
   @Test
    @Order(2)
    public void addProduitTest() throws  ParseException{
       SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
       Date dc= dateFormat.parse("2022-09-15");
       Date dm= dateFormat.parse("2022-10-30");
        Produit p= new Produit(2L, "code2", "libelle2", 0, null, null, null, null, null);
        Produit produit=produitService.addProduit(p);
        Assertions.assertEquals(p.getCodeProduit(),produit.getCodeProduit());
    }
    @Test
    @Order(3)
    public void updateProduitTest() throws ParseException{
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Date dc= dateFormat.parse("2022-09-15");
        Date dm= dateFormat.parse("2022-10-30");
        Produit p= new Produit(2L, "code2", "libelle2", 0, null, null, null, null, null);
        Produit produit=produitService.updateProduit(p);
        Assertions.assertEquals(p.getCodeProduit(),produit.getCodeProduit());
    }
  /*  @Test
    @Order(4)
    public void retrieveProduitTest(){
        Produit produit=produitService.retrieveProduit((long)1);
        Assertions.assertEquals(1L,produit.getIdProduit());

    }

    @Test
    @Order(5)
    public void deleteProduitTest(){
        produitService.deleteProduit(1L);
        Assertions.assertNull(produitService.retrieveProduit(1L));
    }*/
}
