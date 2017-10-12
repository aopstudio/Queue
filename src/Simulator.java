import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Simulator {
	int seconds_per_page=2;
	Queue<Event> workload=new Queue<Event>();
	
	public void fileLoader(String filename){
		FileReader reader = null;
		try {
			reader = new FileReader(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner in=new Scanner(reader);
		String line;
		while(in.hasNextLine()){
			line=in.nextLine();
			loadWorkLoad(line);
		}
		in.close();
	}
	public void loadWorkLoad(String line){
		StringTokenizer st=new StringTokenizer(line," ",false);
		Event work=new Event();
		work.setArrival_time(Integer.parseInt(st.nextToken()));
		work.setJ(Integer.parseInt(st.nextToken()), st.nextToken());
		workload.enQueue(work);
	}
	
	/*public void display(){
		Event ev=new Event();
		while(workload.getFront()!=null){
			ev=workload.deQueue();
			System.out.println(ev.getArrival_time()+" "+ev.getJ().getNumber_of_pages()+" "+ev.getJ().getUser());
		}
	}*/
	//测试文件是否成功读入并填入栈中
}
