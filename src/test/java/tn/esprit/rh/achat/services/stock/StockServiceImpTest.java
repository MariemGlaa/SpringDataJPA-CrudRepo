package tn.esprit.rh.achat.services.stock;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StockServiceImpTest {

	@Autowired
	IStockService stockService;
	
	@Test
	@Order(1)
	public void testAddStock() {
		Stock s = new Stock("stock test",100,10);
		Stock savedStock = stockService.addStock(s);
		Assertions.assertEquals(s.getLibelleStock(),savedStock.getLibelleStock());
	}
	
	
	
	
	
}
