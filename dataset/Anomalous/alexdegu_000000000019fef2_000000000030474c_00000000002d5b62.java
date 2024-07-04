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

            int[] listMax = new int[8];
            List<Integer> listXSol1 = new ArrayList<>();
            List<Integer> listXSol2 = new ArrayList<>();

            solveX(x, listXSol1, listXSol2, listMax);

            List<Integer> listYSol1 = new ArrayList<>();
            List<Integer> listYSol2 = new ArrayList<>();
            List<Integer> listYSol3 = new ArrayList<>();
            List<Integer> listYSol4 = new ArrayList<>();
            boolean[] list = new boolean[8];

            solveY(y - 1, listYSol1, listYSol2, listXSol1, listXSol2, listMax, list, 0);
            solveY(y + 1, listYSol3, listYSol4, listXSol1, listXSol2, listMax, list, 4);

            determineSolution(x, y, xOdd, listXSol1, listXSol2, listYSol1, listYSol2, listYSol3, listYSol4, listMax, list, l);
        }
    }

    private static void solveX(int x, List<Integer> listXSol1, List<Integer> listXSol2, int[] listMax) {
        if (x != 0) {
            int num = (int) (Math.log(Math.abs(x)) / Math.log(2));
            if (Math.abs(x) == Math.pow(2, num)) {
                listXSol1.add(num);
                listXSol2.add(num);
                Arrays.fill(listMax, num);
            } else {
                for (int i = 0; i < 8; i++) {
                    listMax[i] = (i % 4 <= 1) ? num : num + 1;
                }
                calculateList(x, listXSol1, num);
                calculateList((int) Math.pow(2, num + 1) - Math.abs(x), listXSol2, num);
            }
        }
    }

    private static void solveY(int y, List<Integer> listYSol1, List<Integer> listYSol2, List<Integer> listXSol1, List<Integer> listXSol2, int[] listMax, boolean[] list, int offset) {
        if (y != 0) {
            int num = (int) (Math.log(Math.abs(y)) / Math.log(2));
            if (Math.abs(y) == Math.pow(2, num)) {
                for (int i = offset; i < offset + 4; i++) {
                    if (listMax[i] < num) {
                        listMax[i] = num;
                    }
                }
                listYSol1.add(num);
                listYSol2.add(num);
                updateList(list, listXSol1, listXSol2, num, offset);
            } else {
                for (int i = offset; i < offset + 2; i++) {
                    if (listMax[i] < num) {
                        listMax[i] = num;
                    }
                }
                for (int i = offset + 2; i < offset + 4; i++) {
                    if (listMax[i] < num + 1) {
                        listMax[i] = num + 1;
                    }
                }
                calculateList(y, listYSol1, num, list, listXSol1, listXSol2, offset);
                calculateList((int) Math.pow(2, num + 1) - Math.abs(y), listYSol2, num, list, listXSol1, listXSol2, offset + 1);
            }
        }
    }

    private static void calculateList(int value, List<Integer> list, int num) {
        int remainder = Math.abs(value) - (int) Math.pow(2, num);
        while (remainder > 0) {
            if (remainder >= Math.pow(2, num - 1)) {
                remainder -= Math.pow(2, num - 1);
                list.add(num - 1);
            }
            num--;
        }
    }

    private static void calculateList(int value, List<Integer> list, int num, boolean[] listFlags, List<Integer> listXSol1, List<Integer> listXSol2, int flagIndex) {
        int remainder = Math.abs(value) - (int) Math.pow(2, num);
        while (remainder > 0 && (!listFlags[flagIndex] || !listFlags[flagIndex + 2])) {
            if (remainder >= Math.pow(2, num - 1)) {
                if (listXSol1.contains(num - 1)) {
                    listFlags[flagIndex] = true;
                }
                if (listXSol2.contains(num - 1)) {
                    listFlags[flagIndex + 2] = true;
                }
                remainder -= Math.pow(2, num - 1);
                list.add(num - 1);
            }
            num--;
        }
    }

    private static void updateList(boolean[] listFlags, List<Integer> listXSol1, List<Integer> listXSol2, int num, int offset) {
        if (listXSol1.contains(num)) {
            listFlags[offset] = true;
            listFlags[offset + 1] = true;
        }
        if (listXSol2.contains(num)) {
            listFlags[offset + 2] = true;
            listFlags[offset + 3] = true;
        }
    }

    private static void determineSolution(int x, int y, boolean xOdd, List<Integer> listXSol1, List<Integer> listXSol2, List<Integer> listYSol1, List<Integer> listYSol2, List<Integer> listYSol3, List<Integer> listYSol4, int[] listMax, boolean[] list, int caseNumber) {
        boolean ok = false;
        int min = Integer.MAX_VALUE;
        int curr = -1;

        for (int i = 0; i < 8; i++) {
            if (!list[i] && listMax[i] == getTotalSize(i, listXSol1, listXSol2, listYSol1, listYSol2, listYSol3, listYSol4) && min > listMax[i]) {
                ok = true;
                min = listMax[i];
                curr = i;
            }
        }

        if (ok) {
            List<Integer> firstList = getFirstList(curr, listXSol1, listXSol2);
            List<Integer> secondList = getSecondList(curr, listYSol1, listYSol2, listYSol3, listYSol4);

            Collections.sort(firstList);
            Collections.sort(secondList);

            String[] arr = new String[listMax[curr] + 1];
            fillArray(x, y, xOdd, curr, firstList, secondList, arr);

            StringBuilder sb = new StringBuilder();
            for (String s : arr) {
                sb.append(s);
            }
            System.out.println("Case #" + caseNumber + ": " + sb.toString());
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    private static int getTotalSize(int i, List<Integer> listXSol1, List<Integer> listXSol2, List<Integer> listYSol1, List<Integer> listYSol2, List<Integer> listYSol3, List<Integer> listYSol4) {
        switch (i) {
            case 0: return listXSol1.size() + listYSol1.size();
            case 1: return listXSol1.size() + listYSol2.size();
            case 2: return listXSol2.size() + listYSol1.size();
            case 3: return listXSol2.size() + listYSol2.size();
            case 4: return listXSol1.size() + listYSol3.size();
            case 5: return listXSol1.size() + listYSol4.size();
            case 6: return listXSol2.size() + listYSol3.size();
            case 7: return listXSol2.size() + listYSol4.size();
            default: return 0;
        }
    }

    private static List<Integer> getFirstList(int i, List<Integer> listXSol1, List<Integer> listXSol2) {
        switch (i) {
            case 0:
            case 1:
            case 4:
            case 5: return listXSol1;
            case 2:
            case 3:
            case 6:
            case 7: return listXSol2;
            default: return new ArrayList<>();
        }
    }

    private static List<Integer> getSecondList(int i, List<Integer> listYSol1, List<Integer> listYSol2, List<Integer> listYSol3, List<Integer> listYSol4) {
        switch (i) {
            case 0:
            case 2: return listYSol1;
            case 1:
            case 3: return listYSol2;
            case 4:
            case 6: return listYSol3;
            case 5:
            case 7: return listYSol4;
            default: return new ArrayList<>();
        }
    }

    private static void fillArray(int x, int y, boolean xOdd, int curr, List<Integer> firstList, List<Integer> secondList, String[] arr) {
        if (xOdd) {
            arr[0] = (curr < 4) ? "E" : "W";
            fillDirectionArray(secondList, arr, x < 0, "E", "W");
            fillDirectionArray(firstList, arr, y < 0, "N", "S");
        } else {
            arr[0] = (curr < 4) ? "N" : "S";
            fillDirectionArray(secondList, arr, y < 0, "N", "S");
            fillDirectionArray(firstList, arr, x < 0, "E", "W");
        }
    }

    private static void fillDirectionArray(List<Integer> list, String[] arr, boolean isNegative, String positiveDir, String negativeDir) {
        if (list.size() > 0) {
            if (isNegative) {
                if (list.get(list.size() - 1) > Math.abs(isNegative ? -1 : 1)) {
                    for (int i = 0; i < list.size() - 1; i++) {
                        arr[list.get(i)] = positiveDir;
                    }
                    arr[list.get(list.size() - 1)] = negativeDir;
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        arr[list.get(i)] = negativeDir;
                    }
                }
            } else {
                if (list.get(list.size() - 1) > Math.abs(isNegative ? -1 : 1)) {
                    for (int i = 0; i < list.size() - 1; i++) {
                        arr[list.get(i)] = negativeDir;
                    }
                    arr[list.get(list.size() - 1)] = positiveDir;
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        arr[list.get(i)] = positiveDir;
                    }
                }
            }
        }
    }
}