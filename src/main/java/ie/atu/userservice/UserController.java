package ie.atu.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    private RegistrationServiceClient myRegistrationServiceClient;
    private final UserService myUserService;
    private NotificationServiceClient notificationServiceClient;

    @Autowired
    public UserController(RegistrationServiceClient myRegistrationServiceClient, UserService myUserService, NotificationServiceClient notificationServiceClient)
    {
        this.myRegistrationServiceClient = myRegistrationServiceClient;
        this.myUserService = myUserService;
        this.notificationServiceClient = notificationServiceClient;
    }

    @PostMapping("/confirm-and-reg")
    public String Registering(@RequestBody UserDetails userDetails)
    {
        String confirm_details = myRegistrationServiceClient.someDetails(userDetails);
        String reply = confirm_details + " " + myUserService.UserInfo(userDetails);
        return reply;
    }
    @PostMapping("/noticonfirmation")
    public String noti(@RequestBody UserDetails userDetails)
    {
        String confirm_noti_details = notificationServiceClient.notiDetails(userDetails);
        String replynoti = myUserService.UserInfo(userDetails) + " " + myRegistrationServiceClient.someDetails(userDetails) + " " + confirm_noti_details ;
        return replynoti;
    }

}
