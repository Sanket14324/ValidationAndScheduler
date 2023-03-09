package com.customer.springboot.scheduler;

import com.customer.springboot.model.Customer;
import com.customer.springboot.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.InterruptedIOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Slf4j
@EnableScheduling
//@EnableAsync

public class Scheduler {
    @Autowired
    private CustomerRepository customerRepository;
//    @Scheduled(cron = "${cron.expression.value}") // sec min hrs dayOfMonth Month DayOfWeek
    // if after 2 min "0 */2 * * * *"
    //if on specific day "0 0 18 * * THR"
    // for string fixed rate fixedRateString = "PT02S"
//    @Async
//    public void scheduler() throws InterruptedException{
//        LocalDateTime current = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formattedDateTime = current.format(format);
//        log.info("Scheduler time -"+formattedDateTime);
//
//    }

    //  this method returns the list of employee on Scheduled time
    @Scheduled(cron = "${cron.expression.value}")
    public void printAllNames() throws InterruptedException{

       List<Customer> list =  customerRepository.findAll();
       for(Customer customer: list) {
           System.out.println(customer.getName());
       }

    }
}
