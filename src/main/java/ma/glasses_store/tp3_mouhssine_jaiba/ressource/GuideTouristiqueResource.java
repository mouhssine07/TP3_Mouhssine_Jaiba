package ma.glasses_store.tp3_mouhssine_jaiba.ressource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.glasses_store.tp3_mouhssine_jaiba.llm.InfosTouristiques;
import ma.glasses_store.tp3_mouhssine_jaiba.llm.LlmClientForGuideTouristique;

/**
 * @author SETUP GAME
 **/
@Path("/guide")
public class GuideTouristiqueResource {
    @Inject LlmClientForGuideTouristique llmClient;

    @GET
    @Path("lieu/{ville_ou_pays}/{nb}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response guide(
            @PathParam("ville_ou_pays") String lieu,
            @PathParam("nb") @DefaultValue("2") int nb) {

        InfosTouristiques infos = llmClient.envoyer(lieu, nb);

        return Response.ok(infos)
                .header("Access-Control-Allow-Origin", "*")
                .header("Cache-Control", "no-store")
                .header("Pragma", "no-cache")
                .header("Expires", "0")
                .build();
    }
}