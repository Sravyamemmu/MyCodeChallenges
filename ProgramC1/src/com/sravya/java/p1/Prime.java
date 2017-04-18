package com.sravya.java.p1;

import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author Sravya
 * Class to verify a number from Queue Prime or not and store the result in another queue.
 */
public class Prime implements Runnable{

	private final BlockingQueue<Integer> sharedQueue1; //Shared Queue 1 for random numbers
	private final BlockingQueue<String> sharedQueue2; // Shared Queue 2 for prime numbers

	/**
	 * 
	 * @param sharedQueue1
	 * @param sharedQueue2
	 * Initializing queues with Prime instantiation
	 */
    public Prime(BlockingQueue<Integer> sharedQueue1,BlockingQueue<String> sharedQueue2) {
        this.sharedQueue1 = sharedQueue1; 
        this.sharedQueue2 = sharedQueue2;
    }
    
    /**
     * Method to verify , whether passed number is a prime or not
     * @param n
     * @return
     */
    public boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

	@Override
	public void run() {
		if(sharedQueue1 != null && sharedQueue1.size() >0){//if the shared queue is not null and the size of queue is not empty
			try {
				int number =sharedQueue1.take(); //take out the top most element from shared queue
				if(isPrime(number)){//if the passed element is prime number
					sharedQueue2.put(number+","+true);//storing message in shared queue
				}else{
					sharedQueue2.put(number+","+false);//storing message in shared queue
				}
			} catch (InterruptedException e) {
				e.printStackTrace();//printing exception stack on console
			}
		}
		//executing run method forever
		while(true){
			try {
				Thread.sleep(2000);//making to sleep the Thread for 2 secs
			} catch (InterruptedException e) {
				e.printStackTrace();//printing the exception stack trace in console
			}
			run();
		}
	}
    
}
