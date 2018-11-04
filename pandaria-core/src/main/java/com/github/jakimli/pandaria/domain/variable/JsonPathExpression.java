package com.github.jakimli.pandaria.domain.variable;

import com.github.jakimli.pandaria.domain.VerificationContext;
import com.github.jakimli.pandaria.domain.variable.Variables.Expression;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.github.jakimli.pandaria.utils.JsonUtil.toJsonString;

public class JsonPathExpression implements Expression {

    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("@\\{([^}]*)}");

    private VerificationContext verifying;

    JsonPathExpression(VerificationContext verifying) {
        this.verifying = verifying;
    }

    @Override
    public String evaluate(String raw) {

        Matcher matcher = EXPRESSION_PATTERN.matcher(raw);

        String result = raw;
        while (matcher.find()) {
            String original = matcher.group(0);
            String group = matcher.group(1);
            result = result.replace(original, json(group));
        }
        return result;
    }

    private String json(String jsonPath) {
        try {
            return toJsonString(verifying.json(jsonPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
