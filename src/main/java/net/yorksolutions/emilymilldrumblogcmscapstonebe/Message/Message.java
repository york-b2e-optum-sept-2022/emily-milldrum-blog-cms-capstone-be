package net.yorksolutions.emilymilldrumblogcmscapstonebe.Message;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
}
