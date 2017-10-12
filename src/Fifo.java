import java.io.FileWriter;
import java.io.IOException;

public class Fifo extends Simulator{
	Queue<Event> wait=new Queue<Event>();
	public void simulate(){
		System.out.println("FIFO Simulation\n");
		if(workload.isEmpty()==false){
			Event work=workload.deQueue();
			System.out.println("Arriving: "+work.getJ().number_of_pages+" pages from platypus at "+work.getArrival_time()+" seconds");
			System.out.println("Servicing: "+work.getJ().number_of_pages+" pages from platypus at "+work.getArrival_time()+" seconds");
		}
		while(workload.isEmpty()==false){
			
		}
	}
	
	private void writeFile(String filename, String content)
			throws IOException {

			FileWriter writer=new FileWriter(filename);
			writer.write(content);
			writer.flush();
			writer.close();
			
		}
}
