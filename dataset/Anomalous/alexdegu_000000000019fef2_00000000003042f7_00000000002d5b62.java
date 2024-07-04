import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int l = 1; l <= t; ++l) {
            int x = in.nextInt();
            int y = in.nextInt();
            boolean xOdd = x % 2 != 0;
            boolean yOdd = y % 2 != 0;

            if (xOdd == yOdd) {
                System.out.println("Case #" + l + ": IMPOSSIBLE");
                continue;
            }

            if (xOdd) {
                int temp = x;
                x = y;
                y = temp;
            }

            int[] maxList = new int[8];
            List<Integer> xSol1 = new ArrayList<>();
            List<Integer> xSol2 = new ArrayList<>();

            if (x != 0) {
                int num = (int) (Math.log(Math.abs(x)) / Math.log(2));
                if (Math.abs(x) == Math.pow(2, num)) {
                    Arrays.fill(maxList, num);
                    xSol1.add(num);
                    xSol2.add(num);
                } else {
                    for (int i = 0; i < 8; i++) {
                        maxList[i] = (i % 4 <= 1) ? num : num + 1;
                    }

                    fillSolution(x, num, xSol1);
                    fillSolution((int) Math.pow(2, num + 1) - Math.abs(x), num, xSol2);
                }
            }

            List<Integer> ySol1 = new ArrayList<>();
            List<Integer> ySol2 = new ArrayList<>();
            List<Integer> ySol3 = new ArrayList<>();
            List<Integer> ySol4 = new ArrayList<>();
            boolean[] list = new boolean[8];

            processY(y - 1, maxList, xSol1, xSol2, ySol1, ySol2, list, 0);
            processY(y + 1, maxList, xSol1, xSol2, ySol3, ySol4, list, 4);

            boolean ok = false;
            int min = Integer.MAX_VALUE;
            int curr = -1;

            for (int i = 0; i < 8; i++) {
                if (!list[i] && maxList[i] == getSolutionSize(i, xSol1, xSol2, ySol1, ySol2, ySol3, ySol4) && min > maxList[i]) {
                    ok = true;
                    min = maxList[i];
                    curr = i;
                }
            }

            if (ok) {
                List<Integer> firstList = new ArrayList<>();
                List<Integer> secondList = new ArrayList<>();
                setSolutionLists(curr, xSol1, xSol2, ySol1, ySol2, ySol3, ySol4, firstList, secondList);

                Collections.sort(firstList);
                Collections.sort(secondList);

                String[] arr = new String[maxList[curr] + 1];
                fillArray(xOdd, curr, x, y, firstList, secondList, arr);

                StringBuilder sb = new StringBuilder();
                for (String s : arr) {
                    sb.append(s);
                }
                System.out.println("Case #" + l + ": " + sb.toString());
            } else {
                System.out.println("Case #" + l + ": IMPOSSIBLE");
            }
        }
    }

    private static void fillSolution(int x, int num, List<Integer> sol) {
        int xRemaining = Math.abs(x) - (int) Math.pow(2, num);
        while (xRemaining > 0) {
            if (xRemaining >= Math.pow(2, num - 1)) {
                xRemaining -= Math.pow(2, num - 1);
                sol.add(num - 1);
            }
            num--;
        }
    }

    private static void processY(int y, int[] maxList, List<Integer> xSol1, List<Integer> xSol2, List<Integer> ySol1, List<Integer> ySol2, boolean[] list, int offset) {
        if (y != 0) {
            int num = (int) (Math.log(Math.abs(y)) / Math.log(2));
            if (Math.abs(y) == Math.pow(2, num)) {
                for (int i = offset; i < offset + 4; i++) {
                    maxList[i] = Math.max(maxList[i], num);
                }
                ySol1.add(num);
                ySol2.add(num);
                if (xSol1.contains(num)) {
                    list[offset] = true;
                    list[offset + 1] = true;
                }
                if (xSol2.contains(num)) {
                    list[offset + 2] = true;
                    list[offset + 3] = true;
                }
            } else {
                for (int i = offset; i < offset + 2; i++) {
                    maxList[i] = Math.max(maxList[i], num);
                }
                for (int i = offset + 2; i < offset + 4; i++) {
                    maxList[i] = Math.max(maxList[i], num + 1);
                }

                fillSolution(y, num, ySol1, xSol1, xSol2, list, offset);
                fillSolution((int) Math.pow(2, num + 1) - Math.abs(y), num, ySol2, xSol1, xSol2, list, offset + 1);
            }
        }
    }

    private static void fillSolution(int y, int num, List<Integer> sol, List<Integer> xSol1, List<Integer> xSol2, boolean[] list, int offset) {
        int yRemaining = Math.abs(y) - (int) Math.pow(2, num);
        while (yRemaining > 0 && (!list[offset] || !list[offset + 2])) {
            if (yRemaining >= Math.pow(2, num - 1)) {
                if (xSol1.contains(num - 1)) {
                    list[offset] = true;
                }
                if (xSol2.contains(num - 1)) {
                    list[offset + 2] = true;
                }
                yRemaining -= Math.pow(2, num - 1);
                sol.add(num - 1);
            }
            num--;
        }
    }

    private static int getSolutionSize(int index, List<Integer> xSol1, List<Integer> xSol2, List<Integer> ySol1, List<Integer> ySol2, List<Integer> ySol3, List<Integer> ySol4) {
        switch (index) {
            case 0:
                return xSol1.size() + ySol1.size();
            case 1:
                return xSol1.size() + ySol2.size();
            case 2:
                return xSol2.size() + ySol1.size();
            case 3:
                return xSol2.size() + ySol2.size();
            case 4:
                return xSol1.size() + ySol3.size();
            case 5:
                return xSol1.size() + ySol4.size();
            case 6:
                return xSol2.size() + ySol3.size();
            case 7:
                return xSol2.size() + ySol4.size();
            default:
                return Integer.MAX_VALUE;
        }
    }

    private static void setSolutionLists(int curr, List<Integer> xSol1, List<Integer> xSol2, List<Integer> ySol1, List<Integer> ySol2, List<Integer> ySol3, List<Integer> ySol4, List<Integer> firstList, List<Integer> secondList) {
        switch (curr) {
            case 0:
                firstList.addAll(xSol1);
                secondList.addAll(ySol1);
                break;
            case 1:
                firstList.addAll(xSol1);
                secondList.addAll(ySol2);
                break;
            case 2:
                firstList.addAll(xSol2);
                secondList.addAll(ySol1);
                break;
            case 3:
                firstList.addAll(xSol2);
                secondList.addAll(ySol2);
                break;
            case 4:
                firstList.addAll(xSol1);
                secondList.addAll(ySol3);
                break;
            case 5:
                firstList.addAll(xSol1);
                secondList.addAll(ySol4);
                break;
            case 6:
                firstList.addAll(xSol2);
                secondList.addAll(ySol3);
                break;
            case 7:
                firstList.addAll(xSol2);
                secondList.addAll(ySol4);
                break;
        }
    }

    private static void fillArray(boolean xOdd, int curr, int x, int y, List<Integer> firstList, List<Integer> secondList, String[] arr) {
        if (xOdd) {
            arr[0] = (curr < 4) ? "E" : "W";
            fillDirectionArray(secondList, x, arr, "E", "W");
            fillDirectionArray(firstList, y, arr, "N", "S");
        } else {
            arr[0] = (curr < 4) ? "N" : "S";
            fillDirectionArray(secondList, y, arr, "N", "S");
            fillDirectionArray(firstList, x, arr, "E", "W");
        }
    }

    private static void fillDirectionArray(List<Integer> list, int value, String[] arr, String posDir, String negDir) {
        if (!list.isEmpty()) {
            if (value < 0) {
                if (list.get(list.size() - 1) > Math.abs(value)) {
                    for (int i = 0; i < list.size() - 1; i++) {
                        arr[list.get(i)] = posDir;
                    }
                    arr[list.get(list.size() - 1)] = negDir;
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        arr[list.get(i)] = negDir;
                    }
                }
            } else {
                if (list.get(list.size() - 1) > Math.abs(value)) {
                    for (int i = 0; i < list.size() - 1; i++) {
                        arr[list.get(i)] = negDir;
                    }
                    arr[list.get(list.size() - 1)] = posDir;
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        arr[list.get(i)] = posDir;
                    }
                }
            }
        }
    }
}