import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int retcol=0,retrow=0,total=0;
            int n = in.nextInt();

            int [][] colarr=new int[n][n];
           for(int j= 1; j<=n;j++){
               int temprow=1;
               int [] rowarr=new int[n];
               for(int k= 1; k<=n;k++) {
                   int temp=in.nextInt();
                   colarr[j-1][k-1]=temp;
                   if(j==k){
                       total+=temp;
                   }
                 if(++rowarr[temp-1]>=2){
                     temprow++;
                 }

               }
               if(temprow>retrow){
                   retrow=temprow;
               }
           }

            for(int j= 1; j<=n;j++){
                int temprow=1;
                int [] rowarr=new int[n];
                for(int k= 1; k<=n;k++) {
                    int temp=colarr[k-1][j-1];
                    if(++rowarr[temp-1]>=2){
                        temprow++;
                    }

                }
                if(temprow>retcol){
                    retcol=temprow;
                }
            }
            if(retrow==1){
    retrow=0;
}
            if(retcol==1){
                retcol=0;
            }
            if(i==t){
                System.out.print("Case #"+ i + ": " + total + " " +retrow+" "+retcol );
            }else{
            System.out.println("Case #"+ i + ": " + total + " " +retrow+" "+retcol );
             }
        }
    }
}