package ru.hse.s1;

public class Talkie {

    public static void main(String[] args) {
        String command;
        if (args.length > 0) {
            command = args[0];
        } else {
            System.err.println("error.");
            return;
        }
        if (command.equals("hello")) {
            System.out.println("hello");
        } else {
            System.err.println("error.");
            return;
        }
    }
}
