package com.yf.concurrent.test;

import com.yf.concurrent.mapper.TbTicketMapper;
import com.yf.concurrent.model.TbTicket;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class TicketControllerTest {

    @Autowired
    private TbTicketMapper tbTicketMapper;

    private static final Integer MAX_THREND = 100;

    private CountDownLatch countDownLatch = new CountDownLatch(MAX_THREND);


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getStudentList() throws Exception {

        for (Integer i = 0; i < MAX_THREND; i++) {
            GetTicketThread getTicketThread = new GetTicketThread();
            getTicketThread.run();
            countDownLatch.countDown();
        }

    }


    class GetTicketThread implements Runnable {

        @Override
        public void run() {
            Map<String, Object> param = new HashMap<>();
            param.put("no", "G245");
            List<TbTicket> list = tbTicketMapper.findList(param);
            log.info("获取数据-----:[" + list + "]");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
