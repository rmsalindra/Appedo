package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B {

	public static void main(String[] args) throws Exception {

       ThreadGroup tg = new ThreadGroup("syn");
       Thread1 t1 = new Thread1(tg);
    }
}

class Thread1 extends Thread{
	@Override
	public void run() {
		new SynchronizationClass().test();
	}
}
class Thread2 extends Thread{
	@Override
	public void run() {
		new SynchronizationClass().test();
	}
}
class Thread3 extends Thread{
	@Override
	public void run() {
		new SynchronizationClass().test();
	}
}
class Thread4 extends Thread{
	@Override
	public void run() {
		new SynchronizationClass().test();
	}
}

class Thread5 extends Thread{
	@Override
	public void run() {
		new SynchronizationClass().test();
	}
}
class Thread6 extends Thread{
	@Override
	public void run() {
		new SynchronizationClass().test();
	}
}
class Thread7 extends Thread{
	@Override
	public void run() {
		new SynchronizationClass().test();
	}
}class Thread8 extends Thread{
	@Override
	public void run() {
		new SynchronizationClass().test();
	}
}
class Thread9 extends Thread{
	@Override
	public void run() {
		new SynchronizationClass().test();
	}
}
class Thread10 extends Thread{
	@Override
	public void run() {
		new SynchronizationClass().test();
	}
}
class Thread11 extends Thread{
	@Override
	public void run() {
		new SynchronizationClass().test();
	}
}