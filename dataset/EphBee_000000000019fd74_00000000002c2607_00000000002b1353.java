import java.util.*;
import java.io.*;
public class Solution {
    static int binomialCoeff(int n, int k) { 
    int res = 1; 
    if (k > n - k) 
    k = n - k; 
    for (int i = 0; i < k; ++i) { 
        res *= (n - i); 
        res /= (i + 1); 
    } 
    return res; 
} 
    public static ArrayList<ArrayList<Integer>> buildTriangle(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList <ArrayList<Integer>>();
        for(int i=0;i<n;i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int j=0;j<i;j++) {
                row.add(binomialCoeff(i,j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
    
     public static void main(String []args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int count = in.nextInt();
        int caseID = 1;
        ArrayList<ArrayList<Integer>> triangle = buildTriangle(20);
        // for(int i=0;i<triangle.size();i++){
        //     ArrayList<Integer> row = triangle.get(i);
        //     for(int j=0;j<row.size();j++) {
        //         System.out.print(row.get(j) + " ");
        //     }
        //     System.out.println();
        // }
        for(int e=0;e<count;e++) {
            System.out.println("Case #" + caseID + ": ");
            int requiredNbr = in.nextInt();
            int required = requiredNbr;
            int i = 0; int j = 0;
            int total = 0;
            while(requiredNbr > 0) {
                requiredNbr -= triangle.get(i).get(j);
                total += triangle.get(i).get(j);
                System.out.println((i+1) + " " + (j+1));
                if(requiredNbr==0) break;
                // if(total == 1) continue;
                
                int addI = 0;
                int addJ = 0;
                if(i>0 && (j+1) < triangle.get(i+1).size() && triangle.get(i+1).get(j+1) <= requiredNbr) {
                    addI=1;addJ=1;
                }
                if (triangle.get(i+1).get(j) <= requiredNbr 
                && triangle.get(i+1).get(j) >= triangle.get(i+addI).get(j+addJ)) {
                    addI=1;
                }
                if (j!=0 && triangle.get(i).get(j-1) <= requiredNbr
                && triangle.get(i).get(j-1) >= triangle.get(i+addI).get(j+addJ)) {
                    addJ =-1;
                }
                if (i>0 && (j+1) < triangle.get(i+1).size() && triangle.get(i).get(j+1) <= requiredNbr
                && triangle.get(i).get(j+1) >= triangle.get(i+addI).get(j+addJ)) {
                    addJ =1;
                }
                if (i!=0 && triangle.get(i-1).get(j) <= requiredNbr
                && triangle.get(i-1).get(j) >= triangle.get(i+addI).get(j+addJ)) {
                    addI =-1;
                }
                if (i!=0 && j!=0 && triangle.get(i-1).get(j-1) < requiredNbr
                && triangle.get(i-1).get(j-1) >= triangle.get(i+addI).get(j+addJ)) {
                    addJ =-1;addI=-1;
                } 
                i += addI; j += addJ;
            }
            // System.out.println("Required is: " + required + " and actual is : " + total);
            caseID += 1;
        }
     }
}