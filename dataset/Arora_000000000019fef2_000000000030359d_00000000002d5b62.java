import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
class Solution{//PRACTICE
    public static void main(String args[]){
        FastScanner sc=new FastScanner(System.in);
        int t=sc.nextInt();
        for(int p1=0;p1<t;p1++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int a[]=new int[32];
            int b[]=new int[32];
            int ns=1,ew=1;
            if(x<0){
                x=Math.abs(x);
                ew=-1;
            }
            if(y<0){
                y=Math.abs(y);
                ns=-1;
            }
            String x1=Integer.toBinaryString(x);
            String y1=Integer.toBinaryString(y);
            int n1=x1.length();
            int n2=y1.length();
            int k=31;
            for(int i=n1-1;i>=0;i--){
                a[k]=x1.charAt(i)-'0';
                k--;
            }
            k=31;
            for(int i=n2-1;i>=0;i--){
                b[k]=y1.charAt(i)-'0';
                k--;
            }
            int flag=0;
            for(int i=31;i>=0;i--){
                if(a[i]!=b[i]){
                    continue;
                }
                else{
                    if(i==31){
                        flag=1;
                        break;
                    }
                    else if(a[i]==1){
                        if(a[i+1]==1){
                            a[i+1]=-1;
                            for(int j=i;j>=0;j--){
                                if(a[j]==1){
                                    a[j]=0;
                                }
                                else{
                                    a[j]=1;
                                    break;
                                }
                            }
                        }
                        else if(b[i+1]==1){
                            b[i+1]=-1;
                            for(int j=i;j>=0;j--){
                                if(b[j]==1){
                                    b[j]=0;
                                }
                                else{
                                    b[j]=1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            int val=-1;
            for(int i=0;i<32;i++){
                if(a[i]==1 || b[i]==1){
                    val=i;
                    break;
                }
            }
            for(int i=31;i>=val;i--){
                if(a[i]!=b[i]){
                    continue;
                }
                else{
                    if(i==31){
                        flag=1;
                        break;
                    }
                    else if(a[i]==0){
                        if(a[i+1]==1){
                            a[i+1]=-1;
                            a[i]=1;
                        }
                        else if(b[i+1]==1){
                            b[i+1]=-1;
                            b[i]=1;
                        }
                    }
                    else if(a[i]==1){
                        if(a[i+1]==1){
                            a[i+1]=-1;
                            for(int j=i;j>=0;j--){
                                if(a[j]==1){
                                    a[j]=0;
                                }
                                else{
                                    a[j]=1;
                                    break;
                                }
                            }
                        }
                        else if(b[i+1]==1){
                            b[i+1]=-1;
                            for(int j=i;j>=0;j--){
                                if(b[j]==1){
                                    b[j]=0;
                                }
                                else{
                                    b[j]=1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(flag==1){
                System.out.println("Case #"+(p1+1)+": IMPOSSIBLE");
            }
            else{
                String ans="";
                for(int i=31;i>=0;i--){
                    if(a[i]*ew==-1){
                        ans=ans+"W";
                    }
                    else if(a[i]*ew==1){
                        ans=ans+"E";
                    }
                    else if(b[i]*ns==-1){
                        ans=ans+"S";
                    }
                    else if(b[i]*ns==1){
                        ans=ans+"N";
                    }
                    else{
                        break;
                    }
                }
                System.out.println("Case #"+(p1+1)+": "+ans);
            }
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() { 
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

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}