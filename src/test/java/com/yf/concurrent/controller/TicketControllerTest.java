package com.yf.concurrent.controller;

import com.yf.concurrent.mapper.TbTicketMapper;
import com.yf.concurrent.model.TbTicket;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@Slf4j
public class TicketControllerTest {

    @Autowired
    private TbTicketMapper ticketMapper;

    @Test
    public void getTicketByNo() {
        Map<String, Object> param=new HashMap<>();
        param.put("no","G245");
        List<TbTicket> list = ticketMapper.findList(param);
        log.info("list:["+list+"]");


    }
}