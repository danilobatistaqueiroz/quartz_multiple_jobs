package com.labs.javaScheduler;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SchedulerException
    {
    	JobDetail coffeeJob = JobBuilder.newJob(CoffeeSoundJob.class).withIdentity("coffeeJob", "group1").build();
    	JobDetail soundJob = JobBuilder.newJob(PlaySoundJob.class).withIdentity("soundJob", "group1").build();
    	JobDetail trackJob = JobBuilder.newJob(RecorderJob.class).withIdentity("trackJob", "group2").build();
    	
		Trigger trigger1 = TriggerBuilder
				.newTrigger()
				.withIdentity("CoffeeTimeSound", "group1")
				.withSchedule(
					SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(60*45).repeatForever())
				.build(); //a cada 45 minutos
		
		Trigger trigger2 = TriggerBuilder
				.newTrigger()
				.withIdentity("PlaySound", "group1")
				.withSchedule(
					SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(900).repeatForever())
				.build(); //a cada 15 minutos
		
		Trigger trigger3 = TriggerBuilder
				.newTrigger()
				.withIdentity("Tracker", "group2")
				.withSchedule(
					SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(60).repeatForever())
				.build(); //a cada 1 minuto
		
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(coffeeJob, trigger1);
		scheduler.scheduleJob(soundJob, trigger2);
		scheduler.scheduleJob(trackJob, trigger3);
    }
}
