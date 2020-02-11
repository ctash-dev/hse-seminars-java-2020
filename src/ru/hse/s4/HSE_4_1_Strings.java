package ru.hse.s4;

public class HSE_4_1_Strings {

    public static void main(String[] args) {
        String firstS = "string";
        String secondS = firstS.toUpperCase();
        System.out.println(firstS.charAt(0));
        System.out.println(secondS.charAt(0));

        char[] chars = firstS.toCharArray();
        chars[0] = 'S';

        System.out.println(firstS.charAt(0));
        System.out.println(chars[0]);

        var doubleS = firstS + firstS;
        System.out.println(doubleS);

        var concatenation = new StringBuilder();
        //how many ops?
        for (int i = 0; i < 100; i++) {
            concatenation.append(firstS);
        }
        System.out.println(concatenation);
    }


}
