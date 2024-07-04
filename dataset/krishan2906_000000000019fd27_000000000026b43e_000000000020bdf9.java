import java.util.*;
import java.io.*;

public class Solution{
    static String ans;
    public static void main(String[] args){
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        for(int te=1;te<=t;te++){
            int n=sc.nextInt();
            int[][] tsk=new int[n][2];
            for(int i=0;i<n;i++){
                tsk[i][0]=sc.nextInt();tsk[i][1]=sc.nextInt();
            }
            char[] ans=new char[n];
            int lst_tm=0;
            int str_tm=Integer.MAX_VALUE;
            //task for Cameron
            for(int i=0;i<n;i++){
                if(lst_tm<=tsk[i][0] || str_tm>=tsk[i][1]){
                    ans[i]='C';
                    str_tm=Math.min(str_tm,tsk[i][0]);
                    lst_tm=Math.max(lst_tm,tsk[i][1]);
                }
            }

            //task for Jamie
            str_tm=Integer.MAX_VALUE;lst_tm=0;
            for(int i=0;i<n;i++){
                if(ans[i]!='C') {if(lst_tm<=tsk[i][0] || str_tm>=tsk[i][1]){
                    ans[i]='J';
                    str_tm=Math.min(str_tm,tsk[i][0]);
                    lst_tm=Math.max(lst_tm,tsk[i][1]);
                }}
            }

            //test if all task are completed
            int cnt=0;
            for(int i=0;i<n;i++){
                if(ans[i]=='J' || ans[i]=='C'){
                    cnt++;
                }
            }
            if(cnt==n){
            System.out.print("Case #" + te + ": " );
            for(int i=0;i<n;i++) System.out.print(ans[i]);}
            else{
                System.out.print("Case #" + te + ": IMPOSSIBLE" );
            }
            System.out.println();
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