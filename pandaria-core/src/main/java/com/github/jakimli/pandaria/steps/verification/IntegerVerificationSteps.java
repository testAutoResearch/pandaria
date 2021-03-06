package com.github.jakimli.pandaria.steps.verification;

import com.github.jakimli.pandaria.domain.VerificationContext;
import com.github.jakimli.pandaria.domain.variable.Variables;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class IntegerVerificationSteps {
    @Autowired
    Variables variables;

    @Autowired
    VerificationContext actual;

    @Then("^verify: '([^\"]*)'=(\\d+)$")
    public void verifyEqualsInteger(String path, final int expected) throws Throwable {
        assertThat(actual.json(path), is(expected));
    }

    @Then("^verify: '([^\"]*)'!=(\\d+)$")
    public void verifyNotEqualsInteger(String path, final int expected) throws Throwable {
        assertThat(actual.json(path), not(expected));
    }

    @Then("^verify: '([^\"]*)'>(\\d+)$")
    public void verifyGreaterThanInteger(String path, final int expected) throws Throwable {
        assertThat((int) actual.json(path), greaterThan(expected));
    }

    @Then("^verify: '([^\"]*)'>=(\\d+)$")
    public void verifyGreaterThanOrEqualToInteger(String path, final int expected) throws Throwable {
        assertThat((int) actual.json(path), greaterThanOrEqualTo(expected));
    }

    @Then("^verify: '([^\"]*)'<(\\d+)$")
    public void verifyLessThanInteger(String path, final int expected) throws Throwable {
        assertThat((int) actual.json(path), lessThan(expected));
    }

    @Then("^verify: '([^\"]*)'<=(\\d+)$")
    public void verifyLessThanOrEqualToInteger(String path, final int expected) throws Throwable {
        assertThat((int) actual.json(path), lessThanOrEqualTo(expected));
    }

    @Then("^verify: \\$\\{([^\"]*)}=(\\d+)$")
    public void verifyVariableEqualsInteger(String expression, Integer expected) {
        assertThat(variables.get(expression), is(expected));
    }

    @Then("^verify: \\$\\{([^\"]*)}!=(\\d+)$")
    public void verifyVariableNotEqualsInteger(String expression, Integer expected) {
        assertThat(variables.get(expression), not(expected));
    }

    @Then("^verify: \\$\\{([^\"]*)}>(\\d+)$")
    public void verifyVariableGreaterThanInteger(String expression, Integer expected) {
        assertThat((int) variables.get(expression), greaterThan(expected));
    }

    @Then("^verify: \\$\\{([^\"]*)}>=(\\d+)$")
    public void verifyVariableGreaterThanOrEqualToInteger(String expression, Integer expected) {
        assertThat((int) variables.get(expression), greaterThanOrEqualTo(expected));
    }

    @Then("^verify: \\$\\{([^\"]*)}<(\\d+)$")
    public void verifyVariableLessThanInteger(String expression, Integer expected) {
        assertThat((int) variables.get(expression), lessThan(expected));
    }

    @Then("^verify: \\$\\{([^\"]*)}<=(\\d+)$")
    public void verifyVariableLessThanOrEqualToInteger(String expression, Integer expected) {
        assertThat((int) variables.get(expression), lessThanOrEqualTo(expected));
    }
}
