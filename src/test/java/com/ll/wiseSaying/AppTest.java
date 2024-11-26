package com.ll.wiseSaying;

import com.ll.wiseSaying.standard.util.TestUtil;
import com.ll.wiseSaying.wiseSaying.App;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    static TestUtil tu = new TestUtil();
    static ByteArrayOutputStream outputStream;
    @Test
    @DisplayName("앱 시작")
    public void t1() throws IOException, ParseException {
        String out = run("종료");

        assertThat(out)
                .contains("== 명언 앱 ==");
    }

    public static void clear() {
        tu.clearSetOutToByteArray(outputStream);
    }

    public static String run(String s) throws IOException, ParseException {
        Scanner scanner = tu.genScanner(s+"\n종료");

        outputStream = tu.setOutToByteArray();
        App app = new App(scanner);
        app.run();

        return outputStream.toString();
    }
}

