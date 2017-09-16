package Steps;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
  In Java, there are two hooks @Before and @After
 */
public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {    // DI
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        System.out.println("I navigate to the login page");
        System.out.println();
    }
    /* And I enter the username as "admin" and password as "adminpassword" inside Login.feature
    @And("^I enter the username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iEnterTheUsernameAsAndPasswordAs(String username, String password) throws Throwable {
        System.out.println("The Username is " + username + " ,password is " + password);
    }
    */
    // Working with multiple data
    @And("^I enter the following for login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        System.out.println("The value is " + data.get(0).get(0).toString());
        System.out.println("The value is " + data.get(0).get(1).toString());
        /*
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        for (User user: users){
            System.out.println("The UsersName is " + user.username);
            System.out.println("The Password is " + user.password);
        } */
        Map<String, String> mapacol;
        mapacol = table.asMap(String.class, String.class);
        System.out.println("Username: " + mapacol.get("username") + "  Password: " + mapacol.get("password") );

    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String Username, String Password) throws Throwable {
        System.out.println("Username is : " + Username);
        System.out.println("Password is : " + Password);
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        System.out.println("I click login button");

    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {
        System.out.println("The driver is : " + base.StepInfo);
        System.out.println("I should see the userform page");

    }

    @And("^I enter the users email address as Email:admin$")
    public void iEnterTheUsersEmailAddressAsEmailAdmin() throws Throwable {

    }

    /*
    public class User {
        public String username;
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    } */
}
