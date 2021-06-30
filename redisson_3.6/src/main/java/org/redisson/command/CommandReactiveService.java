package org.redisson.command;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

import org.reactivestreams.Publisher;
import org.redisson.SlotCallback;
import org.redisson.api.RFuture;
import org.redisson.client.RedisClient;
import org.redisson.client.codec.Codec;
import org.redisson.client.protocol.RedisCommand;
import org.redisson.connection.ConnectionManager;
import org.redisson.connection.MasterSlaveEntry;

import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.redisson.NRSupplierWrapper;

@Weave
public abstract class CommandReactiveService {

	@NewField
	private String commandName = null;

	@NewField
	private String subName = null;
	
	@NewField
	private DatastoreParameters dsParams = null;

	public CommandReactiveService(ConnectionManager connectionManager) {
		
	}
	
	public <R> Publisher<R> reactive(Supplier<RFuture<R>> supplier) {
		NRSupplierWrapper<R> wrapper = new NRSupplierWrapper<R>(supplier, commandName, subName, dsParams);
		supplier = wrapper;
		commandName = null;
		subName = null;
		dsParams =  null;
		return Weaver.callOriginal();
	}
	
	@Trace(excludeFromTransactionTrace=true)
    public <T, R> Publisher<R> evalWriteAllReactive(final RedisCommand<T> command, final SlotCallback<T, R> callback, final String script, final List<Object> keys, final Object ... params) {
		Publisher<R> publisher = Weaver.callOriginal();
		commandName = command.getName();
		subName = command.getSubName();
		dsParams = DatastoreParameters.product("Redisson").collection("?").operation(commandName).build();

		return publisher;
    }

	@Trace(excludeFromTransactionTrace=true)
     public <T, R> Publisher<Collection<R>> readAllReactive(final RedisCommand<T> command, final Object ... params) {
		Publisher<Collection<R>> publisher = Weaver.callOriginal();
		commandName = command.getName();
		subName = command.getSubName();
		dsParams = DatastoreParameters.product("Redisson").collection("?").operation(commandName).build();
		
		return publisher;
    }

	@Trace(excludeFromTransactionTrace=true)
    public <T, R> Publisher<R> readRandomReactive(final RedisCommand<T> command, final Object ... params) {
		Publisher<R> publisher = Weaver.callOriginal();
		commandName = command.getName();
		subName = command.getSubName();
		dsParams = DatastoreParameters.product("Redisson").collection("?").operation(commandName).build();
		
		return publisher;
    }

	@Trace(excludeFromTransactionTrace=true)
    public <T, R> Publisher<R> writeReactive(final String key, final Codec codec, final RedisCommand<T> command, final Object ... params) {
		Publisher<R> publisher = Weaver.callOriginal();
		commandName = command.getName();
		subName = command.getSubName();
		dsParams = DatastoreParameters.product("Redisson").collection("?").operation(commandName).build();
		
		return publisher;
    }

	@Trace(excludeFromTransactionTrace=true)
    public <T, R> Publisher<R> writeReactive(final MasterSlaveEntry entry, final Codec codec, final RedisCommand<T> command, final Object ... params) {
		Publisher<R> publisher = Weaver.callOriginal();
		commandName = command.getName();
		subName = command.getSubName();
		dsParams = DatastoreParameters.product("Redisson").collection("?").operation(commandName).build();
		
		return publisher;
    }

	@Trace(excludeFromTransactionTrace=true)
    public <T, R> Publisher<R> readReactive(final String key, final Codec codec, final RedisCommand<T> command, final Object ... params) {
		Publisher<R> publisher = Weaver.callOriginal();
		commandName = command.getName();
		subName = command.getSubName();
		dsParams = DatastoreParameters.product("Redisson").collection("?").operation(commandName).build();
		
		return publisher;
    }

	@Trace(excludeFromTransactionTrace=true)
    public <T, R> Publisher<R> evalReadReactive(final String key, final Codec codec, final RedisCommand<T> evalCommandType,
            final String script, final List<Object> keys, final Object... params) {
		Publisher<R> publisher = Weaver.callOriginal();
		commandName = evalCommandType.getName();
		subName = evalCommandType.getSubName();
		dsParams = DatastoreParameters.product("Redisson").collection("?").operation(commandName).build();
		
		return publisher;
    }

	@Trace(excludeFromTransactionTrace=true)
    public <T, R> Publisher<R> evalWriteReactive(final String key, final Codec codec, final RedisCommand<T> evalCommandType,
            final String script, final List<Object> keys, final Object... params) {
		Publisher<R> publisher = Weaver.callOriginal();
		commandName = evalCommandType.getName();
		subName = evalCommandType.getSubName();
		dsParams = DatastoreParameters.product("Redisson").collection("?").operation(commandName).build();
		
		return publisher;
    }

	@Trace(excludeFromTransactionTrace=true)
    public <T> Publisher<Void> writeAllReactive(final RedisCommand<T> command, final Object ... params) {
		Publisher<Void> publisher = Weaver.callOriginal();
		commandName = command.getName();
		subName = command.getSubName();
		dsParams = DatastoreParameters.product("Redisson").collection("?").operation(commandName).build();
		
		return publisher;
    }

	@Trace(excludeFromTransactionTrace=true)
    public <R, T> Publisher<R> writeAllReactive(final RedisCommand<T> command, final SlotCallback<T, R> callback, final Object ... params) {
		Publisher<R> publisher = Weaver.callOriginal();
		commandName = command.getName();
		subName = command.getSubName();
		dsParams = DatastoreParameters.product("Redisson").collection("?").operation(commandName).build();
		
		return publisher;
    }

	@Trace(excludeFromTransactionTrace=true)
	public <T, R> Publisher<R> readReactive(RedisClient client, String name, Codec codec, RedisCommand<T> command, Object ... params) {
		Publisher<R> publisher = Weaver.callOriginal();
		commandName = command.getName();
		subName = command.getSubName();
		dsParams = DatastoreParameters.product("Redisson").collection("?").operation(commandName).build();
		
		return publisher;
	}

}
