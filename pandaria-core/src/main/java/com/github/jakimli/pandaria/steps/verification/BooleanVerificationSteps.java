package com.github.jakimli.pandaria.steps.verification;

import com.github.jakimli.pandaria.domain.VerificationContext;
import com.github.jakimli.pandaria.domain.variable.Variables;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BooleanVerificationSteps {

    @Autowired
    VerificationContext actual;

    @Autowired
    Variables variables;

    @Then("^verify: '([^\"]*)'=(true|false)$")
    public void verifyEqualsBoolean(String path, String expected) throws IOException {
        assertThat(actual.json(path), is(Boolean.valueOf(expected)));
    }

    @Then("^verify: \\$\\{([^\"]*)}=(true|false)$")
    public void verifyVariableEqualsBoolean(String expression, String expected) {
        assertThat(variables.get(expression), is(Boolean.valueOf(expected)));
    }
}
