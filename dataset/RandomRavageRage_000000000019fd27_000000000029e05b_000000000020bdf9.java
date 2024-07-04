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
    	
    	for(int i = 0; i < n; i++){
    		int overlaps = 0;//count the number of overlaps
    		Activity a = activities[i];
    		for(int j = i - 1; j >= 0; j--){
    			Activity b = activities[j];
    			if(b.end > a.start){ //test overlap
    				//overlaps, add to sum and check if it is impossible
    				if(++overlaps >= 2){
    					System.out.println("Case #" + x + ": IMPOSSIBLE");
    				}
    				//check for previous assignment
    				if(b.assignment == 'C'){
    					a.assignment = 'J';
    				}else if(b.assignment == 'J'){
    					a.assignment = 'C';
    				}
    			}
    		}
    		//if no assignment, then give assignment
    		if(a.assignment == '_'){
    			a.assignment = 'C';
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