package StepDefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.browser.DriverFactory;
import com.qa.browser.DriverManager;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.ReadProperty;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginpage = new LoginPage();
	public String pageTitle;

	 @Given("^User in Github page$")
	    public void user_in_github_page() throws Throwable {
	        DriverManager.getDriver().get(ReadProperty.getProperty("URL"));
	    }

	    @When("^User click on SignIn button$")
	    public void user_click_on_signin_button() throws Throwable {
	    	loginpage.clickOnSignIn();
	    }

	    @Then("^Verify the URL contains \"([^\"]*)\"$")
	    public void verify_the_url_contains_something(String strArg1) throws Throwable {
	        Assert.assertEquals(strArg1, loginpage.verifyURL());
	    }

	    @Then("^User verify that Email and Password fields are dispalyed$")
	    public void user_verify_that_email_and_password_fields_are_dispalyed() throws Throwable {
	        Assert.assertTrue(loginpage.isEmailDisplayed());
	        Assert.assertTrue(loginpage.isPasswordDisplayed());
	    }
	    
	    @Then("^User enters the Username and Password and clicks Login Button$")
	    public void user_enters_the_username_and_password_and_clicks_login_button(DataTable table) throws Throwable {
	    	List<Map<String, String>> credList = table.asMaps();
			String userName = credList.get(0).get("Username");
			String password = credList.get(0).get("Password"); 
			HomePage homepage = loginpage.doLogin(userName, password);
	    }

}
