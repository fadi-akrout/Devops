package tn.esprit.rh.achat.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CategorieProduitServiceImplTest  {
  @Mock
    CategorieProduitRepository categorieProduitRepository;

    @InjectMocks
    CategorieProduitServiceImpl categorieProduitService;

    Set listProduits=new HashSet<Produit>();
    CategorieProduit categorieProduit= new CategorieProduit(3L,"amir","aaaaa",listProduits);
    @Test
    void testRetrieveCategorieProduit() {
        // Arrange
        Set<Produit> listProduits = new HashSet<>();
        CategorieProduit categorieProduit = new CategorieProduit(3L, "123azerty", "tofeh", listProduits);

        Mockito.when(categorieProduitRepository.findById(3L)).thenReturn(Optional.of(categorieProduit));

        // Act
        CategorieProduit retrievedCategorieProduit = categorieProduitService.retrieveCategorieProduit(3L);

        // Assert
        Assertions.assertNotNull(retrievedCategorieProduit);
        Assertions.assertEquals(3L, retrievedCategorieProduit.getIdCategorieProduit());
        Assertions.assertEquals("123azerty", retrievedCategorieProduit.getCodeCategorie());
        Assertions.assertEquals("tofeh", retrievedCategorieProduit.getLibelleCategorie());
        Assertions.assertSame(listProduits, retrievedCategorieProduit.getProduits());
    }
}
