import java.io.*;
import java.util.*;
class Solution {
    static class ArrayHolder{
      int[][]arr;
      boolean impossible;
      ArrayHolder(int[][]array,boolean imp){
          this.arr = array;
          this.impossible = imp;
      }
    }
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();
    String pos[] = new String[t];
    int[]ns = new int[t];
    int ncount = 0;
    int pcount = 0;
    ArrayList<ArrayHolder> arrayHolderList = new ArrayList<>(); 
    for(int hhj =0;hhj<t;hhj++){
      int n = sc.nextInt();
      int trace = sc.nextInt();
      boolean imp = true;
      int[][]square = new int[n][n];
      int[]tra = new int[n];
      for(int hhl =n;hhl>0;hhl--){
        int tc = 0;
        int sumtra = 0;
        int curstate = trace;
        int numspots = n;
        tra[tc] = hhl;
        tc++;
        sumtra+=hhl;
        curstate=trace-sumtra;
        numspots--;
        if(trace<n){
          break;
        }
          if(curstate%numspots!=0){
            int d = curstate%numspots;
            int x = d;
            int y = numspots-d;
            double xx = curstate*1.0/numspots*1.0;
            for(int b =0;b<x;b++){
              if((int)(Math.ceil(xx))!=0){
                tra[tc] = (int)(Math.ceil(xx));
                sumtra+=Math.ceil(xx);
              }
              else{
                tra[tc] = 1;
                sumtra+=1;
              }
              tc++;
            }
            for(int b = 0;b<y;b++){
              if((int)(Math.floor(xx))!=0){
                System.out.println(y);
                tra[tc] = (int)(Math.floor(xx));
                sumtra+=Math.floor(xx);
              }
              else{
                tra[tc] = 1;
                sumtra+=1;
              }
              tc++;
            }
          }
          else{
            for(int k = 0;k<n-1;k++){
              if(curstate/numspots==0){
                tra[tc] = 1;
                sumtra+=1;

              }
              else{
                tra[tc] = curstate/numspots;
                sumtra+=curstate/numspots;
              }
              tc++;
            }
          }
        if(sumtra==trace){
          for(int i = 0;i<n;i++){
            for(int k = 0;k<n;k++){
              square[i][k] = -1;
            }
          }
          for(int i = 0;i<n;i++){
            square[i][i] = tra[i];
          }
          for(int i = 0;i<n;i++){
            for(int k = 0;k<n;k++){
              if(square[i][k]==-1){
                int[]row = new int[n];
                int[]col = new int[n];
                for(int b = 0;b<n;b++){
                  row[b] = square[i][b];
                  col[b] = square[b][k];
                }
                for(int u = 1;u<=n;u++){
                  if(search(row,u)==-1 && search(col,u)==-1){
                    square[i][k] = u;
                  }
                }
              }
            }
          }
          boolean good = true;
          for(int i = 0;i<n;i++){
            for(int k =0;k<n;k++){
              if(square[i][k]==-1){
                good = false;
              }
            }
          }
          if(good){
            imp = false;
            break;
          }
        }
        if(!imp){
          break;
        }
      }
      String poss = "";
      if(imp){
        poss = "IMPOSSIBLE";
      }
      else{
        poss = "POSSIBLE";
      }
      pos[pcount] = poss;
      pcount++;
      arrayHolderList.add(new ArrayHolder(square,imp));
      //end
      
    }
    int indexCase = 1;
    for(ArrayHolder ah:arrayHolderList){
      if(ah.impossible){
        System.out.println("Case #"+indexCase+": IMPOSSIBLE");
      }
      else{
        System.out.println("Case #"+indexCase+": POSSIBLE");
        for(int i =0;i<ah.arr.length;i++){
          for(int k = 0;k<ah.arr.length;k++){
            System.out.print(ah.arr[i][k]+" ");
          }
          System.out.println();
        }
      }
      indexCase++;
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