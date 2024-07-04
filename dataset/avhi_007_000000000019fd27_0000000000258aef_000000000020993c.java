import java.util.*;
import java.io.*;
public class Solution {
  public static boolean check(int[] a,int n){
    boolean val=false;
    for(int i=0;i<n;i++) {
      int b=a[i];
      for(int j=i+1;j<n;j++) {
        if(a[j]==b){
          val=true;
          break;
        }
      }
      if(val==true){break;}
    }
    return val;
  }

  public static boolean check1(ArrayList<Integer> n,int size){
    boolean val=false;
    for(int i =0;i<size;i++){
      int a = n.get(i);
      for(int j=i+1;j<size;j++){
        if(n.get(j)==a){
          val=true;
          break;
        }
      }
      if(val==true){break;}
    }
    return val;
  }
  public static void main(String[] args) {
    Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    try{
    int t = s.nextInt();
    for(int i=1;i<=t;i++){
        int trace=0;
        int n = s.nextInt();
        int mat[][] = new int[n][n];
       int rown=0,coln=0;
       for(int j = 0;j<n;j++){
           int sum=0;
           for(int k = 0;k<n;k++){
               mat[j][k]=s.nextInt();
               if(j==k)
                 trace+=mat[j][k];
           }
       }
       for(int a[]:mat){
        if(check(a,n))
          rown++;
       }
       //columns
       for(int l=0;l<n;l++){
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for(int m=0;m<n;m++){
          arr.add(mat[m][l]);
        }
        if(check1(arr,n)){coln++;}
       }
       System.out.println("Case #"+i+": "+trace+" "+
       rown+" "+coln);
    }
  }catch(Exception e){}
  }
}

