import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;

public class Solution {

    public static void main(String[] args) {
        int testCases = GetInput.getInt();
        for (int m = 0; m < testCases; m++){
            int n = GetInput.getInt();
            int [][]startend = new int[n][2];
            for (int i = 0; i < n; i++){
                startend[i] = GetInput.getArrayInt();
            }
            boolean conflict = false;

            for (int i = 0; i < n; i++){
                for (int j = i+1; j < n; j++){
                    int []overlap = new int[2];
                    overlap[0]=Integer.MIN_VALUE;
                    overlap = overLap(startend[i], startend[j]);
                    if (overlap[0] == Integer.MIN_VALUE ){
                        continue;
                    }
                    for (int k = 0; k < n; k++){
                        if (k == i || k==j){
                            continue;
                        }
                        int []overlap1 = new int[2];
                        overlap1[0]=Integer.MIN_VALUE;
                        overlap1 = overLap(startend[k],overlap );
                        if (overlap1[0] == Integer.MIN_VALUE ){
                            continue;
                        }
                        else {
                            conflict = true;
                        }
                    }
                }
            }

            int []originalPos = sort(startend);
            boolean C = false;
            boolean J = false;

            //find conflict
            int cFreeTime = 0;
            int jFreeTime = 0;
            char[] assign = new char[n];

            int c = 0;
//            for (int i = 0; i < n; i++){
//                int start = startend[i][0];
//                int end = startend[i][1];
//
//                int lieInStartEnd = lieInStartEnd(start, end, startend, i);
////                System.out.println(lieInStartEnd+" "+i);
//                for (int j = i+1; j<lieInStartEnd+i;j++){
//                    if (startend[j][1] > startend[j+1][0]){
////                        System.out.println(startend[i][0]);
//                        conflict = true;
//                    }
//                }
//            }

            for (int i = 0; i < n-2; i++){
                int start = startend[i][0];
                int end = startend[i][1];

                int start1 = startend[i+1][0];
                int end1 = startend[i+1][1];

                int start2 = startend[i+2][0];
                int end2 = startend[i+2][1];

                if (start1>=end){
                    continue;
                }
                else {
                    if (start2 >= end1 || start2>=end){
                        continue;
                    }
                    else if (start2 >= start1 && start2<end){
                        conflict = true;
                    }
                }

            }

            for (int i = 0; i < n; i++){
                if (cFreeTime<=startend[i][0]){
                    C = false;
                }
                if (jFreeTime<=startend[i][0]){
                    J = false;
                }
                if (!C){
                    assign[i] = 'C';
                    C = true;
                    cFreeTime = startend[i][1];
                    continue;
                }
                else if (!J){
                    assign[i] = 'J';
                    J = true;
                    jFreeTime = startend[i][1];
                    continue;
                }
                else {
                    conflict = true;
                    break;
                }
            }

            //if conflict print impossible
            sortOP(originalPos, assign);
            //else print cjcjcjcj

            if (conflict)
            System.out.println("Case #"+(m+1)+": IMPOSSIBLE");
            else {
                System.out.print("Case #"+(m+1)+": ");
                for (int i = 0 ; i < n; i++){
                    System.out.print(assign[i]);
                }
                System.out.println();
            }
        }
    }

    private static int[] overLap(int[] first, int[] two) {
            int start1 = first[0];
            int end1 = first[1];
            int start2 = two[0];
            int end2 = two[1];


        int[] overlap = new int[2];
        if (isBetween(start2, start1, end1)){
            overlap[0] = start2;
            overlap[1] = min(end1, end2);
        }
        else if(isBetween(start1, start2, end2)){
            overlap[0] = start1;
            overlap[1] = min(end1, end2);
        }
        else {
            overlap[0] = Integer.MIN_VALUE;
        }

        return overlap;
    }

    private static boolean isBetween(int start2, int start1, int end1) {
        if (start2 >=start1 && start2 <end1){
            return true;
        }
        return false;
    }

    private static int lieInStartEnd(int start, int end, int[][] startend, int i) {
        int s = 0;
        for (int j = i+1; j< startend.length; j++){
            if (start <= startend[j][0] && end >= startend[j][1]){
                s++;
            }
        }
        return s;
    }

    private static void sortOP(int[] originalPos, char[] assign) {
        for (int i = 0; i < originalPos.length; i++) {
            for (int j = i; j < originalPos.length - 1; j++) {
                if (originalPos[i]>originalPos[j]){
                    int tempOP = originalPos[i];
                    originalPos[i] = originalPos[j];
                    originalPos[j] = tempOP;

                    char tempChar = assign[i];
                    assign[i] = assign[j];
                    assign[j] = tempChar;
                }
            }
        }
    }

    static int[] sort(int[][] startend){
        int[] op = new int[startend.length];
        for (int i = 0; i < startend.length; i++){
            op[i] = i;
        }
        for (int i = 0; i < startend.length; i++){
            for (int j = i; j < startend.length - 1; j++){
                if (startend[i][0] > startend[j][0]){
                    int tempx = startend[i][0];
                    int tempy = startend[i][1];

                    startend[i][0] = startend[j][0];
                    startend[i][1] = startend[j][1];

                    startend[j][0] = tempx;
                    startend[j][1] = tempy;

                    int tempOP = op[i];
                    op[i] = op[j];
                    op[j] = tempOP;
                }
            }
        }

        return op;
    }
}


class GetInput {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static char[] getCharArray() {
        char[] charArray;
        try {
            StringBuilder string = getInputString();
            charArray = new char[string.length()];
            for (int i = 0; i < string.length(); i++) {
                charArray[i] = string.charAt(i);
            }
            return charArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        charArray = new char[0];
        return charArray;
    }

    static int[] getArrayInt() {
        String[] string;
        int[] array;
        try {
            string = bufferedReader.readLine().split("\\s+");
            array = new int[string.length];
            for (int i = 0; i < string.length; i++) {
                array[i] = Integer.parseInt(string[i]);
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arra = new int[2];
        return arra;
    }

    static int getInt() {
        try {
            String string = bufferedReader.readLine();
            return Integer.parseInt(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    static StringBuilder getInputString() {
        try {
            StringBuilder string = new StringBuilder();
            string.append(bufferedReader.readLine());
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new StringBuilder();
    }

    static long getLongInput() {
        try {
            String string = bufferedReader.readLine();
            return Long.parseLong(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    static long[] getLongArrayInput() {
        String[] string;
        long[] array;
        try {
            string = bufferedReader.readLine().split("\\s+");
            array = new long[string.length];
            for (int i = 0; i < string.length; i++) {
                array[i] = Long.parseLong(string[i]);
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }

        long[] arra = new long[2];
        return arra;
    }
}