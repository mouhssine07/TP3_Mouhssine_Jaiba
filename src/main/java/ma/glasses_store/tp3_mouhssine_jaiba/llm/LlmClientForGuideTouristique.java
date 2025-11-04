package ma.glasses_store.tp3_mouhssine_jaiba.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Singleton;

/**
 * @author SETUP GAME
 **/
@ApplicationScoped
public class LlmClientForGuideTouristique {

    private final GuideTouristique guide;

    public LlmClientForGuideTouristique() {
        String apiKey = System.getenv("GEMINIKEY");
        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-1.5-flash")
                .temperature(0.7)
                .build();

        this.guide = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .build();
    }

    public InfosTouristiques envoyer(String lieu, int nb) {
        return guide.guide(lieu, nb);
    }
}