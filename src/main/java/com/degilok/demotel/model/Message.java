package com.degilok.demotel.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "messages")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String message;
    LocalDate dateCreate;
    boolean isMessageRead;
    String resipient;

    @ManyToOne
    @JoinColumn(name = "login")
    User login;
}