import java.util.ArrayList;
import java.util.Scanner;
public class CodeJam2020 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int x = s.nextInt();    
        int i,j,p;
        
        for(i=0; i<x; i++){
            ArrayList<Integer> a = new ArrayList<Integer>();
            int trace = 0;
            int r=0,c=0;
            int n = s.nextInt();
            int[][] m = new int[n][n];
            for(j=0; j<n; j++){
                for(p=0; p<n; p++){
                    m[j][p] = s.nextInt();
                    if(j==p){
                        trace += m[j][p];
                    }
                }                
            } 
            a.add(trace);
            a.add(r);
            a.add(c);
            ans.add(a);
        }
        
         for(i=0; i<x; i++){
             System.out.println("Case #"+(i+1)+": "+ans.get(i).get(0)+" "+ans.get(i).get(1)+" "+ans.get(i).get(2));
         }
    }
    
}
