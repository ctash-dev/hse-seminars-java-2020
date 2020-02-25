package ru.hse.s6;

import java.io.IOException;

public class HSE_6_1_TryCatchFinally {

    public static void main(String[] args) throws IOException {
        handleExceptionInside();
    }

    private static void handleExceptionInside() {
        try {
            throwChecked();
            throwUnchecked();
        } catch (Exception e) {
            throw new MyNonCheckedException(e);
        } finally {
            // todo why do we need this?
        }
    }

    private static final class MyNonCheckedException extends RuntimeException {

        public MyNonCheckedException(Throwable cause) {
            super(cause);
        }
    }
    private static void throwChecked() throws IOException {

    }

    private static void throwUnchecked() {
        throw new NullPointerException();
    }

}
