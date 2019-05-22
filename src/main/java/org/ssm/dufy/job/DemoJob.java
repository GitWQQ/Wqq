package org.ssm.dufy.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class DemoJob extends QuartzJobBean{

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date())+"Êä³ö×Ô"+this.getClass().getName());
	}

}
