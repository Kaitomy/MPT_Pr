package com.example.Proj.Models;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "feedback_tovar")
public class Feedback {
    @Id
    //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long FeedbackID;
    @Size(min = 2 , max = 500, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String feedbackdesc;
    private Date feedbackdate;
    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Tovar tovar;


    public Long getFeedbackID() {
        return FeedbackID;
    }

    public void setFeedbackID(Long FeedbackID) {
        this.FeedbackID = FeedbackID;
    }

    public String getFeedbackdesc() {
        return feedbackdesc;
    }

    public void setFeedbackdesc(String feedbackdesc) {
        this.feedbackdesc = feedbackdesc;
    }

    public Date getFeedbackdate() {
        return feedbackdate;
    }

    public void setFeedbackdate(Date feedbackdate) {
        this.feedbackdate = feedbackdate;
    }

    public Feedback(String feedbackdesc,Date feedbackdate, Tovar tovar) {
        this.feedbackdesc = feedbackdesc;
        this.feedbackdate = feedbackdate;
        this.tovar = tovar;
    }

    public Feedback() {
    }

    public Tovar getTovar() {
        return tovar;
    }

    public void setTovar(Tovar tovar) {
        this.tovar = tovar;
    }
}
