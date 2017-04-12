package com.sravya.java.p1;

import java.util.concurrent.BlockingQueue;

public class Prime implements Runnable{

	private final BlockingQueue<Integer> sharedQueue1;
	private final BlockingQueue<String> sharedQueue2;

    public Prime(BlockingQueue<Integer> sharedQueue1,BlockingQueue<String> sharedQueue2) {
        this.sharedQueue1 = sharedQueue1;
        this.sharedQueue2 = sharedQueue2;
    }
    
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
		if(sharedQueue1 != null && sharedQueue1.size() >0){
			try {
				int number =sharedQueue1.take();
				if(isPrime(number)){
					sharedQueue2.put(number+","+true);
				}else{
					sharedQueue2.put(number+","+false);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while(true){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			run();
		}
	}
    
}
