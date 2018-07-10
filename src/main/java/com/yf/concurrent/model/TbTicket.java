package com.yf.concurrent.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbTicket implements Serializable {
    private Long id;
    private String no;
    private String fromAddress;
    private String toAddress;
    private Date startTime;
    private Date arriveTime;
}
