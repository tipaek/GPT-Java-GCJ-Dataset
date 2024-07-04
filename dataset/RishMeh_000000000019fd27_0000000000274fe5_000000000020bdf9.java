/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Pair{
    int st, en, ind; char as;
    Pair(int st, int en, char as, int ind){
        this.st = st;
        this.en = en;
        this.as = as;
        this.ind = ind;
    }
}

class sortByIn implements Comparator<Pair> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Pair a, Pair b) 
    { 
        return a.ind - b.ind; 
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
		        ar.add(new Pair(s.nextInt(), s.nextInt(), 'x',j-1));
		        j++;
		    }
		    Collections.sort(ar, new sortBySt());
		    j = 0;
		    String res = "";
		    Pair cc = new Pair(-1, -1,'C', -1);
		    Pair jj = new Pair(-1, -1, 'J', -1);
		    while(j< ar.size()){
		        Pair cur = ar.get(j);
		        if (cur.st >=  cc.en){ 
		            cur.as = cc.as;
		            cc = cur;
		        }
		        else if (cur.st >= jj.en){
		            cur.as = jj.as;
		            jj = cur;
		        }
		        else{
		            res = "IMPOSSIBLE";
		            break;
		        }
		        j++;
		    }
		    if (res != "IMPOSSIBLE"){
		        Collections.sort(ar, new sortByIn());
		        j = 0;
		        while(j<ar.size())
		            res = res + ar.get(j++).as;
		    }
		    System.out.println("Case #"+i+": "+ res);
		    i++;
		}
	}
}