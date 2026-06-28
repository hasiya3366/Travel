package com.example.TravelApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync; // 🎯 මේ import එක ඉබේම වැටෙයි, නැත්නම් දාන්න.

@SpringBootApplication
@EnableAsync // 🚀 මෙන්න මෙතනට තමයි මේක එකතු කරන්න ඕනේ!
public class TravelAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelAppApplication.class, args);
    }

}
