package com.qa.interview.sollution.full.stack.sollution.custom.annotations.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.*;

@Lazy
@Autowired
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LazilyWired {
}
