import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.valueOf(in.readLine().trim()); 
    for (int i = 0; i < t; i++) {
    	//start of test case
    	int n = Integer.valueOf(in.readLine().trim());
    	ArrayList<Activity> todo = new ArrayList<Activity>();
    	for(int j = 0; j < n; j++) {
    		//construct Activity objects with information
    		String[] descript = in.readLine().trim().split(" ");
    		int start = Integer.valueOf(descript[0]);
    		int end = Integer.valueOf(descript[1]);
    		todo.add(new Activity(start,end,j));
    	}
    	Collections.sort(todo, new Comparator<Activity>() {
    	        public int compare(Activity s1, Activity s2) {
    	            return s1.getStart().compareTo(s2.getStart());
    	        }
    	 });
    	//start coloring
    	Boolean impossible = false;
    	for(int k =0;k<todo.size();k++) {
    		if(k==0) todo.get(0).assign("C");
    		if(k==1) {
    			if(todo.get(0).getEnd() <= todo.get(1).getStart()) todo.get(1).assign("C"); 
    			else todo.get(1).assign("J");
    		} else { 
    		
    		Boolean c_avail = true;
    		Boolean j_avail = true;
    		for(int l=k-1;l>=0;l--) {
    			if(todo.get(l).getEnd() > todo.get(k).getStart()) {
    				if(todo.get(l).getAssign().equals("C")) c_avail = false;
    				else j_avail = false;
    			}
    		}
    		if(!c_avail && !j_avail) impossible = true;
    		else if(c_avail && j_avail) todo.get(k).assign("C");
    		else if(!c_avail) todo.get(k).assign("J");
    		else todo.get(k).assign("C");
			if(impossible) break;
    		}
    	}
    	//end of assigment
      	Collections.sort(todo, new Comparator<Activity>() {
	        public int compare(Activity s1, Activity s2) {
	            return s1.getPlace().compareTo(s2.getPlace());
	        }
      	});
      	String assemble = "";
      	for(Activity a: todo) {
      		assemble = assemble + a.getAssign();
      	}
    	
    	
    	
    	if(impossible) System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
    	else System.out.println("Case #"+(i+1)+": "+assemble);

    	
    	 //end of test case  	
    }
   
  }
    
}
  
class Activity{
	int start;
	int end;
	String person="";
	int place;
	Activity(int s, int e, int p){
		start = s;
		end = e;
		place = p;
	}
	Integer getStart() {
		return start;
	}
	Integer getEnd() {
		return end;
	}
	Integer getPlace() {
		return place;
	}
	String getAssign() {
		return person;
	}
	void assign(String name) {
		person = name;
	}
	
}
