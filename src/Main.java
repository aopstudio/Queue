
public class Main {
	public static void main(String[] args){
		Fifo si=new Fifo();
		si.fileLoader("arbitrary.run");
		//si.display();
		si.simulate();
	}
}
