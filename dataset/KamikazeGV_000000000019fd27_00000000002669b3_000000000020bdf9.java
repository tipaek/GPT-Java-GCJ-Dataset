import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		String output;
		ArrayList<String> allOutputs = new ArrayList<String>();
		int T;
		
		int N;
		
		Activity act;
		ArrayList<Activity> activities= new ArrayList<Activity>();
		Person cameron= new Person();
		cameron.name="C";
		cameron.occupiedUntil=0;
		
		Person jamie= new Person();
		jamie.name="J";
		jamie.occupiedUntil=0;
		
		//Create stream
		Scanner sc = new Scanner(System.in);
				
		//Reads T
		T=  Integer.parseInt( sc.next() );
		
		//Do T times
		for(int a=0; a<T; a++) {
			cameron.occupiedUntil=0;
			jamie.occupiedUntil=0;
			activities= new ArrayList<Activity>();
			output=new String();		//In order to have a different reference for each string
			output="";
			
			N= Integer.parseInt( sc.next() );
			
			//Read the N activities
			for(int b=0; b<N; b++) {
				act= new Activity();
				
				act.startTime=Integer.parseInt( sc.next() );
				act.endTime=Integer.parseInt( sc.next() );
				act.id=b;
				
				activities.add(act);
			}
			
			//Sort activities by their startTime
			Collections.sort(activities, new Comparator<Activity>() {
				  
				  public int compare(Activity a1, Activity a2) {
				      return (a1.startTime -  a2.startTime);
				  }
			});
			
			for(Activity b: activities) {
				if( b.startTime>= cameron.occupiedUntil) {
					cameron.occupiedUntil= b.endTime;
					b.executor=cameron;
				} else if(  b.startTime>= jamie.occupiedUntil) {
					jamie.occupiedUntil= b.endTime;
					b.executor=jamie;
				} else {
					output="IMPOSSIBLE";
					break;
				}
			}
			
			if(! output.equals("IMPOSSIBLE") ) {	//If assignment is possible, generate the output
				
				//Sort activities by their ids
				Collections.sort(activities, new Comparator<Activity>() {
						  
					public int compare(Activity a1, Activity a2) {
						return (a1.id -  a2.id);
					}
				});
				
				for(Activity b: activities) {
					output+=b.executor.name;
				}

			}
			
			allOutputs.add(output);
		}
		
		for(int i=1; i<allOutputs.size(); i++) {
			System.out.print("Case #"+i+": ");
			System.out.println( allOutputs.get(i-1) );
		}
		int i=allOutputs.size();
		System.out.print( "Case #"+i+": "+ allOutputs.get(i-1) );
		
		//Closes stream
		sc.close();
		
	}
}

class Activity {
	int startTime;
	int endTime;
	int id;
	Person executor;
	
}

class Person{
	int occupiedUntil;
	String name;
}