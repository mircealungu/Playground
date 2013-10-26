import java.util.*;
class HelloWorlder extends Thread {
	int id;
	public HelloWorlder (int id) {
		this.id = id;
	}
	public void run () {
		while (true) {
			System.out.println(id + ": ");
			System.out.println("Hello World! ");
			System.out.println("I say! ");
			try {
				sleep (3000 * id);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class HelloWorldChoir {
	public static void main (String [] args) {
		ArrayList <HelloWorlder> hws = new ArrayList <HelloWorlder> ();
		ArrayList <Thread> threads = new ArrayList <Thread>();

		for (int i = 0; i < 10; i++) {
			HelloWorlder hw = new HelloWorlder (i);
			System.out.println(hw.id);
			hws.add(i, hw);
			threads.add(new Thread (hw));
		}
		for (Thread t: threads)
			t.start();
	}
}
