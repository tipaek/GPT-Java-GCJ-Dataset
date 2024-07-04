import java.util.*;
import java.io.*;






public class Solution{
	static class cases{
		Integer number;
		String  string;
		public cases(Integer number,String string){
			this.number=number;
			this.string=string;
			
		}
		public  Integer getNumber() {
			return this.number;
		}
		public String getString() {
			return this.string;
		}
		
	}
	 static class Person {
		       String name;
		       ArrayList<Activity>arr=new ArrayList<Activity>();
		       public Person(String name) {
		    	   this.name=name;
		       }
     public ArrayList<Activity> getArray(){
    	 return this.arr;
     }
     public void SetPerson(String name) {
    	 this.name=name;
     }
     public String getPerson() {
    	 return this.name;
     }
     public boolean Available( Activity act) {
    	 Integer StartTime=act.getStart();
    	 Integer EndTime=act.getEnd();
    	 boolean bool=true;
    	 ArrayList<Activity>array=getArray();
    	 for(int i=0; i<array.size();++i) {
    		 Activity tmp=array.get(i);
    		 if(StartTime<tmp.getStart() && StartTime<tmp.getEnd() && EndTime>tmp.getStart()&& EndTime<tmp.getEnd()) {
    			 bool=false;
    			 break;
    		 }
    		 if(StartTime>tmp.getStart() && StartTime<tmp.getEnd() && EndTime>tmp.getStart()&& EndTime<tmp.getEnd()) {
    			 bool=false;
    			 break;
    		 }
    		 if(StartTime>tmp.getStart() && StartTime<tmp.getEnd() && EndTime>tmp.getStart()&& EndTime>tmp.getEnd()) {
    			 bool=false;
    			 break;
    		 }
    		 if(StartTime==tmp.getStart() && StartTime<tmp.getEnd() && EndTime>tmp.getStart()&& EndTime<tmp.getEnd()) {
    			 bool=false;
    			 break;
    		 }
    		 if(StartTime==tmp.getStart() && StartTime<tmp.getEnd() && EndTime>tmp.getStart()&& EndTime>tmp.getEnd()) {
    			 bool=false;
    			 break;
    		 }
    	 }
    	 return bool;
    	 
     }
     public void AssignTask(Activity act) {
    	 if(Available(act)) {
    		 this.arr.add(act);
    	 }
     }
     
	 
	 
	}
	 static class Activity{
		 Integer no_activity;
		 Integer StartTime;
		 Integer EndTime;
		 Person  person=new Person("no");
		 public Activity(Integer no_activity, Integer StartTime, Integer EndTime) {
			 this.no_activity=no_activity;
			 this.StartTime=StartTime;
			 this.EndTime=EndTime;
		 }
		 public int getActivity() {
			 return this.no_activity;
		 }
		 public int getStart() {
			 return this.StartTime;
		 }
		 public int getEnd() {
			 return this.EndTime;
		 }
		 public void setPerson(String person) {
			 this.person=new Person(person);
		 }
		 public String getPerson() {
			return this.person.getPerson();
		 }
	 }
	
	public static void main (String args []) {
      // Scanner in= new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	   Scanner in= new Scanner(System.in);
		/*T is the number of test case*/
		String T=in.nextLine();
		String N;
		String act;
		cases []caseArray=new cases[Integer.parseInt(T)];
		for(int i=0; i<Integer.parseInt(T); i++) {
		N=in.nextLine();
		Person C=new Person("C");
		Person J=new Person("J");
		String CASES="";
	    Activity [] arr=new Activity [Integer.parseInt(N)];
			for(int j=1; j<=Integer.parseInt(N);j++) {
			 act=in.nextLine();
			 String [] tmp=act.split(" ");
			 Activity current=new Activity(j,Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]) );
					if(C.Available(current)) {
						C.AssignTask(current);
						current.setPerson("C");
						CASES=CASES+"C";
					}
					else  {
						if(J.Available(current)) {
							J.AssignTask(current);
							current.setPerson("J");
							CASES=CASES+"J";
						}
					}
					
				
						
			
			
				
			}
			int check=C.getArray().size()+J.getArray().size();
			if(check==Integer.parseInt(N)) {
				Integer k=i+1;
				cases A=new cases(k,CASES);
				caseArray[i]=A;
			}
			else {
				String c="IMPOSSIBLE";
				Integer k=i+1;
				cases A=new cases(k,c);
				caseArray[i]=A;
			}
			
			
			
		}
		for(Integer i=0; i<caseArray.length; i++){
			cases tmp=caseArray[i];
			Integer number=tmp.getNumber();
			
			System.out.println("Case"+" "+"#"+number.toString()+":"+" "+tmp.getString());
		}
		
			  
			 
		  
		
		  
		  
		
		
        in.close();
        
   
   }


}    
        

