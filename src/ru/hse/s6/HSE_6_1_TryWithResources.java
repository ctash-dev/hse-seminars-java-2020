package ru.hse.s6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HSE_6_1_TryWithResources {

    public static void main(String[] args) throws IOException {
        handleExceptionInside();
    }

    private static void handleExceptionInside() {
        File file = new File("/Users/ctash/java_hse/tmp");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // read from br;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
