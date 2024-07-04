import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		FastIO fio = new FastIO();
		int T = fio.nextInt();
		for (int t = 0; t < T; t++) {
			int caseNum = t + 1;
			int N = fio.nextInt();
			if (N == 501) {
				fio.println("Case #" + caseNum + ":");
				for (int i = 1; i < 500; i++) {
					fio.println(i + " 1");
				}
				fio.println("500 2");
			} else {
				fio.println("Case #" + caseNum + ":");
				for (int i = 1; i <= N; i++) {
					fio.println(i + " 1");
				}
			}
		}
		fio.close();
	}
}
class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
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
            catch (IOException  e) 
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