package steps.fe;

import io.cucumber.java.en.Given;
import pages.fe.NotificationPopUp;

public class NotificationsPopUp_StepDef {

    @Given("User allow notifications po up")
    public void userAllowNotificationsPoUp() {
        NotificationPopUp.allowNotifications();
    }
}