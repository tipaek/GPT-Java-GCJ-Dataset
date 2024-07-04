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
          for(int i =0;i<n;i++){
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
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
          int c = 0;
          int C = 0;
          int J = 0;
          for(int i =0;i<n;i++){
            if(i==0){
              C = end[i];
              answ+="C";
            }
            else{
              boolean cc = start[i]>=C;
              boolean jj = start[i]>=J;
              if(cc){
                answ +="C";
                C = end[i];
              }
              else if(jj){
                answ+="J";
                J = end[i];
              }
              else{
                answ="IMPOSSIBLE";
                break;
              }
            }         
          }
          fvals[fcount] = answ;
          fcount++;
        }
        for(int i =0;i<test;i++){
          System.out.println("Case #"+(i+1)+": "+fvals[i]);
        }
        
        
    }
    public static int search(int[]a,int x){
        for(int i =0;i<a.length;i++){
            if(a[i]==x){
                return i;
            }
        }
        return -1;
    }
}

