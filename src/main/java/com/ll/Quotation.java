package com.ll;

import java.io.Serializable;

//직렬화 가능해야 객체를 파일에 쓸 수 있다. Serializable 인터페이스를 구현하여 직렬화 가능하게 만든다.
public class Quotation implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String content;
    private String author;

    public Quotation(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
