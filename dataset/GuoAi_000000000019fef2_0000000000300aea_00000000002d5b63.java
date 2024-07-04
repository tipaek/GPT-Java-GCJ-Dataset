import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		FastIO fio = new FastIO();
		int T = fio.nextInt(), A = fio.nextInt(), B = fio.nextInt();
		for (int t = 0; t < T; t++) {
			Boolean flag = false;
            if (!flag) {
                for (int x = -5; x <= 5; x++) {
                    for (int y = -5; y <= 5; y++) {
                        System.out.println(x+" "+y);
                        if (fio.nextLine() == "CENTER") {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                } 
            }
		}
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