import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
class Time implements Comparable<Time>{
	int start,end, index;
	Time(int start, int end, int index){
		this.start= start;
		this.end = end;
		this.index = index;
	}
	public int getStart() {         
	    return start;     
	  }       
	  public int getEnd() {         
	    return end;     
	  }                      
	  public int getIndex() {         
	    return index;     
	  }       
	  @Override     
	  public int compareTo(Time candidate) {          
	    return (this.getStart() < candidate.getStart() ? -1 : 
	            (this.getStart() == candidate.getStart() ? 0 : 1));     
	  }       
	  @Override     
	  public String toString() {         
	    return " start: " + this.start + ", end: " + this.end + ", index:" + this.index;     
	  } 
}

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int tc= Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			ArrayList<Time> arr = new ArrayList<Time>();
			int n= Integer.parseInt(br.readLine());
			for(int i=0;i<n;i++) {
				String[] words=br.readLine().split("\\s");
				int temp1 = Integer.parseInt(words[0]);
				int temp2 = Integer.parseInt(words[1]);
				Time obj= new Time(temp1, temp2,i);
				arr.add(obj);
				
		}
			
			Collections.sort(arr); 
//			for(int i=0;i<arr.size();i++)
//				System.out.println(arr.get(i).toString());
//			
			
			Time first=null, second=null;
			boolean c= false, j=false, b=false;
			char[] ch = new char[n];
			for(int i=0;i<n;i++) {
				if(first!=null) {
					if(first.end<=arr.get(i).start)
						c= false;
				}
				if(second!=null) {
					if(second.end<=arr.get(i).start)
						j= false;
				}
				
				if(c==false) {
					first =  arr.get(i);
					c= true;
					ch[arr.get(i).index]= 'C';
				}
				else if(j==false) {
					second =  arr.get(i);
					j= true;
					ch[arr.get(i).index]= 'J';
				}
				
				else {
					b= true;
					break;
				}
				
			}
			if(b==true)
				System.out.println("Case #"+t+": "+"IMPOSSIBLE");
			else {
			 String str = new String(ch);
		      System.out.println("Case #"+t+": "+str);}
			
	}

}
}
