package com.github.jakimli.pandaria.steps.verification;

import com.github.jakimli.pandaria.domain.VerificationContext;
import com.github.jakimli.pandaria.domain.variable.Variables;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.Double.parseDouble;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class DoubleVerificationSteps {

    @Autowired
    Variables variables;

    @Autowired
    VerificationContext actual;

    @Then("^verify: '([^\"]*)'=double: (\\d+\\.\\d+)$")
    public void verifyEqualsDouble(String path, String expected) throws Throwable {
        assertThat(actual.json(path), is(parseDouble(expected)));
    }

    @Then("^verify: '([^\"]*)'!=double: (\\d+\\.\\d+)$")
    public void verifyNotEqualsDouble(String path, String expected) throws Throwable {
        assertThat(actual.json(path), not(parseDouble(expected)));
    }

    @Then("^verify: '([^\"]*)'>double: (\\d+\\.\\d+)$")
    public void verifyGreaterThanDouble(String path, String expected) throws Throwable {
        assertThat((Double) actual.json(path), greaterThan(parseDouble(expected)));
    }

    @Then("^verify: '([^\"]*)'>=double: (\\d+\\.\\d+)$")
    public void verifyGreaterThanOrEqualToDouble(String path, String expected) throws Throwable {
        assertThat((Double) actual.json(path), greaterThanOrEqualTo(parseDouble(expected)));
    }

    @Then("^verify: '([^\"]*)'<double: (\\d+\\.\\d+)$")
    public void verifyLessThanDouble(String path, String expected) throws Throwable {
        assertThat((Double) actual.json(path), lessThan(parseDouble(expected)));
    }

    @Then("^verify: '([^\"]*)'<=double: (\\d+\\.\\d+)$")
    public void verifyLessThanOrEqualToDouble(String path, String expected) throws Throwable {
        assertThat((Double) actual.json(path), lessThanOrEqualTo(parseDouble(expected)));
    }

    @Then("^verify: \\$\\{([^\"]*)}=double: (\\d+\\.\\d+)$")
    public void verifyVariableEqualsDouble(String expression, String expected) {
        assertThat(variables.get(expression), is(Double.parseDouble(expected)));
    }

    @Then("^verify: \\$\\{([^\"]*)}!=double: (\\d+\\.\\d+)$")
    public void verifyVariableNotEqualsDouble(String expression, String expected) {
        assertThat(variables.get(expression), not(Double.parseDouble(expected)));
    }

    @Then("^verify: \\$\\{([^\"]*)}>double: (\\d+\\.\\d+)$")
    public void verifyVariableGreaterThanDouble(String expression, String expected) {
        assertThat((double) variables.get(expression), greaterThan(Double.parseDouble(expected)));
    }

    @Then("^verify: \\$\\{([^\"]*)}>=double: (\\d+\\.\\d+)$")
    public void verifyVariableGreaterThanOrEqualToDouble(String expression, String expected) {
        assertThat((double) variables.get(expression), greaterThanOrEqualTo(Double.parseDouble(expected)));
    }

    @Then("^verify: \\$\\{([^\"]*)}<double: (\\d+\\.\\d+)$")
    public void verifyVariableLessThanDouble(String expression, String expected) {
        assertThat((double) variables.get(expression), lessThan(Double.parseDouble(expected)));
    }

    @Then("^verify: \\$\\{([^\"]*)}<=double: (\\d+\\.\\d+)$")
    public void verifyVariableLessThanOrEqualToDouble(String expression, String expected) {
        assertThat((double) variables.get(expression), lessThanOrEqualTo(Double.parseDouble(expected)));
    }
}
