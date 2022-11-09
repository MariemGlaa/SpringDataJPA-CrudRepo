package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProduitServiceImplMock {
    
    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    ProduitServiceImpl produitServiceImpl;

    Produit produit = new Produit(1L, "code1", "libelle1", 0,null,null, null, null, null);

    List<Produit> listProduits = new ArrayList<Produit>() {
        {
            add(new Produit(2L, "code2", "libelle2", 0, null, null, null, null, null));
            add(new Produit(3L, "code3", "libelle3", 0, null, null, null, null, null));
        }
    };

    @Test
    @Order(1)
    public void testretrieveProduit(){

        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        
        Assertions.assertNotNull(produitServiceImpl.retrieveProduit(2L));
    }

    @Test
    public void testaddProduit(){

        Mockito.when(produitRepository.save(produit)).thenReturn(produit);

        Assertions.assertNotNull(produitServiceImpl.addProduit(produit));
    }

    @Test
    public void testdeleteProduit(){

    	produitServiceImpl.deleteProduit(3L);

        Mockito.verify(produitRepository, times(1)).deleteById(3L);

        assertEquals(null, produitServiceImpl.retrieveProduit(3L));
    }
}