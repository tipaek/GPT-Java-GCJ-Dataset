
import java.math.BigInteger; 
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int te = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= te; ++i) {
      int n = in.nextInt();
      int m = in.nextInt();
      int com[][] = new int [n][m];
      for(int j = 0;j<n;j++){
        for(int k = 0;k<m;k++){
            com[j][k] = in.nextInt();
        }    
      }
      boolean set = true;
      BigInteger interest = new BigInteger("0");
    
      while(set){
          set = false;
          int temp[][]=new int[n][m];
          for(int j = 0;j<n;j++){
            for(int k = 0;k<m;k++){
                if(com[j][k]==0)continue;
                int x = j,y=k-1,l=0,r=0,t=0,d=0,count=0;
                while(y>=0){
                    if(com[x][y]!=0){
                        l = com[x][y];
                        count++;
                        break;
                    }
                    y--;
                }
                x=j-1;y=k;
                while(x>=0){
                    if(com[x][y]!=0){
                        t = com[x][y];
                        count++;
                        break;
                    }
                    x--;
                }
                x=j+1;y=k;
                while(x<n){
                    if(com[x][y]!=0){
                        d = com[x][y];
                        count++;
                        break;
                    }
                    x++;
                }
                x=j;y=k+1;
                while(y<m){
                    if(com[x][y]!=0){
                        r = com[x][y];
                        count++;
                        break;
                    }
                    y++;
                }
                
                temp[j][k]=com[j][k];
                if(count>0){
                    float avg = (float)(t+d+l+r)/(float)count;
                    if(avg>temp[j][k]){
                        temp[j][k]=0;
                        set=true;
                    }
                }
                interest = interest.add(BigInteger.valueOf(com[j][k]));
            }    
        }
        com=temp.clone();
      }
      System.out.println("Case #" + i + ": " + interest);
    }
  }
} 