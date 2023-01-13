//wait(), notify and notifyAll() all object methods
// Thread Inter communication using synchronzied keyword
// lock - wait() - lock realeased immediately
//lock realeased but may not immediately notify();
class InterCommunication 
{
	public static void main(String[] args) throws InterruptedException
	{
		ThreadA t = new ThreadA();
		t.start();
		synchronized(t){
			System.out.println("Main thread trying to call wait method");
			t.wait();
		}
		System.out.println("Main thread got notified by child thread");
		System.out.println(t.total);
		
	}
}
class ThreadA extends Thread {
	int total = 0;
	public void run() { 
		
		synchronized(this) {
			System.out.println("child thread starts calculations");
			for(int i =0;i<100;i++){
				total+=i;
			}
			System.out.println("child thread trying to give notification");
			this.notify();
		}
		

	}
}