package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread{

	
	int a,b;
	
	private List<Integer> primes=new LinkedList<Integer>();
	
	private boolean suspender;
	private boolean pausar;
	
	public PrimeFinderThread(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		this.suspender = false;
		this.pausar = false;
	}

	public void run(){
		for (int i=a;i<=b;i++){						
			if (isPrime(i)){
				primes.add(i);
				System.out.println(i);
			}
			synchronized (this) {
				while (suspender) {
					try{
						this.wait();
					} catch (Exception e){
						e.printStackTrace();
					}
				}
				if (pausar) break;
			}
		}
	}
	
	public synchronized void pausarhilo(){
        pausar=true;
        //lo siguiente garantiza que un hilo suspendido puede detenerse.
        suspender=false;
        notify();
    }
	
	public synchronized void suspenderhilo(){
        suspender=true;
    }
	
	public synchronized void renaudarhilo(){
        suspender=false;
        notify();
    }
	
	boolean isPrime(int n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	public List<Integer> getPrimes() {
		return primes;
	}
	
}
