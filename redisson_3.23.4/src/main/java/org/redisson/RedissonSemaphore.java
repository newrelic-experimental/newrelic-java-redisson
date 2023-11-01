package org.redisson;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.redisson.api.RFuture;
import org.redisson.api.RSemaphore;

import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.redisson.Utils;

@SuppressWarnings("unused")
@Weave(type=MatchType.BaseClass)
public abstract class RedissonSemaphore implements RSemaphore {

    public void acquire(int permits) throws InterruptedException {
		if(!Utils.operationIsSet()) {
			Utils.setOperation("ACQUIRE");
		}
		if(!Utils.typeSet()) {
			Utils.setType(this);
		}
		Weaver.callOriginal();
    }
    
    public RFuture<Void> acquireAsync(int permits) {
		if(!Utils.operationIsSet()) {
			Utils.setOperation("ACQUIRE");
		}
		if(!Utils.typeSet()) {
			Utils.setType(this);
		}
		if(!Utils.objectNameSet()) {
			Utils.setObjectName(getName());
		}
		return Weaver.callOriginal();
    }
    
    private void tryAcquireAsync(AtomicLong time, int permits, RedissonLockEntry entry, CompletableFuture<Void> result) {
		if(!Utils.operationIsSet()) {
			Utils.setOperation("TRYACQUIRE");
		}
		if(!Utils.typeSet()) {
			Utils.setType(this);
		}
		Weaver.callOriginal();
    }
    
	private void acquireAsync(int permits, RedissonLockEntry entry, CompletableFuture<Void> result) {
		if(!Utils.operationIsSet()) {
			Utils.setOperation("ACQUIRE");
		}
		if(!Utils.typeSet()) {
			Utils.setType(this);
		}
		Weaver.callOriginal();
    }

    public RFuture<Boolean> tryAcquireAsync(int permits) {
		if(!Utils.operationIsSet()) {
			Utils.setOperation("TRYACQUIRE");
		}
		if(!Utils.typeSet()) {
			Utils.setType(this);
		}
		if(!Utils.objectNameSet()) {
			Utils.setObjectName(getName());
		}
		return Weaver.callOriginal();
    }

    public boolean tryAcquire(int permits, long waitTime, TimeUnit unit) throws InterruptedException {
		if(!Utils.operationIsSet()) {
			Utils.setOperation("TRYACQUIRE");
		}
		if(!Utils.typeSet()) {
			Utils.setType(this);
		}
		if(!Utils.objectNameSet()) {
			Utils.setObjectName(getName());
		}
		return Weaver.callOriginal();
    }

    public RFuture<Boolean> tryAcquireAsync(int permits, long waitTime, TimeUnit unit) {
		if(!Utils.operationIsSet()) {
			Utils.setOperation("TRYACQUIRE");
		}
		if(!Utils.typeSet()) {
			Utils.setType(this);
		}
		if(!Utils.objectNameSet()) {
			Utils.setObjectName(getName());
		}
		return Weaver.callOriginal();
    }

    public RFuture<Void> releaseAsync() {
		if(!Utils.operationIsSet()) {
			Utils.setOperation("RELEASE");
		}
		if(!Utils.typeSet()) {
			Utils.setType(this);
		}
		if(!Utils.objectNameSet()) {
			Utils.setObjectName(getName());
		}
		return Weaver.callOriginal();
    }
    
    public RFuture<Void> releaseAsync(int permits) {
		if(!Utils.operationIsSet()) {
			Utils.setOperation("RELEASE");
		}
		if(!Utils.typeSet()) {
			Utils.setType(this);
		}
		if(!Utils.objectNameSet()) {
			Utils.setObjectName(getName());
		}
		return Weaver.callOriginal();
    }

    public int drainPermits() {
		if(!Utils.operationIsSet()) {
			Utils.setOperation("DRAINPERMITS");
		}
		if(!Utils.typeSet()) {
			Utils.setType(this);
		}
		if(!Utils.objectNameSet()) {
			Utils.setObjectName(getName());
		}
		return Weaver.callOriginal();
    }

    public int availablePermits() {
		if(!Utils.operationIsSet()) {
			Utils.setOperation("AVAILABLEPERMITS");
		}
		if(!Utils.typeSet()) {
			Utils.setType(this);
		}
		if(!Utils.objectNameSet()) {
			Utils.setObjectName(getName());
		}
		return Weaver.callOriginal();
    }

    public RFuture<Boolean> trySetPermitsAsync(int permits) {
		if(!Utils.operationIsSet()) {
			Utils.setOperation("TRYSETPERMITS");
		}
		if(!Utils.typeSet()) {
			Utils.setType(this);
		}
		if(!Utils.objectNameSet()) {
			Utils.setObjectName(getName());
		}
		return Weaver.callOriginal();
    }
    
}
