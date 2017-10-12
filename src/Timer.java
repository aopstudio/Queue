
public class Timer {
	private int time=0;
	private int next=0;
	public void setNext(int next){
		this.next=next;
	}
	public int getNext(){
		return next;
	}
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	public void add(){
		time++;
	}
	public boolean isWorking(){
		if(next>time)
			return true;
		else
			return false;
	}
	
}
