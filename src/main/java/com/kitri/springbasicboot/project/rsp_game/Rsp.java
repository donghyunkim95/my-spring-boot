package com.kitri.springbasicboot.project.rsp_game;

public class Rsp {

    String rock;
    String sissor;
    String paper;

    public Rsp(String rock, String sissor, String paper) {
        this.rock = rock;
        this.sissor = sissor;
        this.paper = paper;
    }

    public String getRock() {
        return rock;
    }

    public void setRock(String rock) {
        this.rock = rock;
    }

    public String getSissor() {
        return sissor;
    }

    public void setSissor(String sissor) {
        this.sissor = sissor;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }
}
