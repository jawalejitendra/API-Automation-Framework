package StepDefinitions;


import datacontexts.NumberData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WhenSteps {

    NumberData numberData;


    @When("I add these two numbers")
    public void iAddTheseTwoNumbers() {
//        result = num1 + num2;
        numberData.result =  numberData.num1 + numberData.num2;
    }
}
