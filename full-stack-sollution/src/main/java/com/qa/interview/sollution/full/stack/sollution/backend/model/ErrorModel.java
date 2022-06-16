package com.qa.interview.sollution.full.stack.sollution.backend.model;

public record ErrorModel(String timestamp, int status, String error, String path) {
}
