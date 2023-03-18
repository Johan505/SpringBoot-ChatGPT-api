package com.openai.openai;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.dto.ChatResponse;
import io.github.flashvayne.chatgpt.service.ChatgptService;

@RestController
@RequestMapping("/chatbot")

public class HelloGPTController implements InitializingBean{
    
    @Autowired
    private ChatgptService chatgptService;

    @Override
    public void afterPropertiesSet() {
        System.out.println("Starting ChatGPT");
    }

    @GetMapping("/chat")
    public String chatWith(@RequestParam String message){
        System.out.println(message);
        return chatgptService.sendMessage(message);
    }

    @GetMapping("/prompt")
    public ChatResponse prompt(@RequestParam String message){
        Integer maxTokens = 300;

        String model = "text-davinci-003";

        Double temperature = 0.5;

        Double topP = 1.0;

        ChatRequest chatRequest = new ChatRequest(model, message, maxTokens, temperature, topP);
        ChatResponse res = chatgptService.sendChatRequest(chatRequest);
        System.out.println("Response was: " + res.toString());
        return res;
    }
}
