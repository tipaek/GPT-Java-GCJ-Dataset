import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0; i<cases; i++){
            int n = sc.nextInt();
            int diagonal = 0;
            int[] totalC = new int[n];
            int sumN = (n * (n + 1))/2;
            int nonLatinRows = 0;
            int nonLatinColumns = 0;
            for(int j = 0; j < n; j++){
                int totalR = (sumN * sumN);
                for(int k = 0; k < n; k++){
                    if(j == 0)
                        totalC[k] = sumN * sumN;
                    int next = sc.nextInt();
                    if(j==k) {
                        diagonal+=next;
                    }
                    next = next * next * next;
                    totalR-=next;
                    totalC[k]-=next;
                }
                if(totalR!=0)
                    nonLatinRows++;
            }
            for(int l = 0; l<n; l++) {
                if(totalC[l]!=0)
                    nonLatinColumns++;
            }
            System.out.print("Case #" + i);
            System.out.print(": ");
            System.out.print(diagonal);
            System.out.print(" " + nonLatinRows);
            System.out.print(" " + nonLatinColumns);
            System.out.println();
            
        }
    }
}