package atividade;

public class Index implements Runnable {
	
	public void run() {

		for (int i = 0; i < 4; i++) {
			System.out.println(Thread.currentThread().getName() + "  " + i);
			try {
				Thread.sleep(1000);
			}

			catch (Exception e) {
				System.out.println(e);
			}
		}
		Thread t = Thread.currentThread();
		System.out.println("Thread: " + t.getName());
		System.out.println("A Thread está funcionando: " + t.isAlive());

	}

	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Index());
		t.start();
		
		Thread t2 = new Thread(new Index());
        t2.start();

		t.join(10000);
		System.out.println("\nFazendo o Join depois de 10000" + " milisegundos: \n");
		System.out.println("Thread: " + t.getName());
		System.out.println("Thread: " + t2.getName());
		System.out.println("Funcionando: " + t.isAlive());
		System.out.println("Funcionando: " + t2.isAlive());
	}
}
