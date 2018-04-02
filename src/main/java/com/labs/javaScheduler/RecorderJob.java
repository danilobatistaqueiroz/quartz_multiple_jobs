package com.labs.javaScheduler;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecorderJob implements Job  {

	private Logger log = LoggerFactory.getLogger(PlaySoundJob.class);
	
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Date dt = new Date();
		log.info(dt.toString() + " - tracking");
	}

}
