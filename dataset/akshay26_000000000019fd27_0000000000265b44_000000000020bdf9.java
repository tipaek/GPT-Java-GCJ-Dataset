import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Arrays; 
import java.util.HashMap; 
import java.util.Scanner; 
import java.util.StringTokenizer;

/*from w  ww .j a  va  2 s .  c  o m*/
class Name implements Comparable<Name> {
  private int firstName;
  private int lastName;

  public Name(int firstName, int lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public int getFirstName() {
    return firstName;
  }

  public int getLastName() {
    return lastName;
  }

  @Override
  public int compareTo(Name otherName) {
    if (this.firstName<otherName.firstName) {
      return this.lastName - otherName.lastName;
    } else {
      return this.firstName-otherName.firstName;
    }
  }
}

public class Solution {
  public static void main(String[] args) {
     	FastReader sc=new FastReader(); 
     	int test=sc.nextInt();
     	for(int t=1;t<=test;t++){
     	    int n=sc.nextInt();
     	   	Name[] time=new Name[n];  
     	   	String inp[]=new String[n];
     	   	for(int i=0;i<n;i++) {
     	   	    time[i]=new Name(sc.nextInt(),sc.nextInt());
     	   	    inp[i]=Integer.toString(time[i].getFirstName())+" "+Integer.toString(time[i].getLastName());
     	   	}
     	
    boolean flag=false;
    List<Name> times = new ArrayList<Name>(Arrays.asList(time));

    Collections.sort(times);
    
    HashMap<String,String> map=new HashMap<>();
    int j=0;
    int c=0;
    for (Name nn : times) {
     int s=nn.getFirstName();
     int e=nn.getLastName();
    
      if(c<=s) {
           map.put(Integer.toString(s)+" "+Integer.toString(e),"C");
         c=e;
     }
      else if(j <= s) {
         map.put(Integer.toString(s)+" "+Integer.toString(e),"J");
         j=e;
     }
     else {
         flag=true;
         break;
     }
    }
    
    if(flag)
    System.out.println("Case #"+t+": IMPOSSIBLE");
    else{
        System.out.print("Case #"+t+": ");
        for(int i=0;i<n;i++)
        System.out.print(map.get(inp[i]));
        System.out.println();
    }
  }}
  
  	static class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 

		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 

		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 

		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 
		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	} 
}

