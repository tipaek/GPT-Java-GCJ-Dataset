import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[] s = new int[n];
	  int[] e = new int[n];
	  for(int j=1; j<=n; j++){
	      s[j-1] = in.nextInt();
	      e[j-1] = in.nextInt();
	  }
	  String sch = "IMPOSSIBLE";
	  if(!impossible(n,s,e))
		sch = Schedule("",s,e,n);
      System.out.println("Case #" + i + ": " + sch);
    }
  }

public static String Schedule(String sch, int[] starts, int[] ends, int n) {
		String schedule = sch;
		loop:for(int i=sch.length(); i<n; i++) {
			if(tConflict(starts,ends,schedule,'C',starts[i],ends[i])==-1) {
				schedule += 'C';
			} else if(tConflict(starts,ends,schedule,'J',starts[i],ends[i])==-1) {
				schedule += 'J';
			} else {
			    //while(tConflict(starts,ends,schedule,'J',starts[i],ends[i])!=-1)
				    //schedule = Swap(starts,ends,schedule,tConflict(starts,ends,schedule,'J',starts[i],ends[i]));
				//schedule+='J';
				schedule = "IMPOSSIBLE";
				break loop;
			}
		}
		return schedule;
	}

public static boolean impossible(int n, int[] s, int[] e) {
		boolean imp = false;
		for(int i=0; i<n-1; i++)
			for(int j=i+1; j<n; j++)
				if(tConflict(s[i],e[i],s[j],e[j]))
					for(int k=0; k<n; k++)
						if((k!=i)&&(k!=j))
							if(tConflict(s[k],e[k],s[i],e[i])&&tConflict(s[k],e[k],s[j],e[j]))
								imp = true;
							
		return imp;
	}

public static int tConflict(int[] starts, int[] ends, String s, char P, int start, int end) {
			int conflict = -1;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)==P) {
					if(((start>starts[i])&&(start<ends[i]))||((end>starts[i])&&(end<ends[i])))
						conflict = i;
				}
			}
			return conflict;
		}
		
public static boolean tConflict(int s1, int e1, int s2, int e2) {
		boolean conflict = false;
		if((((s1>s2)&&(s1<e2))||((e1>s2)&&(e1<e2)))||(((s2>s1)&&(s2<e1))||((e2>s1)&&(e2<e1))))
			conflict = true;
		return conflict;
	}
	
	public static int tConflict(int[] starts, int[] ends, String s) {
		int conflict = -1;
		loop2:for(int i=0; i<s.length(); i++) {
			conflict = tConflict(starts,ends,s,s.charAt(i),starts[i],ends[i]);
			if(conflict != -1)
				break loop2;
		}
		return conflict;
	}
	
	public static String Swap(int[] s, int[] e, String sch, int ind) {
		String output = "";
		output += sch.substring(0,ind);
		if(sch.charAt(ind)=='C')
			output+='J';
		else
			output+='C';
		output+= sch.substring(ind+1,sch.length());
		if(tConflict(s,e,output)!=-1)
			return Swap(s,e,output,tConflict(s,e,output));
		else
			return output;
	}
    
}