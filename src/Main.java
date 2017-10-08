
public class Main {
	public static void main(String[] args){
		Queue<String> printer=new Queue();
		Queue<Integer> printer1=new Queue();
		printer1.enQueue(1);
		printer1.enQueue(2);
		printer.enQueue("Hello");
		printer.enQueue("World");
		System.out.println(printer.getFront()+printer1.getFront());
		
	}
}
