
public class AtividadeThread implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread threadPrimeira = new Thread(new AtividadeThread());
		
		threadPrimeira.start();
		
		Thread threadSegunda = new Thread(new AtividadeThread());
		
		threadSegunda.start();
		
		threadPrimeira.join(10000);
		
		System.out.println("Thread atual -> " + threadPrimeira.getName());
		System.out.println("Thread atual -> " + threadSegunda.getName());
		
		System.out.println("Thread primeira está viva -> " + threadPrimeira.isAlive());
		System.out.println("Thread segunda está viva -> " + threadSegunda.isAlive());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int count = 0; count < 4; count++) {
			System.out.println(Thread.currentThread().getName() + " " + count);
			
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		
		Thread thread = Thread.currentThread();
		
		System.out.println("Thread que está no momento: " + thread.getName());
		System.out.println("A thread está viva: " + thread.isAlive());
	}

}
