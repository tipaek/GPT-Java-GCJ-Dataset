import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner s1 = new Scanner(System.in);
		int T = Integer.parseInt(s1.nextLine());	
	    int[][] matrix = new int[101][101];
	    for(int i = 1; i <= T; i++)
	    {
	        String s = s1.nextLine();
	        String o = "";
	        int curr = 0;
	        for(int k = 0; k < s.length(); k++)
	        {
	            int n = (s.charAt(k)) - '0';
	            while(n > curr)
	            {
	                o += "("; 
	                curr++;
	            }
	            while(n < curr)
	            {
	                o += ")"; 
	                curr--;
	            }
	            o += s.charAt(k);
	        }
            while(curr > 0)
            {
                o += ")";
                curr--;
            }
	        System.out.println("Case #" + i + ": " + o);
	    }
	}

}
