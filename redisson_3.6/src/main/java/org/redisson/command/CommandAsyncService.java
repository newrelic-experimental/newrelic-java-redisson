package org.redisson.command;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.redisson.SlotCallback;
import org.redisson.api.RFuture;
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
import com.nr.instrumentation.redisson.NRFutureListener;

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

	@Trace
	public boolean await(RFuture<?> RFuture, long timeout, TimeUnit timeoutUnit) {

		return Weaver.callOriginal();
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> writeAsync(MasterSlaveEntry entry, Codec codec, RedisCommand<T> command, Object ... params) {
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
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			NRFutureListener<R> listener = new NRFutureListener<R>(segment, dsParams);
			promise.addListener(listener);
		}
		return result;
	}


	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> evalWriteAllAsync(RedisCommand<T> command, SlotCallback<T, R> callback, String script, List<Object> keys, Object ... params) {
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
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			NRFutureListener<R> listener = new NRFutureListener<R>(segment, dsParams);
			promise.addListener(listener);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> readAsync(String key, Codec codec, RedisCommand<T> command, Object ... params) {
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
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			NRFutureListener<R> listener = new NRFutureListener<R>(segment, dsParams);
			promise.addListener(listener);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> writeAsync(String key, Codec codec, RedisCommand<T> command, Object ... params) {
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
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			NRFutureListener<R> listener = new NRFutureListener<R>(segment, dsParams);
			promise.addListener(listener);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<Collection<R>> readAllAsync(RedisCommand<T> command, Object ... params) {
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
			RedissonPromise<Collection<R>> promise = (RedissonPromise<Collection<R>>)result;
			NRFutureListener<Collection<R>> listener = new NRFutureListener<Collection<R>>(segment, dsParams);
			promise.addListener(listener);
		}
		return result;
	}

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> RFuture<R> readRandomAsync(RedisCommand<T> command, Object ... params) {
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
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			NRFutureListener<R> listener = new NRFutureListener<R>(segment, dsParams);
			promise.addListener(listener);
		}
		return result;
	}


	@Trace(excludeFromTransactionTrace=true)
	private <T, R> RFuture<R> allAsync(boolean readOnlyMode, RedisCommand<T> command, final SlotCallback<T, R> callback, Object... params) {
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
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			NRFutureListener<R> listener = new NRFutureListener<R>(segment, dsParams);
			promise.addListener(listener);
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
			RedissonPromise<R> promise = (RedissonPromise<R>)result;
			NRFutureListener<R> listener = new NRFutureListener<R>(segment, dsParams);
			promise.addListener(listener);
		}
		return result;
	}
	

}
