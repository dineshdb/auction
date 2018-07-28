package com.sankalpa.auction;

import com.sankalpa.auction.Util.FileStorageProperties;
import com.sankalpa.auction.service.AuctionService;
import com.sankalpa.auction.service.ScheduledAcutionsService;
import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.util.Pair;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class AuctionApplication{

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args){
		SpringApplication.run(AuctionApplication.class, args);
	}

}
