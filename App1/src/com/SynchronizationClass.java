package com;

public class SynchronizationClass {

	int index = 0;
	public void test(){
		CurrentTime current = new CurrentTime();
		synchronized (current) {
			System.out.println("inded is: "+index);
		}
	}
	
}
