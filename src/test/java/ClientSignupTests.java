import com.ultralesson.training.mobile.models.User;
import com.ultralesson.training.mobile.screen.HomeScreen;
import com.ultralesson.training.mobile.screen.LauncherScreen;
import com.ultralesson.training.mobile.screen.ProfileScreen;
import com.ultralesson.training.mobile.screen.SignupScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientSignupTests {

    @Test
    public void clientShouldBeAbleToSignupSuccessfully() {
        //Arrange
        LauncherScreen launcherScreen = new LauncherScreen(mobileDriver); // Assume mobileDriver is created and handy.
        launcherScreen.navToClientSignup();
        User client = new User("randomclient@gmail.com",
                "password",
                "Automation Client",
                "1234567890");

        //Act
        SignupScreen signupScreen = new SignupScreen(mobileDriver);
        HomeScreen homeScreen = signupScreen.signup(client);

        ProfileScreen profileScreen = homeScreen.navToProfile();
        User clientProfile = profileScreen.getProfileDetails();

        // Assert
        Assert.assertEquals(clientProfile.getEmail(), client.getEmail());
        Assert.assertEquals(clientProfile.getFullName(), client.getFullName());
        Assert.assertEquals(clientProfile.getMobile(), client.getMobile());

        // Assume we have called a date utility to supply Today's Date
        Assert.assertEquals(clientProfile.getMembershipStartDate(), "Today's Date");

    }
}
