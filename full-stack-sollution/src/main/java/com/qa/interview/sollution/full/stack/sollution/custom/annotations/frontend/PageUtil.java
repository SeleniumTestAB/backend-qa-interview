package com.qa.interview.sollution.full.stack.sollution.custom.annotations.frontend;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Lazy
@Component
@Documented
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PageUtil {
}
