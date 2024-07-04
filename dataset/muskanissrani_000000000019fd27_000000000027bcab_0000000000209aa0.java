import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++){
          int w=s.nextInt(),k=0,p=0;
          int q=s.nextInt();
          int[] arr=new int[w];
          if(q%w==0){
              System.out.println("Case #"+(i+1)+": POSSIBLE");
              k=q/w;
              while(k>=1){
                  arr[p++]=k--;
              }k=w;
               while(p<arr.length){
                  arr[p++]=k--;
              }
             while(w>0){
        for(int j=0;j<arr.length;j++){
            System.out.print(arr[j]+" ");}
            System.out.println();
            int crr= arr[arr.length-1];
            for(int r=arr.length-1;r>0;r--){
                arr[r]=arr[r-1];
            }
            arr[0]=crr;w--;}}
          else
          System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
        }
  }
}