package com.ll;

import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private int lastQuotationId;
    public App() {
        scanner = new Scanner(System.in);
        lastQuotationId = 0;
    }
    public void run() {
        System.out.println("== 명언 앱 ==");

        while(true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if(cmd.equals("종료")) {
                return;
            }
            else if(cmd.equals("등록")) {
                actionWrite();
            }
        }

    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        lastQuotationId++;
        int id = lastQuotationId;
        Quotation quotation = new Quotation(id, content, author);

        System.out.printf("%d번 명언이 등록되었습니다.\n", quotation.getId());
    }
}
