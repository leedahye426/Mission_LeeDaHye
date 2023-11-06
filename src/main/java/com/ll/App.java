package com.ll;

import java.util.Scanner;

public class App {
    public App() {

    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        System.out.print("명령) ");
        String cmd = scanner.nextLine();
        if(cmd.equals("종료")) {
            return;
        }
    }
}
