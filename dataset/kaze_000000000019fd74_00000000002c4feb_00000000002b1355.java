import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int turn = 0; turn < T; turn++) {
            int r = input.nextInt();
            int c = input.nextInt();
            int[][] skills = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    skills[i][j] = input.nextInt();
                }
            }
            int result = 0;
            boolean stop = false;

            while (!stop) {
                stop = true;
                //add
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        result += skills[i][j];
                        //System.out.print(skills[i][j] + " ");
                    }
                    //System.out.println();
                }
                ArrayList<String> eliminate = new ArrayList<String>();
                //generate new 2d array
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (skills[i][j] != 0) {

                            int[] cn = new int[4];
                            for (int m = 0; m < 4; m++) {
                                cn[m] = 0;
                            }
                            int row;
                            int col;

                            row = i;
                            col = j;
                            while (row >= 0 && row <= r - 1) {
                                row--;
                                if (row >= 0 && row <= r - 1 && skills[row][j] != 0) {
                                    cn[0] = skills[row][j];
                                    break;
                                }
                            }

                            row = i;
                            col = j;
                            while (row >= 0 && row <= r - 1) {
                                row++;
                                if (row >= 0 && row <= r - 1 && skills[row][j] != 0) {
                                    cn[1] = skills[row][j];
                                    break;
                                }
                            }

                            row = i;
                            col = j;
                            while (col >= 0 && col <= c - 1) {
                                col--;
                                if (col >= 0 && col <= c - 1 && skills[i][col] != 0) {
                                    cn[2] = skills[i][col];
                                    break;
                                }
                            }

                            row = i;
                            col = j;
                            while (col >= 0 && col <= c - 1) {
                                col++;
                                if (col >= 0 && col <= c - 1 && skills[i][col] != 0) {
                                    cn[3] = skills[i][col];
                                    break;
                                }
                            }
//                            System.out.print(skills[i][j] + " ----- ");
//                            for (int m = 0; m < 4; m++) {
//                                System.out.print(cn[m] + " ");
//                            }
//                            System.out.println();
                            int num0 = 0;
                            int sum = 0;
                            for (int m = 0; m < 4; m++) {
                                if (cn[m] == 0) {
                                    num0++;
                                } else {
                                    sum += cn[m];
                                }
                            }
                            if (num0 <= 3) {
                                if (skills[i][j] * (4 - num0) < sum) {
                                    eliminate.add("" + i + "," +j);
                                    stop = false;
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < eliminate.size(); i++) {
                    String curr = eliminate.get(i);
                    String[] splited = curr.split(",");
                    skills[Integer.parseInt(splited[0])][Integer.parseInt(splited[1])] = 0;
                }
            }
            System.out.println("Case #" + (turn+1) + ": " +result);
        }
    }
}
