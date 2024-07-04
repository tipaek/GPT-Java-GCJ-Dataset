import java.util.*;
import java.io.*;


class Main {

 public static void main(String[] args)throws IOException {
    InputStreamReader in = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(in);
       int t = Integer.parseInt(br.readLine());
        for(int j=0;j<t;j++) {
          int n = Integer.parseInt(br.readLine());
          int arr[][] = new int[n][3];
          for(int i=0;i<n;i++) {
             String line[] = br.readLine().split(" ");
             arr[i][0] = Integer.parseInt(line[0]);
             arr[i][1] = Integer.parseInt(line[1]);
             arr[i][2] = i;
          }
           parenting(j,arr);
       }
   }



public static void parenting(int t, int a[][]) {
     String str="";
      for(int i=0;i<a.length;i++) {
         str+="C";
        }
       int na[][] = a;
       Arrays.sort(na,new Comparator<int[]>(){
         public int compare(int a[], int b[]) {
             if(a[0]>b[0]) return 1;
              else return -1;
           }
       });

      int stC=na[0][0],edC=na[0][1];
       // str=str+"C";
      StringBuilder sb = new StringBuilder(str);
      int stJ=1,edJ=1;
      for(int i=1;i<a.length;i++) {
          if(na[i][0]>=stC && na[i][0]<edC) {
              if(na[i][0]>=stJ && na[i][0]<edJ) {
                 System.out.printf("Case #%d: %s\n",t+1,"IMPOSSIBLE");
                  return ;
              } else {
                 stJ = na[i][0];
                 edJ = na[i][1];
                 sb.setCharAt(na[i][2],'J');
                 //str+="J";
             }
          } else {
             stC = na[i][0];
             edC = na[i][1];
             str+="C";
         }
      }
      System.out.printf("Case #%d: %s\n",t+1,sb.toString());
   }
}