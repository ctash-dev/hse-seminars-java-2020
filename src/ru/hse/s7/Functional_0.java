package ru.hse.s7;

import java.io.IOException;
import java.util.function.BiFunction;

/**
 * @author Artem Bulanov <aite@yandex-team.ru>
 * Created at 15/03/2020
 */
public class Functional_0 {

    @FunctionalInterface
    public interface CellFunction {
        String apply(Integer row, Integer column, Integer width);
    }


    /**
     * написать функцию которая выводит таблицу умножения
     */
    public static void multiplicationTable() throws IOException {
        CellFunction multiplyF = (row, column, width) -> {
            String numberAsString = String.valueOf(row * column);
            int spacesCount = width - numberAsString.length();
            return " ".repeat(Math.max(spacesCount, 0)) + numberAsString;
        };
        printTable(100, 3, multiplyF);
    }

    /**
     * написать функцию которая выводит таблицу степеней
     */
    public static void powerTable() throws IOException {
        CellFunction powerF = (row, column, width) -> String.format("%10.0f", Math.pow(row, column));
        printTable(10, 10, powerF);
    }

    /**
     * написать функцию которая рисует круг
     * x^2 + y^2 = 10
     */
    public static void circleInTable() throws IOException {
        CellFunction drawCirlceCellF = (row, column, width) -> {
            if (
                    (row - 4)*(row - 4) + (column - 4)*(column - 4) <= 9
            ) {
                return "0";
            } else {
                return "-";
            }
        };
        printTable(10, 1, drawCirlceCellF);
    }

    private static void printTable(int dimension, int width,
            CellFunction cellFunction) {
        System.out.print(" ".repeat(width) + "|");
        for (int column = 1; column < dimension; column++) {
            System.out.printf("%" + width + "d|", column);
        }
        System.out.println();
        for (int row = 1; row < dimension; row++) {
            System.out.printf("%" + width + "d|", row);
            for (int column = 1; column < dimension; column++) {
                System.out.printf("%s|", cellFunction.apply(row, column, width));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        multiplicationTable();
        powerTable();
        circleInTable();
    }

}
