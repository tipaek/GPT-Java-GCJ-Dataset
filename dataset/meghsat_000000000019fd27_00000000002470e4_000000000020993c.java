import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0;i<T;i++)
        {
        int trace=0;
        int row=0;
        int column=0;
        int N=sc.nextInt();
        int[][] arr=new int[N][N];
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
            h.add(m[j][z]);   
            }
            if(h.size()<s){
                column++;
            }
        }
        System.out.println("case #"+(i+1)+": "+trace+" "+row+" "+column);
    }
  }
}