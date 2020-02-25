package ru.hse.s6;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HSE_6_1_ParseFile {

/*
2345
123213
312331231
1323123123123
dsadkjsadasldksjd
1jkhdjkad
*  */


    public static void main(String[] args) throws IOException {
        File myStrings = new File("myStrings");
        int stringCount = countStringWithLengthMoreThan5(myStrings);
        System.out.println(stringCount);
    }

    private static int countStringWithLengthMoreThan5(File myStrings) {
        // use try with resources
    }

}
