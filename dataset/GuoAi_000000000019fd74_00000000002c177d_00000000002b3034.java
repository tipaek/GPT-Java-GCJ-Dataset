import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		FastIO fio = new FastIO();
		int T = fio.nextInt();
		for (int t = 0; t < T; t++) {
			int caseNum = t + 1;
			int N = fio.nextInt();
			ArrayList<String> strings = new ArrayList<>();
			int maxLen = 0;
			String maxString = "";
			Boolean flag = true;
			for (int i = 0; i < N; i++) {
				String str = fio.nextLine();
				strings.add(str.substring(1, str.length()));
				if (str.length() > maxLen) {
					maxLen = str.length();
					maxString = str;
				}
			}
			for (int i = 0; i < N; i++) {
				if (!maxString.contains(strings.get(i))) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				fio.println("Case #" + caseNum + ": *");
			} else {
				fio.println("Case #" + caseNum + ": " + maxString.substring(1, maxString.length()));
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