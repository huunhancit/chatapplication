package com.tma.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dhnhan on 7/2/15.
 */
@Entity
@Table(name = "message")
public class Message implements Serializable {

    private long id;

    private String content;

    private Date date;

    private Group group;

    public Message() {
    }

    public Message(String content, Date date) {
        this.content = content;
        this.date = date;
    }
    @Id
    @GeneratedValue
    @Column(name = "message_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
