package StepDefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.browser.DriverManager;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.ReadProperty;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class HomePageSteps {
	
	public HomePage homepage = new HomePage();
	
    @Given("^User click on Profile button$")
    public void user_click_on_profile_button() throws Throwable {
    	homepage.clickProfile();
    }

    @Then("^User Validates the profile options texts$")
    public void user_validates_the_profile_options_texts(DataTable table) throws Throwable {
    	List<String> expected = table.asList();
    	List<String> actual = homepage.getTextOfDropdown();
    	Assert.assertTrue(expected.containsAll(actual));
    }

}
