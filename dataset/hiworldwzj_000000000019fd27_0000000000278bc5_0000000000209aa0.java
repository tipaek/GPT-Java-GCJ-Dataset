import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while(T != 0) {
            T--;
            testCaseNum++;
            String[] NK = reader.readLine().split(" ");
            int N = Integer.parseInt(NK[0]);
            ansK = Integer.parseInt(NK[1]);
            if(N <= 5) {
                findAns = false;
                int[][] ints = new int[N][N];
                setNN(ints, N, 0);
                if(!findAns) {
                    System.out.println("Case #" + testCaseNum + ": IMPOSSIBLE");
                }
            } else {
                findAns = false;
                if(ansK < N || ansK > N * N || ansK == N + 1 || ansK == N * N - 1) {
                    System.out.println("Case #" + testCaseNum + ": IMPOSSIBLE");
                } else {
                    ArrayList<Integer> numLists = new ArrayList<>();
                    getUpperDownList(numLists, N, ansK);
                    Object[] rowMarks = new Object[N];
                    Object[] colMarks = new Object[N];
                    for(int j = 0; j < N; j++) {
                        rowMarks[j] = new TreeSet<Integer>();
                        colMarks[j] = new TreeSet<Integer>();
                    }
                    int[][] maps = new int[N][N];
                    for(int i = 0; i < N; i++) {
                        Arrays.fill(maps[i], -1);

                        maps[i][i] = numLists.get(i);
                        ((TreeSet<Integer>)rowMarks[i]).add(maps[i][i]);
                        ((TreeSet<Integer>)colMarks[i]).add(maps[i][i]);
                    }
                    setMaxNN(maps, N, 0, rowMarks, colMarks);
                }
            }
        }
    }

    public static int testCaseNum;

    public static int ansK = -1;

    public static boolean findAns = false;

    public static void setNN(int[][] ints, int N, int loc) {
        int row = loc / N;
        int col = loc % N;
        for(int i = 1; i <= N; i++) {
            if(findAns) {
                return;
            }
            if(isOKRow(ints, N, row, col, i) && isOkCol(ints, N, row, col, i)) {
                ints[row][col] = i;
                if(loc != N * N - 1) {
                    setNN(ints, N, loc + 1);
                } else {
                    int sum = 0;
                    for(int k = 0; k < N; k++) {
                        sum += ints[k][k];
                    }
                    if(sum == ansK) {
                        findAns = true;
                        System.out.println("Case #" + testCaseNum + ": " + "POSSIBLE");
                        for(int print_row = 0; print_row < N; print_row++) {
                            StringBuilder sb  = new StringBuilder();
                            for(int colz = 0; colz < N; colz++) {
                                if(colz == N -1) {
                                    sb.append(ints[print_row][colz]);
                                } else {
                                    sb.append(ints[print_row][colz] + " ");
                                }
                            }
                            System.out.println(sb.toString());
                        }
                        return;
                    }
                }
            }
        }
    }

    public static void setMaxNN(int[][] maps, int N, int loc, Object[] rowMarks, Object[] colMarks) {
        int row = loc / N;
        int col = loc % N;
        if(maps[row][col] != -1) {
            if(loc == N * N - 1) {
                findAns = true;
                System.out.println("Case #" + testCaseNum + ": " + "POSSIBLE");
                for(int print_row = 0; print_row < N; print_row++) {
                    StringBuilder sb  = new StringBuilder();
                    for(int colz = 0; colz < N; colz++) {
                        if(colz == N -1) {
                            sb.append(maps[print_row][colz]);
                        } else {
                            sb.append(maps[print_row][colz] + " ");
                        }
                    }
                    System.out.println(sb.toString());
                }
                return;
            }
            setMaxNN(maps, N, loc + 1, rowMarks, colMarks);
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(findAns) return;
            if(!((TreeSet<Integer>)rowMarks[row]).contains(i) && !((TreeSet<Integer>)colMarks[col]).contains(i)) {
                maps[row][col] = i;
                ((TreeSet<Integer>)rowMarks[row]).add(i);
                ((TreeSet<Integer>)colMarks[col]).add(i);
                if(loc == N * N - 1) {
                    findAns = true;
                    System.out.println("Case #" + testCaseNum + ": " + "POSSIBLE");
                    for(int print_row = 0; print_row < N; print_row++) {
                        StringBuilder sb  = new StringBuilder();
                        for(int colz = 0; colz < N; colz++) {
                            if(colz == N -1) {
                                sb.append(maps[print_row][colz]);
                            } else {
                                sb.append(maps[print_row][colz] + " ");
                            }
                        }
                        System.out.println(sb.toString());
                    }
                    return;
                }
                setMaxNN(maps, N, loc + 1, rowMarks, colMarks);
                ((TreeSet<Integer>)rowMarks[row]).remove(i);
                ((TreeSet<Integer>)colMarks[col]).remove(i);
                maps[row][col] = -1;
            }
        }
    }

    public static boolean isOKRow(int[][] ints, int N, int row, int col, int value) {
        for(int colz = 0; colz < col; colz++) {
            if(ints[row][colz] == value) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOkCol(int[][] ints, int N, int row, int col, int value) {
        for(int rowz = 0; rowz < row; rowz++) {
            if(ints[rowz][col] == value) {
                return false;
            }
        }
        return true;
    }

    public static void getUpperDownList(ArrayList<Integer> lists, int N, int K) {
        if(K % N == 0) {
            for(int i = 0; i < N; i++) {
                lists.add(K / N);
            }
            return;
        }
        int num = K / N;
        int count = K / num;
        if(count >= N - 1) {
            count = N - 2; 
        }
        for(int i = 0; i < count; i++) {
            lists.add(num);
        }

        int leftK = K - count * num;
        if(leftK % 2 == 0) {
            lists.add(leftK / 2);
            lists.add(leftK / 2);
        } else {
            lists.add(leftK / 2);
            lists.add(leftK / 2 + 1);
        }
    }

}
