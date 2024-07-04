import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scn.nextInt();
        int T=1;
        while(T<=t){
            int n = scn.nextInt();
            int[][] ar = new int[n][n];
            ArrayList<HashSet<Integer>> setr = new ArrayList<HashSet<Integer>>();
            ArrayList<HashSet<Integer>> setc = new ArrayList<HashSet<Integer>>();
            for(int i=0;i<n;i++){
                setr.add(new HashSet<Integer>());
                setc.add(new HashSet<Integer>());
            }
            int trace = 0;
            int rc = 0, cc= 0;
            boolean rowCancelled = false;
            boolean[] colCancelled = new boolean[n];
            for(int r=0;r<n;r++){
                rowCancelled = false;
                for(int c=0;c<n;c++){
                    ar[r][c] = scn.nextInt();
                    if(!rowCancelled && setr.get(r).contains(ar[r][c])){
                        rc++;
                        rowCancelled = true;
                    }else
                        setr.get(r).add(ar[r][c]);
                    if(!colCancelled[c] && setc.get(c).contains(ar[r][c])){
                        cc++;
                        colCancelled[c] = true;
                    }else
                        setc.get(c).add(ar[r][c]);
                    if(r==c)
                        trace+=ar[r][c];                  
                }
            }                    
            if(T<t)
                System.out.println("Case #"+T+": "+trace+" "+rc+" "+cc);
            else
                System.out.print("Case #"+T+": "+trace+" "+rc+" "+cc);
            T++;
        }
    }

}
