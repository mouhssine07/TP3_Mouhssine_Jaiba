package ma.glasses_store.tp3_mouhssine_jaiba.llm;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.service.SystemMessage;

/**
 * @author SETUP GAME
 **/
public interface GuideTouristique {
    @SystemMessage("""
        Tu es un guide touristique. 
        Donne {nb} endroits à visiter pour {lieu}.
        Réponds en JSON exact :
        { "ville_ou_pays": "...", 
          "endroits_a_visiter": ["..."], 
          "prix_moyen_repas": "... <devise>" }
        Pas de Markdown.
        """)
    InfosTouristiques guide(@P("lieu") String lieu, @P("nb") int nb);
}