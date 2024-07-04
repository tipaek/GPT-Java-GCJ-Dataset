import java.lang.*;
import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int testcase=sc.nextInt();
        Map<Integer,Integer>col=new HashMap<>();
        for(int i=0;i<testcase;i++){
            int trace=0;
            int size=sc.nextInt();
            int r=0;
            int[] cols=new int[size];
            int c[][]=new int[size][size];
            for(int j=0;j<size;j++){
                int countr=0;
                Map<Integer,Integer>row=new HashMap<>();
                for(int k=0;k<size;k++){
                    int current=sc.nextInt();
                    if(countr==0){
                        if(row.containsKey(current)){
                            r++;
                            countr=1;
                        }else{
                            row.put(current,j);
                        }
                    }
                    if(cols[k]==0){
                        for(int t=0;t<=j;t++){
                            if(c[k][t]==current){
                                cols[k]++;
                            }
                        }
                        c[k][j]=current;
                    }
                    if(j==k){
                        trace=trace+current;
                    }
                }
            }
            int c3=0;
            for(int x=0;x<cols.length;x++){
                if(cols[x]!=0){
                   c3++; 
                }
            }
            System.out.print("Case #"+Integer.toString(i+1)+": ");
            System.out.print(Integer.toString(trace)+" ");
            System.out.print(Integer.toString(r)+" ");
            System.out.println(Integer.toString(c3));
        }
    }
}