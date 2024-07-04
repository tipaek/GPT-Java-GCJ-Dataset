import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static boolean isTest = false;
	
       static class Pos implements Comparable<Pos>
       {
             int x;
             int y;
             String person;
             int hashCode;

             Pos(int x, int y)
             {
                this.x = x;
                this.y = y;
                person = "";
                hashCode = x + (y + ( x + 1)/2) * (y + (x + 1)/2);
             }
             public int hashCode() {
                  return hashCode;
             }

             public int compareTo(Pos a)
             {
               if (this.x < a.x) return -1;
               if (this.x > a.x) return 1;
               if (this.y < a.y) return -1;
               if (this.y > a.y) return 1;
               return 0;
             }

             public boolean equals(Object other) {
                  if (!(other instanceof Pos)) {
                    return false;
                  }
                  Pos p = (Pos) other;
                  if (this.x == p.x && this.y == p.y) return true;
                  return false;
             }           
       }
	
	public static void main(String[] args) throws Exception
	{
		
        	Scanner scan = getScanner();
        	String x = scan.nextLine();
        	int T = Integer.parseInt(x);
		for (int i = 0; i < T; i++)
		{
        		x = scan.nextLine();
        		int N = Integer.parseInt(x);
        		Pos[] output = new Pos[N];
        		Pos[] activities = new Pos[N];
			for (int j = 0; j < N; j++)
			{
				activities[j] = new Pos(scan.nextInt(), scan.nextInt());
				output[j] = activities[j];
				x = scan.nextLine();
        		}
        		Arrays.sort (activities);
        		Pos J = null;
        		Pos C = null;
        		boolean isSolved = true;
        		for (int j = 0; j < N; j++)
        		{
        			if (!isConflict(J, activities[j]))
        			{
        				J = activities[j];
        				activities[j].person="J";
        			}else if (!isConflict(C, activities[j]))
        			{
        				C = activities[j];
        				activities[j].person="C";
        			}else
        			{
        				isSolved = false;
        				break;
        			}
        			
        		}
        		if (isSolved)
        		{
        			System.out.print("Case #" + (i+1) + ": ");
        			for (int j = 0; j < N; j++)
        				System.out.print(output[j].person);
        			System.out.println();
        		}
        		else
      				System.out.println("Case #" + (i+1) + ": POSSIBLE");
        	}
	}
	
	static boolean isConflict(Pos a, Pos b)
	{
		if (a == null || b == null) return false;
		
		if (a.x > b.x)
		{
			Pos t = a;
			a = b;
			b = t;
		}
		
		if (a.y <= b.x) return false;
		return true;
	}
	
	static Scanner getScanner() throws Exception
	{
		if (isTest)
			return new Scanner(new File("input.txt"));
		else
			return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
        
        static void debug(String s)
        {
        	if(isTest)
        		System.out.println(s);
        }
}

  