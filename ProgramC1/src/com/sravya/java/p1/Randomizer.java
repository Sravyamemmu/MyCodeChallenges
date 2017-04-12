package com.sravya.java.p1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Randomizer implements Runnable{
  
	private final BlockingQueue<Integer> sharedQueue1;
	private final BlockingQueue<String> sharedQueue2;

    public Randomizer(BlockingQueue<Integer> sharedQueue1,BlockingQueue<String> sharedQueue2) {
        this.sharedQueue1 = sharedQueue1;
        this.sharedQueue2 = sharedQueue2;
    }


	public  int generateRandomNumber() {
		Random rand = new Random();
		return ( 1 + rand.nextInt((1000 - 1) + 1));
	}

	@Override
	public void run() {
		
		try {
			int number = generateRandomNumber();
			sharedQueue1.put(number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(null != sharedQueue2 && sharedQueue2.size() > 0){
			try {
				String result = sharedQueue2.take();
				String[] arr = result.split(",");
				if(null != arr && arr.length >0){
					System.out.println("Number : "+arr[0]+" Is A Prime : "+arr[1]);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}//end if
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
