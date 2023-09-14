package steps.fe;//package step_definition.fe;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import page_object_model.fe.NavigationBar;
//import page_object_model.fe.TopicsScreen;
//
//public class TopicsScreen_StepDef {
//
//    @Then("User should be redirected to the topics screen")
//    public void userShouldBeRedirectedToTheTopicsScreen() {
//        TopicsScreen.assertThatUserRedirectedToTheTopicsScreen();
//    }
//
//    @When("User clicks skip on Topics Screen")
//    public void userClicksSkipOnTopicsScreen() {
//        TopicsScreen.clickSkip();
//    }
//
//    @Then("User should be redirected to the Cosmos screen")
//    public void userShouldBeRedirectedToTheCosmosScreen() {
//        NavigationBar.assertNavigationBarContent();
//        NavigationBar.assertCosmosScreenSelected();
//    }
//
//    @When("User clicks Go on Topics Screen")
//    public void userClicksGoOnTopicsScreen() {
//        TopicsScreen.clickGo();
//    }
//
//    @And("Topics Screen content should be displayed")
//    public void topicsScreenContentShouldBeDisplayed() {
//        TopicsScreen.assertTopicsScreenContent();
//    }
//}