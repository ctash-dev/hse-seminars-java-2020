package ru.hse.s6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HSE_6_1_ParseFile {

/*
2011-12-03T10:15:30Z
2011-12-03T10:15:30Z
2011-12-03T10:15:30Z
*  */


    public static void main(String[] args) throws IOException {
        File myStrings = new File("myStrings");
        Duration diffDuration = getDurationBetweenMinAndMax(myStrings);
        System.out.println(diffDuration);
    }

    private static Duration getDurationBetweenMinAndMax(File myStrings) throws IOException {
        // use try with resources
        try (Stream<String> lineStream = Files.lines(myStrings.toPath())) {

            final List<Instant> instants = lineStream.map(line -> getInstantFromString(line))
                    .collect(Collectors.toList());
        }
    }

    private static Instant getInstantFromString(String string) {
        // todo
        return null;
    }


}
