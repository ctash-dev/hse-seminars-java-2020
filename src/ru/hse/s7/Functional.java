package ru.hse.s7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Artem Bulanov <aite@yandex-team.ru>
 * Created at 15/03/2020
 */
public class Functional {

    /**
     *
     */
    public static void task0() throws IOException {
        BiFunction<Integer, Integer, String> productFunction =
                (row, column) -> String.format("%4d", row * column);
        BiFunction<Integer, Integer, String> exponentFunction =
                (row, column) -> String.format("%4.0f", Math.pow(row, column));
        TableFunction circleFunction = (row, column, width) -> {
            if (
                    ((row - 5) * (row - 5) + (column - 5) * (column - 5)) <= 16
                            &&
                            ((row - 5) * (row - 5) + (column - 5) * (column - 5)) >= 9
            )
            {
                return "0".repeat(width);
            } else {
                return " ".repeat(width);
            }
        };
        BiFunction<Integer, Integer, String> circleWidth1 = (a, b) -> circleFunction.makeCell(a, b, 1);
        BiFunction<Integer, Integer, String> function = circleWidth1;
        final int DIMENSION = 10;
        final int WIDTH = 1;
        System.out.print(" ".repeat(WIDTH) + "|");
        for (int column = 1; column < DIMENSION; column++) {
            System.out.printf("%" + WIDTH + "d|", column);
        }
        System.out.println();
        for (int row = 1; row < DIMENSION; row++) {
            System.out.printf("%" + WIDTH + "d|", row);
            for (int column = 1; column < DIMENSION; column++) {
                System.out.printf("%s|", function.apply(row, column));
            }
            System.out.println();
        }
    }

    public static void task1() {
        List<String> names = List.of("паша", "паши", "маша", "саша");
        Function<String, String> nameToUpperCase = (s) -> {
            String asLower = s.toLowerCase();
            if (asLower.equals(s) && names.contains(asLower)) {
                return s.substring(0, 1).toUpperCase() + s.substring(1);
            } else {
                return s;
            }
        };
        String result = processWords("маша друг паши", nameToUpperCase);
        System.out.println(result);
    }

    public static Function<String, String> capitalizeNames() {
        return input -> {
            List<String> names = List.of("паша", "паши", "маша", "саша");
            Function<String, String> nameToUpperCase = (s) -> {
                String asLower = s.toLowerCase();
                if (asLower.equals(s) && names.contains(asLower)) {
                    return s.substring(0, 1).toUpperCase() + s.substring(1);
                } else {
                    return s;
                }
            };
            return processWords(input, nameToUpperCase);
        };
    }

    public static String processWords(String input, Function<String, String> wordProcessor) {
        StringBuilder sb = new StringBuilder();
        for (String s : input.split(" ")) {
            sb.append(wordProcessor.apply(s));
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void task2() {
        String inputFilePath = "/Users/aite/hse_seminars_4c/sems-prepare/in.txt";
        String outFilePath = "/Users/aite/hse_seminars_4c/sems-prepare/out.txt";
        Charset utf8 = StandardCharsets.UTF_8;
        try (
                InputStreamReader isr = new InputStreamReader(new FileInputStream(inputFilePath), utf8);
                Reader reader = new BufferedReader(isr);
                Writer writer = new OutputStreamWriter(new FileOutputStream(outFilePath), utf8))
        {
            char[] symbols = new char[10000];
            int readChars = reader.read(symbols);
            String asString = String.valueOf(symbols, 0, readChars);
            String resultAsString = capitalizeNames().apply(asString);
            writer.write(resultAsString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void task3() throws IOException {
        Function<String, Optional<Integer>> getInt = (String s) -> {
            for (String part : s.split(" ")) {
                try {
                    int i = Integer.parseInt(part);
                    System.out.println("Parsed " + i);
                    return Optional.of(i);
                } catch (NumberFormatException nfe) {
                    System.err.println(nfe.getMessage());
                }
            }
            return Optional.empty();
        };
        Optional<Integer> totalValue = Optional.empty();
        try (
                InputStream is = new URL("https://www.google.com").openStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is)))
        {
            String line = reader.readLine();
            while (line != null) {
                Optional<Integer> foundValue = getInt.apply(line);
                if (totalValue.isEmpty()) {
                    totalValue = foundValue;
                } else if (foundValue.isPresent()) {
                    totalValue = totalValue.map(i -> i + foundValue.get());
                }
                line = reader.readLine();
            }
        }
        totalValue.ifPresentOrElse(
                s -> System.out.println("Sum of found values " + s),
                () -> System.out.println("No value found"));
    }

    public static void main(String[] args) throws IOException {
        task0();
        task1();
        task2();
        task3();
    }

    @FunctionalInterface
    interface TableFunction {
        String makeCell(int row, int column, int width);
    }
}
