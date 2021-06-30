package org.redisson;

import org.redisson.client.codec.Codec;
import org.redisson.command.CommandAsyncExecutor;
import org.redisson.command.CommandAsyncService;

import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;

@Weave(type=MatchType.BaseClass)
public abstract class RedissonObject {
	
	public RedissonObject(Codec codec, CommandAsyncExecutor commandExecutor, String name) {
		if(commandExecutor instanceof CommandAsyncService) {
			CommandAsyncService cmdAsyncService = (CommandAsyncService)commandExecutor;
			String clazzname = getClass().getSimpleName().replace("Redisson", "");
			cmdAsyncService.objectType = clazzname;
		}
	}

}
