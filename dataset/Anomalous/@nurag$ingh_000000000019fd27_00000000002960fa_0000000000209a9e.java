import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int b = in.nextInt();
        
        for (int l = 0; l < t; l++) {
            int[] arr = new int[10];
            
            for (int i = 0; i <= 9; i++) {
                if (i != 1) {
                    System.out.println(i);
                    System.out.flush();
                    arr[i] = in.nextInt();
                }
            }
            
            System.out.println(1);
            System.out.flush();
            int one = in.nextInt();
            
            int[] temparr = new int[10];
            for (int i = 2; i <= 9; i++) {
                System.out.println(i);
                System.out.flush();
                temparr[i] = in.nextInt();
            }
            
            int[] arrComp = new int[10];
            int[] arrRev = arr.clone();
            int[] arrRevComp = new int[10];
            
            for (int i = 2; i <= 9; i++) {
                arrComp[i] = arr[i] == 0 ? 1 : 0;
            }
            
            for (int i = 2; i <= 4; i++) {
                int temp = arrRev[i];
                arrRev[i] = arrRev[9 - i];
                arrRev[9 - i] = temp;
            }
            
            for (int i = 2; i <= 9; i++) {
                arrRevComp[i] = arrRev[i] == 0 ? 1 : 0;
            }
            
            if (matches(temparr, arrComp)) {
                arr[1] = one == 0 ? 1 : 0;
                if (printAndCheck(arr, in)) continue;
            }
            
            if (matches(temparr, arrRev)) {
                arr[1] = temparr[8];
                if (printAndCheck(arr, in)) continue;
            }
            
            if (matches(temparr, arrRevComp)) {
                arr[1] = temparr[8] == 0 ? 1 : 0;
                if (printAndCheck(arr, in)) continue;
            }
        }
    }
    
    private static boolean matches(int[] arr1, int[] arr2) {
        for (int i = 2; i <= 7; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean printAndCheck(int[] arr, Scanner in) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            ans.append(arr[i]);
        }
        System.out.println(ans.toString());
        System.out.flush();
        String ch = in.next();
        return ch.equals("Y");
    }
}