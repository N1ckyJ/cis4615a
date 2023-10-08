
public class R10_THI05_J {
	// THI05-J. Do not use Thread.stop() to terminate threads 
	//Noncompliant Code Example
	public final class Container implements Runnable {
		  private final Vector<Integer> vector = new Vector<Integer>(1000);
		 
		  public Vector<Integer> getVector() {
		    return vector;
		  }
		 
		  @Override public synchronized void run() {
		    Random number = new Random(123L);
		    int i = vector.capacity();
		    while (i > 0) {
		      vector.add(number.nextInt(100));
		      i--;
		    }
		  }
		 
		  public static void main(String[] args) throws InterruptedException {
		    Thread thread = new Thread(new Container());
		    thread.start();
		    Thread.sleep(5000);
		    thread.stop();
		  }
		}
	//Compliant Code Example
	public final class Container implements Runnable {
		  private final Vector<Integer> vector = new Vector<Integer>(1000);
		  private volatile boolean done = false;
		 
		  public Vector<Integer> getVector() {
		    return vector;
		  }
		 
		  public void shutdown() {
		    done = true;
		  }
		 
		  @Override public synchronized void run() {
		    Random number = new Random(123L);
		    int i = vector.capacity();
		    while (!done && i > 0) {
		      vector.add(number.nextInt(100));
		      i--;
		    }
		  }
		 
		  public static void main(String[] args) throws InterruptedException {
		    Container container = new Container();
		    Thread thread = new Thread(container);
		    thread.start();
		    Thread.sleep(5000);
		    container.shutdown();
		  }
		}


}
