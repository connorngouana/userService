package ie.atu.userservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

    @FeignClient(name= "noti-service",url = "http://localhost:8083")
    public interface NotificationServiceClient
    {
        @PostMapping("/noticonfirm")
        String notiDetails(@RequestBody UserDetails userDetails);

    }

