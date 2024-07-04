import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static int T, B;


    public static void getDataFromStdIn() {
        if (myReader.hasNextLine()) {
            String[] inputArr = myReader.nextLine().replace("\n", "").trim().split(" ");
            T = Integer.valueOf(inputArr[0]);
            B = Integer.valueOf(inputArr[1]);
        }
    }

    public static void processB10() {
        int[] rootArr = new int[10];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1);
            rootArr[i] = Integer.valueOf(myReader.nextLine().replace("\n", "").trim());
            res.append(rootArr[i]);
        }
        System.out.printf("%s\n", res.toString());
    }

    public static void processB20() {
        System.out.printf("%s\n", "1100");

    }

    public static void processB100() {
        System.out.printf("%s\n", "1100");
    }

    public static void main(String[] args) {
        getDataFromStdIn();
        if (B == 10) {
            for (int i = 0; i < T; i++) {
                processB10();
                myReader.nextLine().replace("\n", "").trim();
            }

        } else if(B == 20) {
            for (int i = 0; i < T; i++)
                processB20();
        } else if (B == 100) {
            for (int i = 0; i < T; i++)
                processB100();
        }
    }
}
