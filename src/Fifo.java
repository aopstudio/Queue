import java.io.FileWriter;
import java.io.IOException;

public class Fifo extends Simulator{
	Queue<Event> wait=new Queue<Event>();
	Timer timer=new Timer();
	int latency=0;
	int total=0;
	public void simulate(){
		System.out.println("FIFO Simulation\n");
		if(workload.isEmpty()==false){
			Event work=workload.deQueue();
			total++;
			timer.setTime(work.getArrival_time());
			timer.setNext(work.getArrival_time()+work.getJ().getNumber_of_pages()*this.seconds_per_page);
			System.out.println("Arriving: "+work.getJ().number_of_pages+" pages from "+work.getJ().getUser()+" at "
			+work.getArrival_time()+" seconds");
			System.out.println("Servicing: "+work.getJ().number_of_pages+" pages from "+work.getJ().getUser()+" at "
			+work.getArrival_time()+" seconds");
		}
		while(workload.isEmpty()==false){
			
			if(workload.getFront().getArrival_time()>timer.getTime()){//workload队列的头的到达时间和当前时间不吻合
				if(timer.isWorking()==false&&wait.isEmpty()==false){
					Event work=wait.deQueue();
					System.out.println("Servicing: "+work.getJ().getNumber_of_pages()+" pages from "+work.getJ().getUser()+" at "
							+timer.getTime()+" seconds");
					latency+=timer.getTime()-work.getArrival_time();
					timer.setNext(timer.getTime()+work.getJ().getNumber_of_pages()*this.seconds_per_page);
				}//如果此时空闲而且wait队列中有内容，则把wait队列的内容推出并加入打印
				timer.add();
				continue;
			}
			if(workload.getFront().getArrival_time()==timer.getTime()){//workload队列的头的到达时间和当前时间吻合
				Event work=workload.deQueue();
				total++;
				System.out.println("Arriving: "+work.getJ().number_of_pages+" pages from "+work.getJ().getUser()+" at "
						+work.getArrival_time()+" seconds");
				if(timer.isWorking()==true){//打印机正在工作
					wait.enQueue(work);
					if(workload.isEmpty()==false&&workload.getFront().getArrival_time()!=timer.getTime())//下一个队列头的到达时间不是当前时间
						timer.add();
				}
				else{//空闲
					System.out.println("Servicing: "+work.getJ().getNumber_of_pages()+" pages from "+work.getJ().getUser()+" at "
							+timer.getTime()+" seconds");
					
					timer.setNext(timer.getTime()+work.getJ().getNumber_of_pages()*this.seconds_per_page);
					if(workload.isEmpty()==false&&workload.getFront().getArrival_time()!=timer.getTime())//下一个队列头的到达时间不是当前时间
						timer.add();
				}
			}
			
		}
		while(wait.isEmpty()==false){
			
				if(timer.isWorking()==false){
					Event work=wait.deQueue();
					System.out.println("Servicing: "+work.getJ().getNumber_of_pages()+" pages from "+work.getJ().getUser()+" at "
							+timer.getTime()+" seconds");
					latency+=timer.getTime()-work.getArrival_time();
					timer.setNext(timer.getTime()+work.getJ().getNumber_of_pages()*this.seconds_per_page);
					
				}
				else{
					timer.add();
				}
			
		}
		System.out.println();
		System.out.println("Total jobs: "+total);
		System.out.println("Aggregate latency: "+latency+" seconds");
		System.out.println("Mean latency: "+(float)latency/total+" seconds");
	}	
	private void writeFile(String filename, String content)
			throws IOException {

			FileWriter writer=new FileWriter(filename);
			writer.write(content);
			writer.flush();
			writer.close();
			
		}
}
