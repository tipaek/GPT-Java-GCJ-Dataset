/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Pair{
    int st, en;
    Pair(int st, int en){
        this.st = st;
        this.en = en;
    }
}

class sortBySt implements Comparator<Pair> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Pair a, Pair b) 
    { 
        return a.st - b.st; 
    } 
} 

class Solution {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int i = 1;
		while(i<=t) {
		    int n = s.nextInt();
		    int j = 1;
		    ArrayList<Pair> ar = new ArrayList<Pair>();
		    while(j<=n){
		        ar.add(new Pair(s.nextInt(), s.nextInt()));
		        j++;
		    }
		    Collections.sort(ar, new sortBySt());
		    j = 0;
		    String res = "";
		    Pair cc = new Pair(-1, -1);
		    Pair jj = new Pair(-1, -1);
		    while(j< ar.size()){
		        Pair cur = ar.get(j);
		        if (cur.st >=  cc.en){ 
		            res = res + 'C';
		            cc = cur;
		        }
		        else if (cur.st >= jj.en){
		            res = res + 'J';
		            jj = cur;
		        }
		        else{
		            res = "IMPOSSIBLE";
		            break;
		        }
		        j++;
		    }
		    System.out.println("Case #"+i+": "+ res);
		    i++;
		}
	}
}