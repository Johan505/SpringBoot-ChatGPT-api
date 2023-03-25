package com.openai.openai;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.dto.ChatResponse;
import io.github.flashvayne.chatgpt.service.ChatgptService;

@RestController
@RequestMapping("/chatbot")
@CrossOrigin(origins = "http://localhost:4200")

public class ChatGPTController implements InitializingBean{
    
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



}
