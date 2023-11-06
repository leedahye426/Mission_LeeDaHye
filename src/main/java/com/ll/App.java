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

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                return;
            } else if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제")) {
                actionRemove(cmd);
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

        for (Quotation quotation : quotations) {
            System.out.printf("%d / %s / %s\n", quotation.getId(), quotation.getAuthor(), quotation.getContent());
        }
    }

    private void actionRemove(String cmd) {
        int id = getparamValue(cmd, "id", 0);
        if(id == 0) {
            System.out.println("id를 정확하게 입력해주세요");
            return;
        }
        int index = findIndexById(id);
        if(index != -1) {
            quotations.remove(index);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
        } else {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
        }
    }

    private int findIndexById(int id) {
        int index = 0;
        for(Quotation quotation : quotations) {
            if(quotation.getId() == id) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }

    private int getparamValue(String cmd, String paramName, int defaultValue) {
        String[] cmdBits= cmd.split("\\?", 2);

        if(cmdBits.length == 1) return defaultValue;

        String action = cmdBits[0];
        String queryStrings = cmdBits[1];

        String[] queryStringBits = queryStrings.split("&");
        for(String queryStringBit : queryStringBits) {
            String[] queryString = queryStringBit.split("=", 2);
            if(queryString.length == 1) return defaultValue;
            String param = queryString[0];
            String value = queryString[1];

            try {
                if(param.equals(paramName)) {
                    return Integer.parseInt(value);
                }
            } catch (Exception e) {
                return defaultValue;
            }

        }
        return defaultValue;
    }
}
