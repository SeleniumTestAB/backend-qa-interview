package com.qa.interview.sollution.full.stack.sollution.backend.requests;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import java.lang.reflect.Type;

public abstract class AbstractRequest<R, M> {

    protected Response response;

    protected abstract Type getModel();

    public abstract R execute();

    public M getResponseAsObject() {
        assertResponseIsNotNull();
        return this.response.as(getModel());
    }

    private void assertResponseIsNotNull() {
        Assertions.assertThat(this.response).isNotNull();
    }
}
