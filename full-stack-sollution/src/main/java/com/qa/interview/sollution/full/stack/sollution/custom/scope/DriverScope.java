package com.qa.interview.sollution.full.stack.sollution.custom.scope;

import com.codeborne.selenide.SelenideDriver;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

public class DriverScope extends SimpleThreadScope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object o = super.get(name, objectFactory);

        ((SelenideDriver) o).getAndCheckWebDriver();
        return o;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }
}
