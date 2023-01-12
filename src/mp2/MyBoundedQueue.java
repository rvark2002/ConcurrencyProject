package mp2;

import java.util.*;

public class MyBoundedQueue<T> {
	private Object instanceLock;
	private ArrayList<T> queue;
	private int capacity;
	
	public MyBoundedQueue(int size) {
		this.instanceLock = new Object();
		this.queue = new ArrayList<T>();
		this.capacity = size;
	}
	
	// TODO: Implement put()
	// In a thread-safe manner:
	//		If there is space in the queue, add value to queue in FIFO order
	//		Otherwise, block operation
	public void put(T val) throws Exception {
		

		
		synchronized(instanceLock) {
			
			if(queue.size() >= capacity)
				instanceLock.wait();
			
			
			queue.add(val);
			
			instanceLock.notify();
		}
		
	}
	
	// TODO: Implement take()
	// In a thread-safe manner:
	//		If there are items in the queue, remove and return 
	//			first value from queue in FIFO order
	//		Otherwise, block operation
	public T take() throws Exception {
		

		
		synchronized(instanceLock) {
			if(queue.size() <= 0)
				instanceLock.wait();
			
			T a = queue.get(0);
			queue.remove(0);
			instanceLock.notify();
			return a;
			
			
		}
	}
}
