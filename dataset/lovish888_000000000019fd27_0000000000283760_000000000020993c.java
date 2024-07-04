import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Solution{

     public static void main(String []args) {
         
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int i=0; i<T; i++) {
            
            int N = input.nextInt();
            
            ArrayList<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>();
            ArrayList<HashSet<Integer>> columns = new ArrayList<HashSet<Integer>>();
            ArrayList<ArrayList<Integer>> nums = new ArrayList<ArrayList<Integer>>();

            int trace = 0;
            
            int fr = 0;
            int fc = 0;
            
            for (int j=0; j<N; j++) {
                ArrayList<Integer> r = new ArrayList<Integer>();
                for (int k=0; k<N; k++) {
                    int e = input.nextInt();
                    r.add(e);
                    if (j==k) {
                        trace = trace + e;
                    }
                }
                nums.add(r);
            }
            
            for (int j=0; j<N; j++) {
                HashSet<Integer> m = new HashSet<Integer>();
                m.addAll(nums.get(j));
                rows.add(m);
            }

            
            for (int k=0; k<N; k++) {
                HashSet<Integer> m = new HashSet<Integer>();
                for (int j=0; j<N; j++) {
                    m.add(nums.get(j).get(k));
                }
                columns.add(m);
            }
            
            for (int l=0; l<N; l++) {
                if (rows.get(l).size() < N) {
                    fr++;
                }
                if (columns.get(l).size() < N) {
                    fc++;
                }
            }
            
            System.out.println("Case #" + (i+1) + ": " + trace + " " + fr + " " + fc);
            
        }
        
     }
}