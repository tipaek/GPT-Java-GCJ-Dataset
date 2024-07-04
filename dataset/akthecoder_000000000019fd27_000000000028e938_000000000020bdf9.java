import java.util.Scanner;

public class Solution {
    static class Interval {
        int st = 0;
        int et = 0;
        int originalIndex = 0;
        String assignedTo = "X";

        public Interval(int st, int et, int oI) {
            this.st = st;
            this.et = et;
            this.originalIndex = oI;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for(int i = 0; i < testCases; i++) {
            int N = scan.nextInt();
            Interval[] interval = new Interval[N];

            for(int r = 0; r < N; r++) {
                interval[r] = new Interval(scan.nextInt(), scan.nextInt(), r);
            }
            bubbleSort(interval, N);
            if(calculatePartnering(interval, N) == "") {
                reSort(interval, N);
                String result = "";
                for(int r = 0; r < N; r++) {
                    result += interval[r].assignedTo;
                }
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
            else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
        scan.close();
    }

    public static void bubbleSort(Interval arr[] , int n) {
        if (n == 1) 
            return; 
       
        for (int i=0; i<n-1; i++) 
            if (arr[i].st > arr[i+1].st) 
            { 
                Interval temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            } 
       
        bubbleSort(arr, n-1);
    }

    public static void reSort(Interval arr[] , int n) {
        if (n == 1) 
            return; 
       
        for (int i=0; i<n-1; i++) 
            if (arr[i].originalIndex > arr[i+1].originalIndex) 
            { 
                Interval temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            } 
       
        reSort(arr, n-1);
    }

    public static String calculatePartnering(Interval[] interval, int N) {
        String result = "";
        int JE = 0;
        int CE = 0;
        
        for(int i = 0; i < N; i++) {
            int ST = interval[i].st;
            if(JE <= ST) {
                JE = interval[i].et;
                interval[i].assignedTo = "J";
            }
            else if(CE <= ST) {
                CE = interval[i].et;
                interval[i].assignedTo = "C";
            }
            else {
                return "IMPOSSIBLE";
            }
        }
        return result;
    }
}