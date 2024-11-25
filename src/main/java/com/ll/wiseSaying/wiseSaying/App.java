package com.ll.wiseSaying.wiseSaying;

import com.ll.wiseSaying.wiseSaying.controller.WiseSayingController;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class App {

    private static final String EXIT = "종료";
    private static final String INSERT = "등록";
    private static final String LIST = "목록";
    private static final String DELETE = "삭제";
    private static final String MODIFY = "수정";
    private static final String Build = "빌드";

    private static Scanner sc;
    private static WiseSayingController wiseSayingController;

    public App() {
        this.sc = new Scanner(System.in);
        this.wiseSayingController = new WiseSayingController(sc);
    }

    public App(Scanner sc) {
        this.sc = sc;
        this.wiseSayingController = new WiseSayingController(sc);
    }

    public void run() throws IOException, ParseException {
        System.out.println("== 명언 앱 ==");

        String command = "";

        wiseSayingController.init();

        while (!command.equals(EXIT)) {

            System.out.print("명령) ");
            command = sc.nextLine();

            if (command.length() > 1) {
                switch (command.substring(0, 2)) {
                    case INSERT -> {
                        wiseSayingController.insert();
                    }
                    case LIST -> {
                        wiseSayingController.selectList(command);
                    }
                    case DELETE -> {
                        wiseSayingController.delete(command);
                    }
                    case MODIFY -> {
                        wiseSayingController.modify(command);
                    }
                    case Build -> {
                        wiseSayingController.build();
                    }
                }
            }
        }
        sc.close();

        wiseSayingController.end();
    }
}
