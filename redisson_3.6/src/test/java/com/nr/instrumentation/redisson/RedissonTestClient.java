package com.nr.instrumentation.redisson;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import com.newrelic.agent.introspec.InstrumentationTestConfig;
import com.newrelic.agent.introspec.InstrumentationTestRunner;
import com.newrelic.api.agent.Trace;

@RunWith(InstrumentationTestRunner.class)
@InstrumentationTestConfig(includePrefixes = { "org.redisson" })
public class RedissonTestClient {

	static RedissonClient client = null;
	@BeforeClass
	public static void beforeClass() {
		client = Redisson.create();
	}
	
	@AfterClass
	public static void afterClass() {
	}
	
	@Test
	public void test() {
		testBucket();
	}
	
	@Trace(dispatcher=true)
	public void testBucket() {
		RBucket<String> bucket = client.getBucket("test");
		bucket.set("123");
		boolean isUpdated = bucket.compareAndSet("123", "4948");
		assertTrue("compareAndSet Failed",isUpdated);
		
	}

}
