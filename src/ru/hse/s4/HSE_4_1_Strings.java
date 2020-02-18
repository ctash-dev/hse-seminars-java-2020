package ru.hse.s4;

public class HSE_4_1_Strings {

    public static void main(String[] args) {
        var value = "stringValue";
        var upperCase = value.toUpperCase();


        var myValue = new MyString(value);
        var myOtherValue = new MyString(value);
        System.out.println(myValue.equals(myOtherValue));

        System.out.println(myValue.toString().equals(value));
        System.out.println(myOtherValue.toString().equals(value));

        System.out.println(myValue.toUpperCase().equals(myOtherValue.toUpperCase()));
        System.out.println(myValue
                .toUpperCase().toString().equals(upperCase));
    }

    public static final class MyString {
        private final char[] chars;

        public MyString(String string) {
            this.chars = string.toCharArray();
        }

        public MyString toUpperCase() {
            return new MyString("test");
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }

        @Override
        public String toString() {
            return "";
        }
    }

}
