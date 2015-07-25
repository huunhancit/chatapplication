package com.tma.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dhnhan on 7/2/15.
 */
@Entity
@Table(name ="groups")
public class Group implements Serializable {

    private long id;
    private String namegroup;
    private Set<Message>  messages = new HashSet<Message>(0);
    public Group() {
    }
    public Group(String namegroup) {
        this.namegroup = namegroup;
    }
    public void addMessage(Message message){
        this.messages.add(message);
        message.setGroup(this);
    }
    public String getNamegroup() {
        return namegroup;
    }
    public void setNamegroup(String namegroup) {
        this.namegroup = namegroup;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<Message> getMessages() {
        return messages;
    }
    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
