import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = sc.nextInt();
        String[]fvals = new String[test];
        int fcount = 0;
        for(int hhj =0;hhj<test;hhj++){
          int n = sc.nextInt();
          int[]start = new int[n];
          int[]end = new int[n];
          int[]s = new int[n];
          int[]e = new int[n];
          for(int i =0;i<n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            start[i] = x;
            end[i] = y;
            s[i] = x;
            e[i] = y;
          }
          for(int i = 1;i<n;i++){
            int key = start[i];
            int j = i-1;
            while(j>=0 && start[j]>key){
              int x = start[j];
              int y = start[j+1];
              int xx = end[j];
              int yy = end[j+1];
              start[j+1] = x;
              start[j] = y;
              end[j+1] = xx;
              end[j] = yy;
              j-=1;
            }
          }
          String answ = "";
          String[]ans = new String[n];
          int C = 0;
          int J = 0;
          boolean imp = false;
          for(int i =0;i<n;i++){
            if(i==0){
                ans[search(e,end[i],s,start[i])] = "C";
                C = end[i];
            }
            else{
              boolean cc = start[i]>=C;
              boolean jj = start[i]>=J;
              if(cc){
                ans[search(e,end[i],s,start[i])] = "C";
                C = end[i];
              }
              else if(jj){
                ans[search(e,end[i],s,start[i])] = "J";
                J = end[i];
              }
              else{
                imp = true;
                break;
              }
            }         
          }
          for(int i =0;i<n;i++){
            answ+=ans[i];
          }
          if(imp){
            answ = "IMPOSSIBLE";
          }
          fvals[fcount] = answ;
          fcount++;
        }
        for(int i =0;i<test;i++){
          System.out.println("Case #"+(i+1)+": "+fvals[i]);
        }
    }
    public static int search(int[]a,int x,int[]b,int y){
        for(int i =0;i<a.length;i++){
            if(a[i]==x && b[i]==y){
              return i;
            }
        }
        return -1;
    }
}