package ru.hse.s7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Artem Bulanov <aite@yandex-team.ru>
 * Created at 15/03/2020
 */
public class Functional_1 {

    private static Set<String> NAMES = Set.of("паша", "машу");

    /**
     * написать функцию которая обрабатывает каждое слово в строчке данной функцией
     */
    public static String processWords(String input, Function<String, String> wordProcessor) {
        String[] words = input.split(" ");
        return Arrays.stream(words)
                .map(wordProcessor)
                .collect(Collectors.joining(" "));
    }


    /**
     * функция должна делать имена людей с большой буквы
     */
    public static String processNames(String input) {
        Function<String, String> toUpperForNamesF = word -> {
            if (NAMES.contains(word)) {
                return Character.toUpperCase(word.charAt(0)) + (word.length() > 1 ? word.substring(1) : "");
            }
            return word;
        };
        return processWords(input, toUpperForNamesF);
    }

    /**
     * функция должна делать имена людей с большой буквы
     */
    public static void processNamesInFiles(String inputName, String outputName) throws IOException {
        Charset utf8 = StandardCharsets.UTF_8;
        String result;
        try (
                FileInputStream fis = new FileInputStream(inputName);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis, utf8)))
        {
            char[] charArray = new char[10000];
            int length = bufferedReader.read(charArray);
            String sentence = String.valueOf(charArray, 0, length);
            result = processNames(sentence);
        }

        try (
                FileOutputStream fos = new FileOutputStream(outputName);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, utf8))
        {
            outputStreamWriter.write(result);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(
                processWords("А роза упала на лапу азора",
                        word -> new StringBuilder(word).reverse().toString()));
        System.out.println(processNames("паша знает машу"));
        processNamesInFiles("/Users/ctash/git/gh/hse_java11/hse-seminars-java-2020/input",
                "/Users/ctash/git/gh/hse_java11/hse-seminars-java-2020/output");
    }

}
