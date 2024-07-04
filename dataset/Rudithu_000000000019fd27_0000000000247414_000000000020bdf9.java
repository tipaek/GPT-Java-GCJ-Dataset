import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i=1; i <= t; i++) {

            int activities = in.nextInt();
            if (activities > 0) {
                System.out.print("Case #" + i + ": ");
            }

            StringBuffer sb = new StringBuffer();

            int[] cS = new int[24*60];
            int[] jS = new int[24*60];

            for (int j=0;j<activities;j++) {
                int[] currentSchedule = new int[]{in.nextInt(), in.nextInt()};
                if (isAvailable(cS, currentSchedule)) {
                    sb.append("C");
                } else if(isAvailable(jS, currentSchedule)) {
                    sb.append("J");
                } else {
                    sb = new StringBuffer("IMPOSSIBLE");
                    break;
                }
            }
            if (sb.toString().length() > 0) {
                System.out.println(sb.toString());
            }
        }

    }

    public static boolean isAvailable(int[] allS, int[] iS) {

//        System.out.println("start:" + iS[0] + " End:" + iS[1]);
//        System.out.println("===================================");

        int count = 0;
        int i = 0;
        for (; i <= iS[0]; i++) {
            count += allS[i];
        }
//        System.out.println("StartCount:" + count + " -> " + i);
        if (count != 0) {
//            System.out.println("FALSE");
            return false;
        }

        for (; i <= iS[1]; i++) {
            count += allS[i];
        }
//        System.out.println("EndCount:" + count + " -> " + i);
        if (count != 0) {
//            System.out.println("FALSE");
            return false;
        }




//        for (int a=0; a < 20; a++) {
//            System.out.print(allS[a] + " ");
//        }
//        System.out.println();

        allS[iS[0]] = allS[iS[0]]+1;
        allS[iS[1]] = allS[iS[1]]-1;
//        System.out.println("TRUE");
//        for (int a=0; a < 20; a++) {
//            System.out.print(allS[a] + " ");
//        }
//        System.out.println();
        return true;
    }


    public static boolean isAvailable_(int[] allS, int[] iS) {

//        System.out.println();
//        System.out.println("start:" + iS[0] + " End:" + iS[1]);
//        System.out.println("===================================");



        for (int i = iS[0]; i < iS[1] || i <=iS[0] ; i++) {
            if (allS[i] != 0) {
                return false;
            }
        }

//        for (int a=0; a < 20; a++) {
//            System.out.print(allS[a] + " ");
//            if ((a+1) % 5 == 0) {
//                System.out.print("\t");
//            }
//        }


        for (int i = iS[0]; i < iS[1]; i++) {
            allS[i] = 1;
        }



//        System.out.println("TRUE");
//        for (int a=0; a < 20; a++) {
//            System.out.print(allS[a] + " ");
//            if ((a+1) % 5 == 0) {
//                System.out.print("\t");
//            }
//        }
//        System.out.println();
        return true;
    }


}


