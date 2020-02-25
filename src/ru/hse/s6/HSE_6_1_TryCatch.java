package ru.hse.s6;

import java.io.IOException;

public class HSE_6_1_TryCatch {

    public static void main(String[] args) throws IOException {
        try {
            throwChecked();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            throwChecked();
        } catch (IOException e) {
            throw e;
        }

        handleExceptionInside();
    }

    private static void handleExceptionInside() {
        try {
            throwChecked();
        } catch (IOException e) {
            // rethrow as MyNonCheckedException
        }
    }

    private static final class MyNonCheckedException extends Exception {}

    private static void throwChecked() throws IOException {

    }

}
