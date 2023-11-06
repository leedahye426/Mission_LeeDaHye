package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private int lastQuotationId;
    private ArrayList<Quotation> quotations;
    public App() {
        scanner = new Scanner(System.in);
        lastQuotationId = 0;
        quotations = new ArrayList<>();
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
            else if(cmd.equals("목록")) {
                actionList();
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

        quotations.add(quotation);

        System.out.printf("%d번 명언이 등록되었습니다.\n", quotation.getId());
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");
        for(Quotation quotation : quotations) {
            System.out.printf("%d / %s / %s\n", quotation.getId(), quotation.getAuthor(), quotation.getContent());
        }
    }
}
