package ma.glasses_store.tp3_mouhssine_jaiba.llm;

import java.util.List;

/**
 * @author SETUP GAME
 **/
public record InfosTouristiques(
        String ville_ou_pays,
        List<String> endroits_a_visiter,
        String prix_moyen_repas) {}