package com.yf.concurrent.mapper;

import com.yf.concurrent.model.TbTicket;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TbTicketMapper {


    List<TbTicket>  findList(Map<String,Object> param);




}
