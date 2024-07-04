import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        int size = (b + 1) / 2;
        StringBuilder sb = new StringBuilder(" ".repeat(b));
        
        for (int i = 0; i < t; i++) {
            Pair[] pairsArray = new Pair[size];
            Queue<Integer> myQueue = new LinkedList<>();
            Pair pairSame = null;
            Pair pairDiff = null;
            int query = 0;
            
            for (int j = 0; j < size; j++) {
                if (query / 10 != 0) {
                    int first = j + 1;
                    if (first == size && size % 2 == 1) {
                        System.out.println(first);
                        pairsArray[j] = new Pair(first, false, scanner.nextInt());
                        query++;
                        break;
                    }
                    System.out.println(first);
                    int bite = scanner.nextInt();
                    query++;
                    int end = b - j;
                    System.out.println(end);
                    int bite2 = scanner.nextInt();
                    query++;
                    boolean isDiff = bite != bite2;
                    if (isDiff) {
                        pairDiff = new Pair(first, isDiff, bite);
                    } else {
                        pairSame = new Pair(first, isDiff, bite);
                    }
                    pairsArray[j] = new Pair(first, isDiff, bite);
                } else {
                    System.out.println(pairSame.getIndex());
                    int value1 = scanner.nextInt();
                    System.out.println(pairDiff.getIndex());
                    int value2 = scanner.nextInt();
                    myQueue.add(whichChange(pairSame, pairDiff, value1, value2));
                    query += 2;
                }
            }

            int iteration = 1;
            while (!myQueue.isEmpty()) {
                int operation = myQueue.poll();
                int cur = iteration * 8;
                while (cur < size) {
                    if (operation == 1) {
                        pairsArray[cur].inverse();
                    } else if (operation == 2 || operation == 3) {
                        pairsArray[cur].inverseBit();
                    }
                    cur++;
                }
            }

            String r = "N";
            String r2 = "N";
            int operation = 4;
            while (r.equals("N") || r2.equals("N")) {
                int cur = 0;
                while (cur < size) {
                    if (operation == 1) {
                        pairsArray[cur].inverse();
                    } else if (operation == 2) {
                        pairsArray[cur].inverseBit();
                    } else if (operation == 3) {
                        pairsArray[cur].inverse2();
                    }
                    sb.setCharAt(cur, Character.forDigit(pairsArray[cur].getPrev(), 10));
                    sb.setCharAt(size - cur - 1, Character.forDigit(pairsArray[cur].getReversed(), 10));
                    cur++;
                }
                System.out.println(sb.toString());
                r = scanner.nextLine();
                r2 = scanner.nextLine();
                operation--;
            }
            System.out.println("");
        }
    }

    public static int whichChange(Pair pairSame, Pair pairDiff, int value1, int value2) {
        if (pairSame != null && pairDiff != null) {
            if (value1 == pairSame.getPrev()) {
                int operation = value2 == pairDiff.getPrev() ? 4 : 1;
                pairSame.setPrev(value1);
                pairDiff.setPrev(value2);
                return operation;
            } else {
                int operation = value2 == pairDiff.getPrev() ? 3 : 2;
                pairSame.setPrev(value1);
                pairDiff.setPrev(value2);
                return operation;
            }
        }
        return 4;
    }
}

class Pair {
    private int index;
    private boolean diff;
    private int prev;

    public Pair(int index, boolean diff, int prev) {
        this.index = index;
        this.diff = diff;
        this.prev = prev;
    }

    public int getIndex() {
        return index;
    }

    public int getPrev() {
        return prev;
    }

    public boolean getDiff() {
        return diff;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public void inverse() {
        if (diff) {
            prev = 1 - prev;
        }
    }

    public void inverseBit() {
        prev = 1 - prev;
    }

    public void inverse2() {
        if (!diff) {
            prev = 1 - prev;
        }
    }

    public int getReversed() {
        return diff ? 1 - prev : prev;
    }
}