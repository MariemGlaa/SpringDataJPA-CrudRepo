package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FournisseurServiceTest {
    
    @Autowired
    private IFournisseurService fs;
    
    @Test
    @Order(1)
    public void testretrieveAllFournisseur() {

        Fournisseur fournisseur = Fournisseur.builder()
					.code("new")
					.libelle("should persist")
					.categorieFournisseur(CategorieFournisseur.CONVENTIONNE).build();

        assertNotNull(fs.retrieveAllFournisseurs(fournisseur));
    }
    @Test
    @Order(2)
    public void testaddFournisseur() {

        Fournisseur fournisseur = Fournisseur.builder()
					.code("new")
					.libelle("should persist")
					.categorieFournisseur(CategorieFournisseur.CONVENTIONNE).build();

        assertNotNull(fs.addFournisseur(fournisseur));
    }
    @Test
    @Order(3)
    public void testdeleteFournisseur() {
        fs.deleteFournisseur(1L)
        assertNotNull(fs.retrieveFournisseur(1L));
    }
    @Test
    @Order(4)
    public void testupdateFournisseur() {

        Fournisseur fournisseur = Fournisseur.builder()
					.code("new")
					.libelle("should persist")
					.categorieFournisseur(CategorieFournisseur.CONVENTIONNE).build();

        assertNotNull(fs.updateFournisseur(fournisseur));
    }
    
    
}
