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

    }

    private static void throwChecked() throws IOException {

    }

}
