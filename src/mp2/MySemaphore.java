package mp2;

public class MySemaphore {
	private int permits;
	private Object instanceLock;
	
	public MySemaphore(int permits) {
		this.permits = permits;
		this.instanceLock = new Object();
	}
	
	// TODO: Implement acquire(). 
	// In a thread-safe manner: 
	// 		If there are a non-zero amount of permits, decrement the permit count
	// 		If there are zero or less permits, block
	public void acquire() {
		
		synchronized(instanceLock) {
			if(permits <= 0)
				try {
					instanceLock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			permits--;
			
				
			
			
			
		}
		return;
	}
	
	// TODO: Implement release()
	// In a thread-safe manner:
	//		Increment the permit count
	public void release() {
		synchronized(instanceLock) {
			permits++;
			instanceLock.notify();
		}
		return;
	}
	
	public int getPermits() {
		return this.permits;
	}
}
