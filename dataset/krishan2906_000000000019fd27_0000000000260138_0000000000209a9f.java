import java.util.*;
import java.io.*;

public class Solution{
    static String ans;
    public static void main(String[] args){
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        for(int te=1;te<=t;te++){
            String s=sc.next();
            ans="";
            int st=s.charAt(0)-'0';
            int nd='0'-s.charAt(s.length()-1);
            print(st);
            ans+=s.charAt(0);
            for(int i=1;i<s.length();i++){
                print(s.charAt(i)-s.charAt(i-1));
                ans+=s.charAt(i);
            }
            print(nd);
            System.out.println("Case #" + te + ": " +ans);
        }
    }

    public static void print(int n){
        if(n>0) for(int i=0;i<n;i++){
            ans+='(';
        }
        else {
            n=Math.abs(n);
            for(int i=0;i<n;i++){
                ans+=')';
            }
        }
    }



    public static boolean prime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }


    static int gcd(int a, int b) 
	{ 
	if (b == 0) 
		return a; 
	return gcd(b, a % b); 
	} 
}


class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new
                 InputStreamReader(System.in)); 
    } 
  
    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e){ 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 
  
    int nextInt(){ 
        return Integer.parseInt(next()); 
    } 
  
    long nextLong(){ 
        return Long.parseLong(next()); 
    }
  
    double nextDouble(){ 
        return Double.parseDouble(next()); 
    }
  
    String nextLine(){ 
        String str = ""; 
        try{ 
            str = br.readLine(); 
        }
        catch (IOException e){ 
            e.printStackTrace(); 
        }
        return str; 
    }
}