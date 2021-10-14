package ru.netology.domain;

public class Smartphone extends Product {
    private String producer;

    public Smartphone(String name, String producer){
        super(name);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
