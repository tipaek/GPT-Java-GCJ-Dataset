import java.util.Scanner;
import java.util.ArrayList;
public class Vestigium {
    public static int counter = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][][] arr = new int[scan.nextInt()][][];
        for(int i = 0; i < arr.length ; i++) {
            int len = scan.nextInt();
            arr[i] = new int[len][len];
            for(int r = 0; r < len; r++) 
                for(int c = 0; c < len; c++)
                    arr[i][r][c] = scan.nextInt();
        }

        for(int[][] arrP: arr)
            google(arrP);
    }

    public static void google(int[][] arr) {
        counter++;
        int trace = 0;
        int countR = 0;
        int countC = 0;
        for(int i = 0; i < arr.length; i++)
            trace += arr[i][i];
        for(int r = 0; r < arr.length; r++) {
            ArrayList<Integer> arrL = new ArrayList<>();
            for(int c = 0; c < arr.length; c++) {
                boolean check = false;
                for(int i = 0; i < arrL.size(); i++)
                    if(arrL.get(i) == arr[r][c]) {
                        check = true;
                        break;
                    }

                if(check) {
                    countR++;
                    break;
                }
                else {
                    arrL.add(arr[r][c]);
                }
            }
        }

        for(int c = 0; c < arr.length; c++) {
            ArrayList<Integer> arrL = new ArrayList<>();
            for(int r = 0; r < arr.length; r++) {
                boolean check = false;
                for(int i = 0; i < arrL.size(); i++)
                    if(arrL.get(i) == arr[r][c]) {
                        check = true;
                        break;
                    }

                if(check) {
                    countC++;
                    break;
                }
                else {
                    arrL.add(arr[r][c]);
                }
            }
        }

        System.out.println("Case #" + counter + ": " + trace + " " + countR + " " + countC);
    }
}