package com.SECEProject.ELearningSystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trainers")

public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tr_id;

    @Column(nullable = false, length = 50)
    private String tr_name;

    @Column(unique = true, nullable = false, length = 100)
    private String tr_email;

    @Column(nullable = false, length = 20)
    private String tr_phone;

    @Column(nullable = false, length = 10)
    private String tr_password;

    @Column(nullable = false, length = 50)
    private String tr_institution;

    @Column(nullable = false, length = 50)
    private String tr_specialization;

    public Trainer() {}

    public Trainer(Integer tr_id, String tr_name, String tr_email, String tr_phone, String tr_password, String tr_institution, String tr_specialization) {
        this.tr_id = tr_id;
        this.tr_name = tr_name;
        this.tr_email = tr_email;
        this.tr_phone = tr_phone;
        this.tr_password = tr_password;
        this.tr_institution = tr_institution;
        this.tr_specialization = tr_specialization;
    }

    public Integer getTr_id() {
        return tr_id;
    }

    public void setTr_id(Integer tr_id) {
        this.tr_id = tr_id;
    }

    public String getTr_name() {
        return tr_name;
    }

    public void setTr_name(String tr_name) {
        this.tr_name = tr_name;
    }

    public String getTr_email() {
        return tr_email;
    }

    public void setTr_email(String tr_email) {
        this.tr_email = tr_email;
    }

    public String getTr_phone() {
        return tr_phone;
    }

    public void setTr_phone(String tr_phone) {
        this.tr_phone = tr_phone;
    }

    public String getTr_institution() {
        return tr_institution;
    }

    public void setTr_institution(String tr_institution) {
        this.tr_institution = tr_institution;
    }

    public String getTr_password() {
        return tr_password;
    }

    public void setTr_password(String tr_password) {
        this.tr_password = tr_password;
    }

    public String getTr_specialization() {
        return tr_specialization;
    }

    public void setTr_specialization(String tr_specialization) {
        this.tr_specialization = tr_specialization;
    }
}