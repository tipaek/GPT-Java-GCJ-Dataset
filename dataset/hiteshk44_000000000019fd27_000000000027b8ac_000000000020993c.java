import java.util.Scanner;
public class Problem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for(int i=0;i<testCases;i++) {
            int n = scanner.nextInt();

            int colSum[] = new int[n];
            long totalSum = (n*(n+1))/2;
            int noOfRows=0, noOfColumns=0, trace=0;
            for(int rowPointer = 0; rowPointer < n; rowPointer++) {
                long sum = 0;
                for(int colPointer = 0; colPointer < n; colPointer++) {
                    int val = scanner.nextInt();
                    sum += val;
                    colSum[colPointer] += val;
                    if(rowPointer == colPointer)
                        trace += val;
                }
                if(sum != totalSum)
                    noOfRows++;
            }

            for(int cols = 0; cols < n; cols++){
                if(colSum[cols] != totalSum)
                    noOfColumns++;
            }
            System.out.println("Case #" + i + ": " + trace + " " + noOfRows + " " + noOfColumns);

        }

    }
}