/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.integration.config.xml;

import static junit.framework.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.endpoint.SourcePollingChannelAdapter;

/**
 * @author Oleg Zhurakousky
 *
 */
public class PollerWithErrorChannel {

	@Test
	@Ignore
	public void testWithErrorChannelAsHeader() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("PollerWithErrorChannel-context.xml", this.getClass());
		SourcePollingChannelAdapter adapter = ac.getBean("withErrorHeader", SourcePollingChannelAdapter.class);
		adapter.start();
		PollableChannel errorChannel = ac.getBean("eChannel", PollableChannel.class);
		assertNotNull(errorChannel.receive(1000));
		adapter.stop();
	}
	
	@Test
	@Ignore
	public void testWithErrorChannel() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("PollerWithErrorChannel-context.xml", this.getClass());
		SourcePollingChannelAdapter adapter = ac.getBean("withErrorChannel", SourcePollingChannelAdapter.class);
		adapter.start();
		PollableChannel errorChannel = ac.getBean("eChannel", PollableChannel.class);
		assertNotNull(errorChannel.receive(1000));
		adapter.stop();
	}
	
	@Test
	@Ignore
	public void testWithErrorChannelAndHeader() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("PollerWithErrorChannel-context.xml", this.getClass());
		SourcePollingChannelAdapter adapter = ac.getBean("withErrorChannelAndHeader", SourcePollingChannelAdapter.class);
		adapter.start();
		PollableChannel errorChannel = ac.getBean("errChannel", PollableChannel.class);
		assertNotNull(errorChannel.receive(1000));
		adapter.stop();
	}
	
	public static class SampleService{
		public String withSuccess(){
			return "hello";
		}
	}
}
