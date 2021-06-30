package org.redisson.command;

import java.util.Collection;
import java.util.List;

import org.redisson.SlotCallback;
import org.redisson.api.RFuture;
import org.redisson.client.RedisClient;
import org.redisson.client.RedisException;
import org.redisson.client.codec.Codec;
import org.redisson.client.protocol.RedisCommand;
import org.redisson.connection.ConnectionManager;
import org.redisson.connection.MasterSlaveEntry;
import org.redisson.connection.NodeSource;
import org.redisson.misc.RedissonPromise;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.redisson.NRBiConsumer;

@Weave(type=MatchType.BaseClass)
public abstract class CommandAsyncService {

	@NewField
	public String objectType = null;
	
	public CommandAsyncService(ConnectionManager connectionManager) {
		
	}


	public <V> RedisException convertException(RFuture<V> RFuture) {
		RedisException e = Weaver.callOriginal();
		if(e != null) {
			NewRelic.noticeError(e);
		}
		return e;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> evalAllAsync(boolean readOnlyMode, RedisCommand<T> command, final SlotCallback<T, R> callback, String script, List<Object> keys, Object... params) {
		String cmdName = command.getName();
		if(cmdName == null || cmdName.isEmpty()) {
			cmdName = "UnknownCommandName";
		}
		String subName = command.getSubName();
		RFuture<R> result = Weaver.callOriginal();
		if(result instanceof RedissonPromise) {
			String collectionName = objectType != null ? objectType : "?";
			Segment segment = NewRelic.getAgent().getTransaction().startSegment(cmdName + "-" + collectionName);
			segment.addCustomAttribute("Command", cmdName);
			if(subName != null) {
				segment.addCustomAttribute("Sub", subName);
			}
			DatastoreParameters dsParams = DatastoreParameters.product("Redisson").collection(collectionName).operation(cmdName).build();
			NRBiConsumer<R> action = new NRBiConsumer<R>(segment, dsParams);
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			promise.onComplete(action);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	private <T, R> RFuture<R> evalAsync(NodeSource nodeSource, boolean readOnlyMode, Codec codec, RedisCommand<T> evalCommandType, String script, List<Object> keys, Object... params) {
		String cmdName = evalCommandType.getName();
		if(cmdName == null || cmdName.isEmpty()) {
			cmdName = "UnknownCommandName";
		}
		String subName = evalCommandType.getSubName();
		RFuture<R> result = Weaver.callOriginal();
		if(result instanceof RedissonPromise) {
			String collectionName = objectType != null ? objectType : "?";
			Segment segment = NewRelic.getAgent().getTransaction().startSegment(cmdName + "-" + collectionName);
			segment.addCustomAttribute("Command", cmdName);
			if(subName != null) {
				segment.addCustomAttribute("Sub", subName);
			}
			DatastoreParameters dsParams = DatastoreParameters.product("Redisson").collection(collectionName).operation(cmdName).build();
			NRBiConsumer<R> action = new NRBiConsumer<R>(segment, dsParams);
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			promise.onComplete(action);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<Collection<R>> readAllAsync(final Collection<R> results, Codec codec, RedisCommand<T> command, Object... params)  {
		String cmdName = command.getName();
		if(cmdName == null || cmdName.isEmpty()) {
			cmdName = "UnknownCommandName";
		}
		String subName = command.getSubName();
		RFuture<Collection<R>> result = Weaver.callOriginal();
		if(result instanceof RedissonPromise) {
			String collectionName = objectType != null ? objectType : "?";
			Segment segment = NewRelic.getAgent().getTransaction().startSegment(cmdName + "-" + collectionName);
			segment.addCustomAttribute("Command", cmdName);
			if(subName != null) {
				segment.addCustomAttribute("Sub", subName);
			}
			DatastoreParameters dsParams = DatastoreParameters.product("Redisson").collection(collectionName).operation(cmdName).build();
			NRBiConsumer<Collection<R>> action = new NRBiConsumer<Collection<R>>(segment, dsParams);
			RedissonPromise<Collection<R>> promise = (RedissonPromise<Collection<R>>)result;
			promise.onComplete(action);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> readAsync(byte[] key, Codec codec, RedisCommand<T> command, Object... params) {
		String cmdName = command.getName();
		if(cmdName == null || cmdName.isEmpty()) {
			cmdName = "UnknownCommandName";
		}
		String subName = command.getSubName();
		RFuture<R> result = Weaver.callOriginal();
		if(result instanceof RedissonPromise) {
			String collectionName = objectType != null ? objectType : "?";
			Segment segment = NewRelic.getAgent().getTransaction().startSegment(cmdName + "-" + collectionName);
			segment.addCustomAttribute("Command", cmdName);
			if(subName != null) {
				segment.addCustomAttribute("Sub", subName);
			}
			DatastoreParameters dsParams = DatastoreParameters.product("Redisson").collection(collectionName).operation(cmdName).build();
			NRBiConsumer<R> action = new NRBiConsumer<R>(segment, dsParams);
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			promise.onComplete(action);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> readAsync(String key, Codec codec, RedisCommand<T> command, Object... params) {
		String cmdName = command.getName();
		if(cmdName == null || cmdName.isEmpty()) {
			cmdName = "UnknownCommandName";
		}
		String subName = command.getSubName();
		RFuture<R> result = Weaver.callOriginal();
		if(result instanceof RedissonPromise) {
			String collectionName = objectType != null ? objectType : "?";
			Segment segment = NewRelic.getAgent().getTransaction().startSegment(cmdName + "-" + collectionName);
			segment.addCustomAttribute("Command", cmdName);
			if(subName != null) {
				segment.addCustomAttribute("Sub", subName);
			}
			DatastoreParameters dsParams = DatastoreParameters.product("Redisson").collection(collectionName).operation(cmdName).build();
			NRBiConsumer<R> action = new NRBiConsumer<R>(segment, dsParams);
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			promise.onComplete(action);
		}
		return result;
	}    	

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> readAsync(RedisClient client, byte[] key, Codec codec, RedisCommand<T> command, Object... params) {
		String cmdName = command.getName();
		if(cmdName == null || cmdName.isEmpty()) {
			cmdName = "UnknownCommandName";
		}
		String subName = command.getSubName();
		RFuture<R> result = Weaver.callOriginal();
		if(result instanceof RedissonPromise) {
			String collectionName = objectType != null ? objectType : "?";
			Segment segment = NewRelic.getAgent().getTransaction().startSegment(cmdName + "-" + collectionName);
			segment.addCustomAttribute("Command", cmdName);
			if(subName != null) {
				segment.addCustomAttribute("Sub", subName);
			}
			DatastoreParameters dsParams = DatastoreParameters.product("Redisson").collection(collectionName).operation(cmdName).build();
			NRBiConsumer<R> action = new NRBiConsumer<R>(segment, dsParams);
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			promise.onComplete(action);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> readAsync(RedisClient client, MasterSlaveEntry entry, Codec codec, RedisCommand<T> command, Object... params) {
		String cmdName = command.getName();
		if(cmdName == null || cmdName.isEmpty()) {
			cmdName = "UnknownCommandName";
		}
		String subName = command.getSubName();
		RFuture<R> result = Weaver.callOriginal();
		if(result instanceof RedissonPromise) {
			String collectionName = objectType != null ? objectType : "?";
			Segment segment = NewRelic.getAgent().getTransaction().startSegment(cmdName + "-" + collectionName);
			segment.addCustomAttribute("Command", cmdName);
			if(subName != null) {
				segment.addCustomAttribute("Sub", subName);
			}
			DatastoreParameters dsParams = DatastoreParameters.product("Redisson").collection(collectionName).operation(cmdName).build();
			NRBiConsumer<R> action = new NRBiConsumer<R>(segment, dsParams);
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			promise.onComplete(action);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> readAsync(MasterSlaveEntry entry, Codec codec, RedisCommand<T> command, Object... params) {
		String cmdName = command.getName();
		if(cmdName == null || cmdName.isEmpty()) {
			cmdName = "UnknownCommandName";
		}
		String subName = command.getSubName();
		RFuture<R> result = Weaver.callOriginal();
		if(result instanceof RedissonPromise) {
			String collectionName = objectType != null ? objectType : "?";
			Segment segment = NewRelic.getAgent().getTransaction().startSegment(cmdName + "-" + collectionName);
			segment.addCustomAttribute("Command", cmdName);
			if(subName != null) {
				segment.addCustomAttribute("Sub", subName);
			}
			DatastoreParameters dsParams = DatastoreParameters.product("Redisson").collection(collectionName).operation(cmdName).build();
			NRBiConsumer<R> action = new NRBiConsumer<R>(segment, dsParams);
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			promise.onComplete(action);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> readRandomAsync(Codec codec, RedisCommand<T> command, Object... params) {
		String cmdName = command.getName();
		if(cmdName == null || cmdName.isEmpty()) {
			cmdName = "UnknownCommandName";
		}
		String subName = command.getSubName();
		RFuture<R> result = Weaver.callOriginal();
		if(result instanceof RedissonPromise) {
			String collectionName = objectType != null ? objectType : "?";
			Segment segment = NewRelic.getAgent().getTransaction().startSegment(cmdName + "-" + collectionName);
			segment.addCustomAttribute("Command", cmdName);
			if(subName != null) {
				segment.addCustomAttribute("Sub", subName);
			}
			DatastoreParameters dsParams = DatastoreParameters.product("Redisson").collection(collectionName).operation(cmdName).build();
			NRBiConsumer<R> action = new NRBiConsumer<R>(segment, dsParams);
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			promise.onComplete(action);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> readRandomAsync(MasterSlaveEntry entry, Codec codec, RedisCommand<T> command, Object... params) {
		String cmdName = command.getName();
		if(cmdName == null || cmdName.isEmpty()) {
			cmdName = "UnknownCommandName";
		}
		String subName = command.getSubName();
		RFuture<R> result = Weaver.callOriginal();
		if(result instanceof RedissonPromise) {
			String collectionName = objectType != null ? objectType : "?";
			Segment segment = NewRelic.getAgent().getTransaction().startSegment(cmdName + "-" + collectionName);
			segment.addCustomAttribute("Command", cmdName);
			if(subName != null) {
				segment.addCustomAttribute("Sub", subName);
			}
			DatastoreParameters dsParams = DatastoreParameters.product("Redisson").collection(collectionName).operation(cmdName).build();
			NRBiConsumer<R> action = new NRBiConsumer<R>(segment, dsParams);
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			promise.onComplete(action);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> writeAsync(byte[] key, Codec codec, RedisCommand<T> command, Object... params) {
		String cmdName = command.getName();
		if(cmdName == null || cmdName.isEmpty()) {
			cmdName = "UnknownCommandName";
		}
		String subName = command.getSubName();
		RFuture<R> result = Weaver.callOriginal();
		if(result instanceof RedissonPromise) {
			String collectionName = objectType != null ? objectType : "?";
			Segment segment = NewRelic.getAgent().getTransaction().startSegment(cmdName + "-" + collectionName);
			segment.addCustomAttribute("Command", cmdName);
			if(subName != null) {
				segment.addCustomAttribute("Sub", subName);
			}
			DatastoreParameters dsParams = DatastoreParameters.product("Redisson").collection(collectionName).operation(cmdName).build();
			NRBiConsumer<R> action = new NRBiConsumer<R>(segment, dsParams);
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			promise.onComplete(action);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> writeAsync(String key, Codec codec, RedisCommand<T> command, Object... params) {
		String cmdName = command.getName();
		if(cmdName == null || cmdName.isEmpty()) {
			cmdName = "UnknownCommandName";
		}
		String subName = command.getSubName();
		RFuture<R> result = Weaver.callOriginal();
		if(result instanceof RedissonPromise) {
			String collectionName = objectType != null ? objectType : "?";
			Segment segment = NewRelic.getAgent().getTransaction().startSegment(cmdName + "-" + collectionName);
			segment.addCustomAttribute("Command", cmdName);
			if(subName != null) {
				segment.addCustomAttribute("Sub", subName);
			}
			DatastoreParameters dsParams = DatastoreParameters.product("Redisson").collection(collectionName).operation(cmdName).build();
			NRBiConsumer<R> action = new NRBiConsumer<R>(segment, dsParams);
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			promise.onComplete(action);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> writeAsync(MasterSlaveEntry entry, Codec codec, RedisCommand<T> command, Object... params) {
		String cmdName = command.getName();
		if(cmdName == null || cmdName.isEmpty()) {
			cmdName = "UnknownCommandName";
		}
		String subName = command.getSubName();
		RFuture<R> result = Weaver.callOriginal();
		if(result instanceof RedissonPromise) {
			String collectionName = objectType != null ? objectType : "?";
			Segment segment = NewRelic.getAgent().getTransaction().startSegment(cmdName + "-" + collectionName);
			segment.addCustomAttribute("Command", cmdName);
			if(subName != null) {
				segment.addCustomAttribute("Sub", subName);
			}
			DatastoreParameters dsParams = DatastoreParameters.product("Redisson").collection(collectionName).operation(cmdName).build();
			NRBiConsumer<R> action = new NRBiConsumer<R>(segment, dsParams);
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			promise.onComplete(action);
		}
		return result;
	}
}
