import java.rmi.NoSuchObjectException;

public class Queue<Type> {
	private Type[] elements;
	private static final int DEFAULT_CAPACITY=10;
	private int front;
	private int rear;
	public Queue(){
		elements=(Type[])new Object[DEFAULT_CAPACITY];
		rear=front=0;
	}
	public void clear(){
		front=rear=0;
	}
	public boolean isEmpty(){
		return front==rear;
	}
	public boolean isFull(){
		return rear+1==front%elements.length;
	}
	public int size(){
		return (rear+elements.length-front)%elements.length;
	}
	public void enQueue(Type item){
		if(isFull()){
			//throw new Exception();
			return;
		}
		rear=(rear+1)%elements.length;
		elements[rear]=item;
	}
	public Type deQueue(){
		if(isEmpty()){
			//throw new Exception();
			return null;
		}
		front=(front+1)%elements.length;
		return elements[front];
	}
	public Type getFront(){
		if(isEmpty()){
			//throw new NoSuchObjectException(null);
			return null;
		}
		return elements[(front+1)%elements.length];
	}
}
