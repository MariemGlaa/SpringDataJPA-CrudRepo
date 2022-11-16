package tn.esprit.rh.achat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.rh.achat.entities.CategorieFournisseur;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FournisseurDTO {
    
	private String code;

	private String libelle;

	private CategorieFournisseur  categorieFournisseur;
}