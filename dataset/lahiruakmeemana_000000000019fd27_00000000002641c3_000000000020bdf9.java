import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Parent{
	private String name;
	private List<Integer> start;
	private List<Integer> end;
	
	public Parent(String name){
		this.name=name;
		start=new ArrayList<Integer>();
		end=new ArrayList<Integer>();
		start.add(0);
		end.add(0);
	}
	public boolean addJob(Integer s,Integer e){
		int last=end.get(end.size()-1);
		if (s>=last){
			start.add(s);
			end.add(e);
			return true;
		}
		return false;
		
		
	}
}
public class test{
	public static void main(String [] args){
		Scanner in =new Scanner(System.in);
		int cases=in.nextInt();
		List<String> output=new ArrayList<String>();
		ArrayList<ArrayList<Integer>> start = new ArrayList<ArrayList<Integer>>();
		for (int i=0;i<cases;i++){
			int jobs=in.nextInt();
			start.clear();
			
			for (int k=0;k<jobs;k++){
				ArrayList<Integer> temp=new ArrayList<Integer>();
				temp.add(in.nextInt());
				temp.add(in.nextInt());
				start.add(temp);
				
			}
			String o=get(start,jobs);
			System.out.println("Case #"+Integer.toString(i+1)+": "+o);
		}
	}
	
	public static String get(ArrayList<ArrayList<Integer>> start,int jobs ){
		Parent c=new Parent("C");
		Parent j=new Parent("J");
		String out="";
		start.sort((x,y) -> Integer.compare(x.get(0), y.get(0)));

		
		for (int k=0;k<jobs;k++){ 
			
			if (c.addJob(start.get(k).get(0),start.get(k).get(1))) out+="C";
			else if (j.addJob(start.get(k).get(0),start.get(k).get(1)))out+="J";
			else {
				out="IMPOSSIBLE";}
		}
		
		return out;
	}
	
}
