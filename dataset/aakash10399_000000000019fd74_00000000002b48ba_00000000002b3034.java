/*

    Aakash Pahwa ( @aakash10399 )

    Hi there! :D

    BigInteger.valueOf(1235).isProbablePrime(1)
    BigInteger.valueOf(3).gcd( BigInteger.valueOf(5) )
    Collections.rotate()/frequency()
    Arrays.sort()
    Collections.sort()
    Arrays.binarySearch()
    Collections.binarySearch()
    Arrays.copyOf() 
    Arrays.copyOfRange()
    Collections.copy()
    Collections.rotate()
    Collections.frequency()
    Stack, LinkedList, HashMap, HashSet, TreeMap
    Math.log10(N)
    Math.floor(N)

*/


import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.*;
import java.text.*;

public class Solution{

    public static void main(String[] args){
        InputReader in = new InputReader();
        int t = in.nextInt();
        for( int T = 1 ; T <= t ; T++ ){
            String ans = "";
            int n = in.nextInt();
            String arr[] = new String[n];
            String prefs[] = new String[n];
            String suffs[] = new String[n];
            for( int i = 0 ; i < n ; i++ ) arr[i] = in.next();
            for( int i = 0 ; i < n ; i++ ){
                int x = arr[i].indexOf('*');
                int y = arr[i].lastIndexOf('*');
                prefs[i] = arr[i].substring(0,x);
                suffs[i] = arr[i].substring(y+1);
            }
            Arrays.sort(prefs, (a,b)->Integer.compare(b.length(),a.length()));
            Arrays.sort(suffs, (a,b)->Integer.compare(b.length(),a.length()));
            boolean f = true;
            String biggestPref = prefs[0];
            String biggestSuff = suffs[0];
            for( int i = 1 ; i < n ; i++ ){
                f = f && biggestPref.startsWith( prefs[i] );
                f = f && biggestSuff.endsWith( suffs[i] );
                if(!f) break;
            }
            if(!f) ans = "*";
            else{
                ans = biggestPref;
                for( int i = 0 ; i < n ; i++ ){
                    arr[i] = "  " + arr[i] + "  "; 
                    String words[] = arr[i].split("\\*");
                    for( int j = 1 ; j < words.length-1 ; j++ ) ans += words[j];
                }
                ans += biggestSuff;
            }
            System.out.println( "Case #" + T + ": " + ans );
        }
    }

}

class Helper{

    static boolean[] sieve(int n) { 

        boolean primes[] = new boolean[n+1]; 

        Arrays.fill( primes , true );
          
        for(int p = 2; p*p <= n; p++)  
            if(primes[p] == true)  
                for(int i = p*p; i <= n; i += p) 
                    primes[i] = false; 
        
        return primes;
        
    }
    static long modular_exp(long x, long y, long p){  
        long ret = 1;
        x = x % p;  
        while (y > 0){
            if((y & 1)==1) 
                ret = (ret * x) % p; 
            y = y >> 1;  
            x = (x * x) % p;  
        }
        return ret; 
    }

    static long gcd(long a,long b){
        return (BigInteger.valueOf(a).gcd( BigInteger.valueOf(b) ) ).longValue();
    }
    
}

class InputReader{ 
    BufferedReader br; 
    StringTokenizer st; 
  
    public InputReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
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