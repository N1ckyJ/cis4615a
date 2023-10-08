
public class R09_LCK09_J {
	// LCK09-J. Do not perform operations that can block while holding a lock 
	//Noncompliant Code Example
	public synchronized void doSomething(long time) throws InterruptedException {
		// ...
		Thread.sleep(time);
	}
	//Compliant Code Example
	public synchronized void doSomething(long timeout) throws InterruptedException {
		//...
		while (<condition does not hold>) {
			wait(timeout); // Immediately releases the current monitor
		}
	}
}
