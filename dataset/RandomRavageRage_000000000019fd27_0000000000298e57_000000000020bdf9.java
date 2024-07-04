import java.util.*;
import java.io.*;
public class Solution {
	public static BufferedReader br;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++){
        	//each case
        	testCase(i);
        }
        br.close();
    }
    
    public static void testCase(int x) throws NumberFormatException, IOException{
    	int n = Integer.parseInt(br.readLine());
    	
    	Activity[] activities = new Activity[n];
    	for(int i = 0; i < n; i++){
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		activities[i] = new Activity(i, start, end);
    	}
    	
    	//need to first sort activities
    	Arrays.sort(activities);
    	
    	//compare all activities
    	for(int i = 0; i < n; i++){
    		int overlapsA = 0;
    		int overlapsB = 0;
    		for(int j = i + 1; j < n; j++){
    			//test if they overlap
    			Activity a1 = activities[i];
    			Activity a2 = activities[j];
    			if((a2.start < a1.start && a1.start < a2.end) ||
    					(a2.start < a1.end && a1.end < a2.end)){
    				overlapsA++;
    				if(overlapsA >= 2){
    					System.out.println("Case #" + x + ": IMPOSSIBLE");
    					return;
    				}else{
    					if(a1.assignment == a2.assignment){
    						//both not assigned yet, make assignment
    						a1.assignment = 'C';
    						a2.assignment = 'J';
    					}else{
    						//make assignment
    						if(a1.assignment == 'J'){
    							a2.assignment = 'C';
    						}else if(a1.assignment == 'C'){
    							a2.assignment = 'J';
    						}else if(a2.assignment == 'J'){
    							a1.assignment = 'C';
    						}else if(a2.assignment == 'C'){
    							a1.assignment = 'J';
    						}
    					}
    				}
    			}else if((a1.start < a2.start && a2.start < a1.end) ||
    					(a1.start < a2.end && a2.end < a1.end)){
    				overlapsB++;
    				if(overlapsB >= 2){
    					System.out.println("Case #" + x + ": IMPOSSIBLE");
    					return;
    				}else{
    					if(a1.assignment == a2.assignment){
    						//both not assigned yet, make assignment
    						a1.assignment = 'C';
    						a2.assignment = 'J';
    					}else{
    						//make assignment
    						if(a1.assignment == 'J'){
    							a2.assignment = 'C';
    						}else if(a1.assignment == 'C'){
    							a2.assignment = 'J';
    						}else if(a2.assignment == 'J'){
    							a1.assignment = 'C';
    						}else if(a2.assignment == 'C'){
    							a1.assignment = 'J';
    						}
    					}
    				}
    			}else{
    				if(a1.assignment == '_'){
    					a1.assignment = 'C';
    				}
    				if(a2.assignment == '_'){
    					a2.assignment = 'C';
    				}
    			}
    		}
    	}
    	
    	//unsort
    	char[] characters = new char[n];
    	for(int i = 0; i < activities.length; i++){
    		Activity a = activities[i];
    		characters[a.id] = a.assignment;
    	}
    	
    	//build string
    	String ret = "";
    	for(int i = 0; i < characters.length; i++){
    		ret += characters[i];
    	}
        
        System.out.println("Case #" + x + ": " + ret);
    }
}

class Activity implements Comparable<Activity>{
	public int start;
	public int end;
	public int id;
	public char assignment = '_';
	public Activity(int id, int start, int end){
		this.id = id;
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Activity other) {
		return this.start - other.start;
	}
}