import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {

    static void parenting(int[][] a) {
        if (a == null || a.length == 0)
            return;
            
        int activitiesNum = a.length;
        
        // // Arrays.sort(a, (r1, r2) -> r1[0]>r2[0]);
        // Arrays.sort(a, new Comparator<int[]>() { 
            
        //   @Override              
        //   // Compare values according to columns 
        //   public int compare(final int[] entry1,  
        //                      final int[] entry2) { 
  
        //     // To sort in descending order revert  
        //     // the '>' Operator 
        //     if (entry1[0] > entry2[0]) 
        //         return 1; 
        //     else
        //         return -1; 
        //   } 
        // });
        
        int cStart=-1, cEnd=-1, jStart=-1, jEnd=-1;
        StringBuilder res = new StringBuilder();
        
        for (int i=0; i<activitiesNum; i++){
            int activityStart = a[i][0];
            int activityEnd = a[i][1];
            
            if (cStart >= activityEnd || cEnd <= activityStart){         //check if Cameron can take it
                if (cStart == -1)
                    cStart = activityStart;
                cEnd = Math.max(cEnd, activityEnd);
                res.append("C");
            } else if (jStart >= activityEnd || jEnd <= activityStart){  //check if Jamie can take it
                if (jStart == -1)  
                    jStart = activityStart;
                jEnd = Math.max(jEnd, activityEnd);;
                res.append("J");
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        
        System.out.println(res.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] arr = new int[n][2];
    
            for (int i = 0; i < n; i++) {
                String[] arrRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
                for (int j = 0; j < 2; j++) {
                    int arrItem = Integer.parseInt(arrRowItems[j]);
                    arr[i][j] = arrItem;
                }
            }
            int caseNum = tItr+1;
            System.out.print("Case #"+ caseNum + ": ");
            parenting(arr);
        }

        scanner.close();
    }
}
