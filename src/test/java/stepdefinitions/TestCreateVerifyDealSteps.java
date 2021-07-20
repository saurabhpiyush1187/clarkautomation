package stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import com.factory.DriverFactory;
import com.pages.Contracts;
import com.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCreateVerifyDealSteps {
	
	private Contracts contractspage =  new Contracts(DriverFactory.getDriver());
	private OfferRequest offerpage;
	private YourdataPage datapage;
	private RecommendedPlan planpage;
	private Registration registrationpage;
	private PersonalDetails detailspage;
	private ChooseOption optionpage;
	private BankDetails bankpage;
	private SummaryPage summarypage;
	private ContractOverview overviewpage;
	private VerifyContract appmanagerpage;
	
	@Given("the user is logged on the staging environment of the Clark")
	public void the_user_is_logged_on_the_staging_environment_of_the_clark() {
	    contractspage.goToBaseURL();
	}

	@When("the user is on the Contracts page of the application")
	public void the_user_is_on_the_contracts_page_of_the_application() throws InterruptedException {
	    Assert.assertTrue(contractspage.goToContractsURL());
	    
	}

	@Then("the following menu options should be available on the page")
	public void the_following_menu_options_should_be_available_on_the_page(io.cucumber.datatable.DataTable dataTable) {
	    List<String> menulist = dataTable.asList(String.class);	    
	    List<String> actualmenuoption= contractspage.get_topmenu_list();
	    Assert.assertTrue(menulist.containsAll(actualmenuoption));	    
	    
	    
	    
	}

	@When("the user click on the {string} option")
	public void the_user_click_on_the_option(String str_angebote) {
	    offerpage = contractspage.clickon_Angebote(str_angebote);
	    
	}

	@When("the user selects {string} insurance")
	public void the_user_selects_insurance(String str_privathaftpflicht) {
	    datapage = offerpage.selectInsurance(str_privathaftpflicht);
	    
	}

	@Then("the user should be able to verify following default data on Deine Angaben Page")
	public void the_user_should_be_able_to_verify_default_data_from_the_given_data_sheet(io.cucumber.datatable.DataTable credTable) {
		
		List<Map<String, String>> credList = credTable.asMaps();
		List<String> dataoptions = new ArrayList<String>();
		dataoptions.add(credList.get(0).get("Familienstatus"));
		dataoptions.add(credList.get(0).get("im öffentlichen Dienst beschäftigt"));
		dataoptions.add(credList.get(0).get("in Rente"));
		dataoptions.add(credList.get(0).get("Selbstbeteiligung"));
		
		Assert.assertTrue(datapage.verify_default_data(dataoptions));
		planpage= datapage.click_showtop();
	    
	}

	@When("the user selects recommended offer by clicking on {string} button")
	public void the_user_selects_recommended_offer_by_clicking_on_button(String str_complete) {
		registrationpage = planpage.clickComplete(str_complete);
	   
	}

	@When("the user register through email and password")
	public void the_user_register_through_the_email_and_password() {
		detailspage = registrationpage.register();
	    
	}

	@Then("the user should be able to fill personal information")
	public void the_user_should_be_able_to_fill_data(io.cucumber.datatable.DataTable regTable) {
		List<Map<String, String>> regList = regTable.asMaps();
		List<String> regdata = new ArrayList<String>();
		regdata.add(regList.get(0).get("Anrede"));
		regdata.add(regList.get(0).get("Vorname"));
		regdata.add(regList.get(0).get("Nachname"));
		regdata.add(regList.get(0).get("Geburtsdatum"));
		regdata.add(regList.get(0).get("Straße"));
		regdata.add(regList.get(0).get("Hausnr."));
		regdata.add(regList.get(0).get("PLZ"));
		regdata.add(regList.get(0).get("Ort"));
		regdata.add(regList.get(0).get("Telefonnummer"));
	    
		optionpage = detailspage.fillData(regdata);
	}

	@When("the user selects the following options for {string} and {string}")
	public void the_user_selects_the_following_options_for_nächster_werktag_and_nein(String startdate, String previous_damage) {
	    bankpage = optionpage.chooseOptions(startdate, previous_damage);
	    
	}

	@When("the user enters the {string}")
	public void the_user_enters_the_bank_account_number_from_the_given_data_sheet(String str_bank) {
		summarypage = bankpage.enterbankDetails(str_bank);
	    
	}

	@Then("the user should be able to view Summary Page which starts from the  following confirmation message")
	public void the_user_should_be_able_match_details_from_the_given_data_sheet(io.cucumber.datatable.DataTable dataTable) {
		List<String> str_message = dataTable.asList(String.class);	
		Assert.assertTrue(summarypage.verifySummary(str_message));
		overviewpage = summarypage.completeNow();
	   
	    
	}

	@When("the user choose to view contract overview by clicking on {string} button")
	public void the_user_choose_to_view_contract_overview_by_clicking_on_button(String button) {
		appmanagerpage =overviewpage.clickOnOverview(button);
	    
	}

	@Then("the user should be able to view the contract on the {string} page")
	public void the_user_should_be_able_to_view_the_contract_on_the_page(String url) {
	    Assert.assertTrue(appmanagerpage.verifyContract(url));
	   
	}

}
