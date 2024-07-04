

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String ar[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfTest = in.nextInt();
        for(int i = 1 ; i <= numOfTest; i++) {
            int numOfN = in.nextInt();
            System.out.println(getAns(i, numOfN, in));
        }
    }

    public static String  getAns(int caseNumber, int num, Scanner in) {
        int arr[][] = new int[num][num];
        for(int i = 0 ; i< num ;i ++) {
            for  (int j = 0 ; j < num ;j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int sum = 0;
        int r = 0;

        for(int i = 0 ; i< num ;i ++) {
            Set<Integer> set = new HashSet<>();
            for  (int j = 0 ; j < num ;j++) {
                if( i == j) {
                    sum = sum + arr[i][j];
                }
                set.add(arr[i][j]);
            }
            if(set.size() <num) {
                r++;
            }
        }

        int c = 0;

        for(int i = 0 ; i< num ;i ++) {
            Set<Integer> set = new HashSet<>();
            for  (int j = 0 ; j < num ;j++) {
                set.add(arr[j][i]);
            }
            if(set.size() <num) {
                c++;
            }
        }



        return "Case #" + caseNumber + ": "+ sum + " " + r + " " + c;

    }

}
