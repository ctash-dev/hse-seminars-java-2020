package ru.hse.s7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * @author Artem Bulanov <aite@yandex-team.ru>
 * Created at 15/03/2020
 */
public class Functional_2 {

    /**
     * buffered reader, который обрабатывает каждую строчку вывода из google.com
     * обработка вынесена в функцию, которая возвращает Optional<Integer>, чтоб поупражняться с Optional.
     * надо просуммировать все
     * int числа из вывода гугла если они там есть, и Optional.empty() если нет ни одного выделяемого числа.
     */
    public static void main(String[] args) throws IOException {
        Function<String, Optional<Integer>> intSumF = (line) -> {
            Optional<Integer> localSum = Optional.empty();
            if (line.length() == 0) {
                return Optional.empty();
            }
            try (Scanner sc = new Scanner(line)) {
                while (sc.hasNext()) {
                    String next = sc.next();
                    try {
                        int nextInt = Integer.parseInt(next);
                        if (localSum.isEmpty()) {
                            localSum = Optional.of(nextInt);
                        } else {
                            localSum = Optional.of(localSum.get() + nextInt);
                        }
                    } catch (NumberFormatException e) {
                        continue;
                    }
                }
            }
            return localSum;
        };
        Optional<Integer> sum = Optional.empty();
        try (InputStream inputStream = new URL("https://mail.ru").openStream();
             BufferedReader bufferedReader = new BufferedReader(
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            char[] charBuffer = new char[10000];
            int length = bufferedReader.read(charBuffer);
            String line = String.valueOf(charBuffer, 0, length);
            Optional<Integer> localSum = intSumF.apply(line);
            if (sum.isEmpty()) {
                sum = localSum;
            } else {
                sum = Optional.of(sum.get() + localSum.get());
            }
        }
        System.out.println(sum);
    }

}
