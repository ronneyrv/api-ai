package ronney.budgeting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "OPENAI_API_KEY", matches = ".+")
public class OpenAiSppchModelIT {
    @Autowired
    OpenAiAudioSpeechModel openAiSpeechModel;

    @Test
    public void shouldProduceAudioWhenTextIsProvided() throws IOException {
        var response = openAiSpeechModel.call("O valor total do serviço ficou em 80 reais. Posso confirmar o pagamento?");

        assertThat(response).hasSizeGreaterThan(1024);

        var tempFale = Files.createTempFile("AUDIO_", ".mp3");
        Files.write(tempFale, response);
        System.out.println(tempFale.toAbsolutePath());
    }
}
