package com.example.Proj.Models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "order_all")
public class Order {
    @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long OrderID;
    private Date orderdate;
    @NotEmpty
    @Size(min = 4 , max = 50, message = "Ошибка в длине")
    private String  orderaddress;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Collection<Feedback> feedback;
    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Tovar tovar;
    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private TypePay typepay;
    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Additional additional;
    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private User user;
    public Order(Date orderdate, String orderaddress) {
        this.orderdate = orderdate;
        this.orderaddress = orderaddress;
    }





    public Order() {

    }


    public Long getOrderID() {
        return OrderID;
    }

    public void setOrderID(Long OrderID) {
        this.OrderID = OrderID;
    }

    public String getOrderaddress() {
        return orderaddress;
    }

    public void setOrderaddress(String orderaddress) {
        this.orderaddress = orderaddress;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
    public Order(Date orderdate,String orderaddress, Tovar tovar,TypePay typepay,Additional additional,User user) {
        this.orderdate = orderdate;
        this.orderaddress = orderaddress;
        this.tovar = tovar;
        this.typepay = typepay;
        this.additional = additional;
        this.user = user;
    }

    public Collection<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(Collection<Feedback> feedback) {
        this.feedback = feedback;
    }


}