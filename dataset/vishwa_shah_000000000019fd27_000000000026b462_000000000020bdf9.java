import java.util.*;
import java.io.*;

public class Schedule {
	
	private class time {
		int index;
		int stime;
		int etime;
		
		time(int index, int stime, int etime){
			this.index = index;
			this.stime = stime;
			this.etime = etime;
		}
		
		int getIndex(){
			return index;
		}
		
		int getstime(){
			return stime;
		}
		
		int getetime(){
			return etime;
		}
	}
	
	private class StartTimeComp implements Comparator<time>{
		 
	    @Override
	    public int compare(time e1, time e2) {
	        if(e1.getstime() > e2.getstime()){
	            return 1;
	        } else {
	            return -1;
	        }
	    }
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCase = scanner.nextInt();
		for(int t =1; t<=testCase ; t++){
			Schedule schedule = new Schedule();
			TreeSet<time> sorted = new TreeSet<time>(schedule.new StartTimeComp());
			int length = scanner.nextInt();
			boolean isPossible = true;
			for(int l=1 ; l<=length; l++){
				int stime = scanner.nextInt();
				int etime = scanner.nextInt();
				time s = schedule.new time(l, stime, etime);
				sorted.add(s);
			}
			Stack<time> c = new Stack<time>();
			Stack<time> j = new Stack<time>();
			Iterator<time> itr=sorted.iterator();  
			  while(itr.hasNext()){ 
				  time st = itr.next();
				  if(c.size() == 0 || c.peek().getetime() <= st.getstime()){
						c.push(st);
						continue;
					}
				  if(j.size() == 0 || j.peek().getetime() <= st.getstime()){
					  j.push(st);
					  continue;
				  }
				  isPossible = false;
				  break;
			  }  
			  if(isPossible){
				 char[] finalList = new char[length];
				 while(!(c.size()==0) || !(j.size()== 0)){ 
					 if(!(c.size()==0)){
						 finalList[c.pop().getIndex() -1] = 'C';
					 }
					 if(!(j.size()==0)){
						 finalList[j.pop().getIndex() - 1] = 'J';
					 }
				 }
				 System.out.print("Case #" + t + ":");
				 for(char fl : finalList){
					 System.out.print(" " + fl); 
				 }
				 System.out.println("");
			  }else{
				  System.out.println("Case #" + t + ": IMPOSSIBLE");
			  }
		}
	}

}
