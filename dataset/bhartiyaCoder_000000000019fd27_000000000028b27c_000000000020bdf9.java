/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int c = 1; c <= t; c++) {
		    int n = sc.nextInt();
		    Map<Integer, Integer> temp = new HashMap<>();
		    while(n-- > 0) {
		        temp.put(sc.nextInt(), sc.nextInt());
		    }
		    Map<Integer, Integer> map = new TreeMap<>(temp);
		    int J = 0;
		    int C = 0;
		    String output = "";
		    for(Map.Entry<Integer, Integer> obj: map.entrySet()) {
		        if(C <= obj.getKey()) {
		            C = obj.getValue();
		            output = output + 'C';
		        }
		        else
		        if(J <= obj.getKey()) {
		            J = obj.getValue();
		            output = output + 'J';
		        }
		        else {
		            output = "IMPOSSIBLE";
		            break;
		        }
		        
		    }
		    System.out.println("Case #" + c + ": " + output);
		}
	}
}
