import java.util.*;
import java.io.*;
class Solution
{
    public static void main(String[] args) throws FileNotFoundException,IOException
    {
        Scanner sc = new Scanner(System.in);
        int testcases=sc.nextInt();
        for(int i=0;i<testcases;i++){
        int trace=0;
        int row=0;
        int column=0;
        int s=sc.nextInt();
        // List<List<Integer>> m=new List<List<Integer>>();
       
        int[][] m=new int[s][s];
        for(int j=0;j<s;j++){
            HashSet<Integer> h=new HashSet<Integer>();
            for(int z=0;z<s;z++){
                m[j][z]=sc.nextInt();
                h.add(m[j][z]);
                if(j==z){
                  trace+=m[j][z];
                }
            }
            if(h.size()<s){
                row++;
            }
        }
        
        for(int z=0;z<s;z++){
            HashSet<Integer> h=new HashSet<Integer>();
            for(int j=0;j<s;j++){
            // System.out.print(m[j][z]+" ");
            h.add(m[j][z]);   
            }
            if(h.size()<s){
                column++;
            }
        }
        System.out.println("case #"+(i+1)+": "+trace+" "+row+" "+column);
        // System.out.println(trace+" "+row+" "+column);
    }
  }
}