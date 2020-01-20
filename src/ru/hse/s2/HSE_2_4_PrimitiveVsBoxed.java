package ru.hse.s2;

public class HSE_2_4_PrimitiveVsBoxed {
    public static void main(String[] args) {
        Integer integerFromNew1 = new Integer(128);
        Integer integerFromNew2 = new Integer(128);
        Integer integerFromLitteral = 128;
        Integer integerFromValueOf = Integer.valueOf(128);

        System.out.println(integerFromNew1 == integerFromNew2);
        System.out.println(integerFromNew2 == integerFromLitteral);
        System.out.println(integerFromLitteral == integerFromValueOf);

        System.out.println(integerFromNew1 == 128);
        System.out.println(integerFromNew1 == integerFromLitteral);
        System.out.println(integerFromLitteral == 128);
    }
}
