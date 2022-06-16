package com.qa.interview.sollution.full.stack.sollution.custom.scope;

import com.codeborne.selenide.SelenideDriver;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

public class DriverScope extends SimpleThreadScope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object o = super.get(name, objectFactory);
        if(Objects.isNull(((SelenideDriver) o).driver().getSessionId()) || !((SelenideDriver)o).hasWebDriverStarted()){
            super.remove(name);
            o = super.get(name, objectFactory);
        }
        return o;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }
}
