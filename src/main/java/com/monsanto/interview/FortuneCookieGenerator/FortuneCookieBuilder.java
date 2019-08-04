package com.monsanto.interview.FortuneCookieGenerator;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



/**
* Once we use a @Component, Spring Boot by default does not instance it each time its used, so the same object is shared.
* To solve this problem, I remove the validation of NOT_DEFINED, assuring that when a method is used, a property will be settled.
* For this test, I let this old code commented
*
*/
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FortuneCookieBuilder {

    private static final String NOT_DEFINED = "N/A";

    private String client = NOT_DEFINED;
    private String company = NOT_DEFINED;
    private String quote = NOT_DEFINED;
    FortuneCookieBuilder withClient(String client) {
    	
//        if (this.client.equals(NOT_DEFINED))
            this.client = client;
        return this;
    }

    FortuneCookieBuilder withCompany(String company) {
//        if (this.company.equals(NOT_DEFINED))
            this.company = company;
        return this;
    }

    FortuneCookieBuilder withQuote(String quote) {
            this.quote = quote;
        return this;
    }

    FortuneCookie build() {
        return new FortuneCookie("Hi "+client+"! Thanks for buying at "+company+" :) And remember: "+quote);
    }

}
