package com.qa.interview.sollution.full.stack.sollution.backend.requests;

import com.qa.interview.sollution.full.stack.sollution.backend.model.ErrorModel;
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

    public ErrorModel getError() {
        return response.as(ErrorModel.class);
    }

    private void assertResponseIsNotNull() {
        Assertions.assertThat(this.response).isNotNull();
    }
}
