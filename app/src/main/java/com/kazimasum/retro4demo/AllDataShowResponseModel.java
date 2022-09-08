package com.kazimasum.retro4demo;

public class AllDataShowResponseModel {

    int ticket_id,student_id,service_id;
    String title,description,raised_on,status,document,service_name,role_id;

    public AllDataShowResponseModel(int ticket_id, int student_id, int service_id, String title, String description, String raised_on,
                                    String status, String document, String service_name, String role_id) {
        this.ticket_id = ticket_id;
        this.student_id = student_id;
        this.service_id = service_id;
        this.title = title;
        this.description = description;
        this.raised_on = raised_on;
        this.status = status;
        this.document = document;
        this.service_name = service_name;
        this.role_id = role_id;
    }



    public AllDataShowResponseModel() {

    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRaised_on() {
        return raised_on;
    }

    public void setRaised_on(String raised_on) {
        this.raised_on = raised_on;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

}
