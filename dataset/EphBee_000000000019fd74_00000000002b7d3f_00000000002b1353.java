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
            System.out.println("Case #" + caseID + ":");
            int requiredNbr = in.nextInt();
            
            int requiredNbrTemp = requiredNbr;
            int i = 0; float j = 0;
            while(requiredNbrTemp > 0) {
                requiredNbrTemp -= triangle.get(i).get((int)j);
                System.out.println((i+1) + " " + (int)(j+1));
                if(requiredNbrTemp==0) break;
                j += 0.5; i+=1;
                int tempValue = triangle.get(i).get((int)j);
                while(tempValue > requiredNbrTemp) {
                    j--;
                    tempValue = triangle.get(i).get((int)j);
                }
            }
        }
        caseID += 1;
     }
}