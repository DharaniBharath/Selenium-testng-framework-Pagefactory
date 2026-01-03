package com.allurereportsData;

import io.qameta.allure.Attachment;

public class AllureLog {
    @Attachment(value = "{message}", type = "text/plain")
    public static String log(String message) {
        return message;
    }
}
