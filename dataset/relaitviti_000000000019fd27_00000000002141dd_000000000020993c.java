import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer[]> answer = new ArrayList<Integer[]>();
        while (n > 0) {
            int m = sc.nextInt();
            int arr[][] = new int[m][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            answer.add(calculate(m,arr));
            n--;
        }
        for (int i = 0 ; i < answer.size(); i++) {
            int j = i+1;
            System.out.println("Case #" + j + ": " + answer.get(i)[0] + " " + answer.get(i)[1] + " " + answer.get(i)[2]);
        }
    }

    public static Integer[] calculate(int length, int[][] arr) {
//        System.out.println(arr[0][0]+ " " +arr[0][1]);
        Integer[] result = new Integer[3];
        int diagonal = 0;
        for (int i = 0; i < length; i++) {
            diagonal+= arr[i][i];
        }
        int row = 0, column = 0;
        for (int i = 0; i < length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j=0; j < length; j++) {

                if (temp.contains(arr[i][j])) {
                    row++;
                    break;
                } else {
                    temp.add(arr[i][j]);
                }
//                System.out.println(temp);

            }
        }
        for (int i = 0; i < length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j=0; j < length; j++) {

                if (temp.contains(arr[j][i])) {
                    column++;
                    break;
                } else {
                    temp.add(arr[j][i]);
                }
//                System.out.println(temp);
            }
        }
//        System.out.println(row + " " + column);
        result[0] = diagonal;
        result[1] = row;
        result[2] = column;
        return  result;
    }
}
