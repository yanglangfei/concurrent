package com.yf.concurrent.controller;
import com.yf.concurrent.mapper.TbTicketMapper;
import com.yf.concurrent.model.TbTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TicketController {

    @Autowired
    private TbTicketMapper tbTicketMapper;


    @RequestMapping("/ticket")
    public List<TbTicket> getTicketByNo(String no){
        Map<String, Object> param=new HashMap<>();
        param.put("no",no);
        List<TbTicket> tbTicketList = tbTicketMapper.findList(param);
        return tbTicketList;
    }

}
