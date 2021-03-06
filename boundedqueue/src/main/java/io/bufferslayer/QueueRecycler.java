package io.bufferslayer;

import io.bufferslayer.AbstractQueueRecycler.Callback;
import io.bufferslayer.Message.MessageKey;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by tramchamploo on 2017/5/4.
 * A recycler that manages {@link SizeBoundedQueue}'s lifecycle
 */
public interface QueueRecycler {

  /**
   * Get a queue by message key if exists otherwise create one
   *
   * @param key message key related to the queue
   * @return the queue
   */
  SizeBoundedQueue getOrCreate(MessageKey key);

  /**
   * set a callback for queue creation
   * @param callback callback to trigger after a queue is created
   */
  void createCallback(Callback callback);

  /**
   * Lease a queue due to its priority
   *
   * @return queue with the highest priority at the moment
   */
  SizeBoundedQueue lease(long timeout, TimeUnit unit);

  /**
   * Put the queue back to recycler for others to use
   *
   * @param queue queue to return back
   */
  void recycle(SizeBoundedQueue queue);

  /**
   * Drop queues which exceed its keepalive
   */
  List<MessageKey> shrink();

  /**
   * Clear everything
   */
  void clear();

  /**
   * Get all queues
   */
  Collection<SizeBoundedQueue> elements();
}
