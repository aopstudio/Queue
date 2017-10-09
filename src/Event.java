
public class Event {
	Job j=new Job();
	int arrival_time;
	public Job getJ() {
		return j;
	}
	public int getArrival_time() {
		return arrival_time;
	}
	public void setJ(int pages,String user) {
		this.j.setNumber_of_pages(pages);
		this.j.setUser(user);
	}
	public void setArrival_time(int arrival_time) {
		this.arrival_time = arrival_time;
	}
	
}
