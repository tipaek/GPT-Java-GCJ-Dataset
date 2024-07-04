import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        
        for (int i = 0; i < T; i++) {
            int[][] bitArr = new int[4][B];
            Arrays.fill(bitArr[0], -1);
            boolean[] cases = new boolean[4];
            int queryNum = 0;
            int front = 1;
            int back = B;
            boolean isCorrectBitArr = true;
            int counter = 0;
            boolean queryFront = true;
            
            while (counter < B) {
                if (queryNum > 9 && queryNum % 10 == 0) {
                    getCases(bitArr);
                    isCorrectBitArr = false;
                }

                if (isCorrectBitArr && queryFront) {
                    queryNum++;
                    System.out.println(front);
                    bitArr[0][front - 1] = input.nextInt();
                    front++;
                    queryFront = false;
                    counter++;
                } else if (isCorrectBitArr) {
                    queryNum++;
                    System.out.println(back);
                    bitArr[0][back - 1] = input.nextInt();
                    back--;
                    queryFront = true;
                    counter++;
                } else {
                    HashSet<Integer> toQuery = new HashSet<>();
                    int idxToQ = help(bitArr, cases, B, toQuery);
                    if (idxToQ == -1) {
                        for (int ask : toQuery) {
                            queryNum++;
                            System.out.println(ask + 1);
                            bitArr[0][ask] = input.nextInt();
                        }
                        isCorrectBitArr = true;
                        Arrays.fill(cases, false);
                        continue;
                    }
                    queryNum++;
                    System.out.println(idxToQ + 1);
                    int chosen = input.nextInt();
                    cancel(bitArr, cases, chosen, idxToQ);
                    if (checkCases(cases)) {
                        isCorrectBitArr = true;
                        for (int a = 0; a < 4; a++) {
                            if (!cases[a]) {
                                bitArr[0] = bitArr[a].clone();
                            }
                        }
                        Arrays.fill(cases, false);
                    }
                }
            }

            while (!isCorrectBitArr) {
                HashSet<Integer> toQuery = new HashSet<>();
                int idxToQ = help(bitArr, cases, B, toQuery);
                if (idxToQ == -1) {
                    for (int ask : toQuery) {
                        queryNum++;
                        System.out.println(ask + 1);
                        bitArr[0][ask] = input.nextInt();
                    }
                    break;
                }
                queryNum++;
                System.out.println(idxToQ + 1);
                int chosen = input.nextInt();
                cancel(bitArr, cases, chosen, idxToQ);
                if (checkCases(cases)) {
                    isCorrectBitArr = true;
                    for (int a = 0; a < 4; a++) {
                        if (!cases[a]) {
                            bitArr[0] = bitArr[a].clone();
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < B; c++) {
                if (bitArr[0][c] == -1) {
                    System.out.println(c + 1);
                    sb.append(input.nextInt());
                } else {
                    sb.append(bitArr[0][c]);
                }
            }
            System.out.println(sb.toString());
            input.next();
        }
    }

    public static boolean checkCases(boolean[] cases) {
        int count = 0;
        for (boolean caseFlag : cases) {
            if (!caseFlag) {
                count++;
            }
        }
        return count == 1;
    }

    public static void cancel(int[][] bitArr, boolean[] cases, int chosen, int idx) {
        for (int i = 0; i < 4; i++) {
            if (!cases[i] && bitArr[i][idx] != chosen) {
                cases[i] = true;
            }
        }
    }

    public static int help(int[][] arr, boolean[] cases, int len, HashSet<Integer> toQ) {
        List<Integer> activeCases = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (!cases[i]) {
                activeCases.add(i);
            }
        }

        if (activeCases.size() == 4) {
            return getIdxToQuery4(arr, len);
        } else {
            int idx = getIdxToQuery2(arr[activeCases.get(0)], arr[activeCases.get(1)], len, toQ);
            if (idx == -1) {
                arr[0] = arr[activeCases.get(0)].clone();
            }
            return idx;
        }
    }

    public static int getIdxToQuery4(int[][] arr, int len) {
        for (int i = 0; i < len; i++) {
            if (arr[0][i] == -1 || arr[1][i] == -1 || arr[2][i] == -1 || arr[3][i] == -1) {
                continue;
            }
            if (!(arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i] && arr[2][i] == arr[3][i])) {
                return i;
            }
        }
        return -1;
    }

    public static int getIdxToQuery2(int[] case1, int[] case2, int len, HashSet<Integer> toQ) {
        for (int i = 0; i < len; i++) {
            if (case1[i] == -1 || case2[i] == -1) {
                if (!(case1[i] == -1 && case2[i] == -1)) {
                    toQ.add(i);
                }
                continue;
            }
            if (case1[i] != case2[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void getCases(int[][] arr) {
        int len = arr[0].length;

        for (int i = 0; i < len; i++) {
            if (arr[0][i] == 1) {
                arr[1][i] = 0;
            } else if (arr[0][i] == 0) {
                arr[1][i] = 1;
            } else {
                arr[1][i] = arr[0][i];
            }
        }

        for (int f = 0, b = len - 1; f <= b; f++, b--) {
            arr[2][b] = arr[0][f];
            arr[2][f] = arr[0][b];
        }

        for (int i = 0; i < len; i++) {
            if (arr[2][i] == 1) {
                arr[3][i] = 0;
            } else if (arr[2][i] == 0) {
                arr[3][i] = 1;
            } else {
                arr[3][i] = arr[2][i];
            }
        }
    }
}