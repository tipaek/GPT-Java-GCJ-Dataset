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

            if (x != 0) {
                int numX = (int) (Math.log(Math.abs(x)) / Math.log(2));

                if (Math.abs(x) == Math.pow(2, numX)) {
                    listXSol1.add(numX);
                    listXSol2.add(numX);
                    Arrays.fill(listMax, numX);
                } else {
                    for (int i = 0; i < 8; i++) {
                        listMax[i] = (i % 4 <= 1) ? numX : numX + 1;
                    }

                    listXSol1.add(numX);
                    int remainingX = Math.abs(x) - (int) Math.pow(2, numX);
                    while (remainingX > 0) {
                        if (remainingX >= Math.pow(2, numX - 1)) {
                            remainingX -= Math.pow(2, numX - 1);
                            listXSol1.add(numX - 1);
                        }
                        numX--;
                    }

                    listXSol2.add(numX + 1);
                    remainingX = (int) Math.pow(2, numX + 1) - Math.abs(x);
                    while (remainingX > 0) {
                        if (remainingX >= Math.pow(2, numX - 1)) {
                            remainingX -= Math.pow(2, numX - 1);
                            listXSol2.add(numX - 1);
                        }
                        numX--;
                    }
                }
            }

            List<Integer> listYSol1 = new ArrayList<>();
            List<Integer> listYSol2 = new ArrayList<>();
            List<Integer> listYSol3 = new ArrayList<>();
            List<Integer> listYSol4 = new ArrayList<>();
            boolean[] list = new boolean[8];

            processY(y - 1, listMax, listXSol1, listXSol2, listYSol1, listYSol2, list, 0, 4);
            processY(y + 1, listMax, listXSol1, listXSol2, listYSol3, listYSol4, list, 4, 8);

            boolean solutionFound = false;
            int minSteps = Integer.MAX_VALUE;
            int bestCaseIndex = -1;

            for (int i = 0; i < 8; i++) {
                if (!list[i] && listMax[i] == getTotalSteps(i, listXSol1, listXSol2, listYSol1, listYSol2, listYSol3, listYSol4) && minSteps > listMax[i]) {
                    solutionFound = true;
                    minSteps = listMax[i];
                    bestCaseIndex = i;
                }
            }

            if (solutionFound) {
                List<Integer> firstList = new ArrayList<>();
                List<Integer> secondList = new ArrayList<>();
                getLists(bestCaseIndex, listXSol1, listXSol2, listYSol1, listYSol2, listYSol3, listYSol4, firstList, secondList);

                Collections.sort(firstList);
                Collections.sort(secondList);

                String[] directions = new String[listMax[bestCaseIndex] + 1];
                fillDirections(xOdd, x, y, bestCaseIndex, firstList, secondList, directions);

                StringBuilder result = new StringBuilder();
                for (String direction : directions) {
                    result.append(direction);
                }
                System.out.println("Case #" + l + ": " + result.toString());
            } else {
                System.out.println("Case #" + l + ": IMPOSSIBLE");
            }
        }
    }

    private static void processY(int y, int[] listMax, List<Integer> listXSol1, List<Integer> listXSol2, List<Integer> listYSol1, List<Integer> listYSol2, boolean[] list, int startIndex, int endIndex) {
        int numY = (int) (Math.log(Math.abs(y)) / Math.log(2));

        if (Math.abs(y) == Math.pow(2, numY)) {
            for (int i = startIndex; i < startIndex + 2; i++) {
                if (listMax[i] < numY) {
                    listMax[i] = numY;
                }
            }

            listYSol1.add(numY);
            listYSol2.add(numY);
            if (listXSol1.contains(numY)) {
                list[startIndex] = true;
                list[startIndex + 1] = true;
            }
            if (listXSol2.contains(numY)) {
                list[startIndex + 2] = true;
                list[startIndex + 3] = true;
            }
        } else {
            for (int i = startIndex; i < startIndex + 2; i++) {
                if (listMax[i] < numY) {
                    listMax[i] = numY;
                }
            }
            for (int i = startIndex + 2; i < endIndex; i++) {
                if (listMax[i] < numY + 1) {
                    listMax[i] = numY + 1;
                }
            }

            listYSol1.add(numY);
            int remainingY = Math.abs(y) - (int) Math.pow(2, numY);
            while (remainingY > 0 && (!list[startIndex] || !list[startIndex + 2])) {
                if (remainingY >= Math.pow(2, numY - 1)) {
                    if (listXSol1.contains(numY - 1)) {
                        list[startIndex] = true;
                    }
                    if (listXSol2.contains(numY - 1)) {
                        list[startIndex + 2] = true;
                    }

                    remainingY -= Math.pow(2, numY - 1);
                    listYSol1.add(numY - 1);
                }
                numY--;
            }

            listYSol2.add(numY + 1);
            remainingY = (int) Math.pow(2, numY + 1) - Math.abs(y);
            while (remainingY > 0 && (!list[startIndex + 1] || !list[startIndex + 3])) {
                if (remainingY >= Math.pow(2, numY - 1)) {
                    if (listXSol1.contains(numY - 1)) {
                        list[startIndex + 1] = true;
                    }
                    if (listXSol2.contains(numY - 1)) {
                        list[startIndex + 3] = true;
                    }

                    remainingY -= Math.pow(2, numY - 1);
                    listYSol2.add(numY - 1);
                }
                numY--;
            }
        }
    }

    private static int getTotalSteps(int index, List<Integer> listXSol1, List<Integer> listXSol2, List<Integer> listYSol1, List<Integer> listYSol2, List<Integer> listYSol3, List<Integer> listYSol4) {
        switch (index) {
            case 0:
                return listXSol1.size() + listYSol1.size();
            case 1:
                return listXSol1.size() + listYSol2.size();
            case 2:
                return listXSol2.size() + listYSol1.size();
            case 3:
                return listXSol2.size() + listYSol2.size();
            case 4:
                return listXSol1.size() + listYSol3.size();
            case 5:
                return listXSol1.size() + listYSol4.size();
            case 6:
                return listXSol2.size() + listYSol3.size();
            case 7:
                return listXSol2.size() + listYSol4.size();
            default:
                return Integer.MAX_VALUE;
        }
    }

    private static void getLists(int index, List<Integer> listXSol1, List<Integer> listXSol2, List<Integer> listYSol1, List<Integer> listYSol2, List<Integer> listYSol3, List<Integer> listYSol4, List<Integer> firstList, List<Integer> secondList) {
        switch (index) {
            case 0:
                firstList.addAll(listXSol1);
                secondList.addAll(listYSol1);
                break;
            case 1:
                firstList.addAll(listXSol1);
                secondList.addAll(listYSol2);
                break;
            case 2:
                firstList.addAll(listXSol2);
                secondList.addAll(listYSol1);
                break;
            case 3:
                firstList.addAll(listXSol2);
                secondList.addAll(listYSol2);
                break;
            case 4:
                firstList.addAll(listXSol1);
                secondList.addAll(listYSol3);
                break;
            case 5:
                firstList.addAll(listXSol1);
                secondList.addAll(listYSol4);
                break;
            case 6:
                firstList.addAll(listXSol2);
                secondList.addAll(listYSol3);
                break;
            case 7:
                firstList.addAll(listXSol2);
                secondList.addAll(listYSol4);
                break;
        }
    }

    private static void fillDirections(boolean xOdd, int x, int y, int curr, List<Integer> firstList, List<Integer> secondList, String[] directions) {
        if (xOdd) {
            directions[0] = (curr < 4) ? "E" : "W";
            fillDirectionList(secondList, x, directions, "E", "W");
            fillDirectionList(firstList, y, directions, "N", "S");
        } else {
            directions[0] = (curr < 4) ? "N" : "S";
            fillDirectionList(secondList, y, directions, "N", "S");
            fillDirectionList(firstList, x, directions, "E", "W");
        }
    }

    private static void fillDirectionList(List<Integer> list, int value, String[] directions, String positiveDir, String negativeDir) {
        if (list.isEmpty()) return;

        if (value < 0) {
            if (list.get(list.size() - 1) > Math.abs(value)) {
                for (int i = 0; i < list.size() - 1; i++) {
                    directions[list.get(i)] = positiveDir;
                }
                directions[list.get(list.size() - 1)] = negativeDir;
            } else {
                for (int i = 0; i < list.size(); i++) {
                    directions[list.get(i)] = negativeDir;
                }
            }
        } else {
            if (list.get(list.size() - 1) > Math.abs(value)) {
                for (int i = 0; i < list.size() - 1; i++) {
                    directions[list.get(i)] = negativeDir;
                }
                directions[list.get(list.size() - 1)] = positiveDir;
            } else {
                for (int i = 0; i < list.size(); i++) {
                    directions[list.get(i)] = positiveDir;
                }
            }
        }
    }
}