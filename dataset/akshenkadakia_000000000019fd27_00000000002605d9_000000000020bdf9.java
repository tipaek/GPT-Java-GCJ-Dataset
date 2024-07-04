import java.io.*;
import java.util.*;

public class Solution {
// public class parenting_partnering {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int caseN = 1;

        while (caseN <= T) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Task> J = new TreeMap<>();
            TreeMap<Integer, Task> C = new TreeMap<>();
            boolean possible = true;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (possible) {
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());
                    Task newTask = new Task(i, start, end);

                    boolean canFitJ = true;
                    boolean canFitC = true;

                    boolean canFitLowerJ = false, canFitHigherJ = false;
                    boolean canFitLowerC = false, canFitHigherC = false;

                    Map.Entry<Integer, Task> lowerJ = null, higherJ = null, lowerC = null, higherC = null;


                    if (J.get(start) == null) {
                        lowerJ = J.floorEntry(start);
                        higherJ = J.higherEntry(start);
                        if (lowerJ != null && start < lowerJ.getValue().end) {
                            canFitJ = false;
                        } else if (higherJ != null && start < higherJ.getKey()) {
                            canFitLowerJ = true;
                        }
                        if (higherJ != null && higherJ.getKey() < end) {
                            canFitJ = false;
                        } else if (lowerJ != null && lowerJ.getValue().end < end) {
                            canFitHigherJ = true;
                        }
                    } else {
                        canFitJ = false;
                    }

                    if (C.get(start) == null) {
                        lowerC = C.floorEntry(start);
                        higherC = C.higherEntry(start);
                        if (lowerC != null && start < lowerC.getValue().end) {
                            canFitC = false;
                        } else if (higherC != null && start < higherC.getKey()) {
                            canFitLowerC = true;
                        }

                        if (higherC != null && higherC.getKey() < end) {
                            canFitC = false;
                        } else if (lowerC != null && lowerC.getValue().end < end) {
                            canFitHigherC = true;
                        }
                    } else {
                        canFitC = false;
                    }


                    if (canFitJ) {
                        J.put(start, newTask);
                    } else if (canFitC) {
                        C.put(start, newTask);
                    } else {
//                        System.out.println(J.toString());
//                        System.out.println(C.toString());
//                        System.out.println("" + canFitLowerJ);
//                        System.out.println("" + canFitHigherC);
//                        System.out.println("" + canFitLowerC);
//                        System.out.println("" + canFitHigherJ);

                        if ((canFitLowerJ && canFitHigherC) || (canFitHigherJ && canFitLowerC)) {
                            if (canFitLowerJ) {
                                if (lowerC != null && higherJ != null && lowerC.getValue().end > higherJ.getKey()) {
                                    possible = false;
                                }
                            } else {
                                if (lowerJ != null && higherC != null && lowerJ.getValue().end > higherC.getKey()) {
                                    possible = false;
                                }
                            }
                            if (possible) {
                                Map<Integer, Task> headJ = J.headMap(start);
                                Map<Integer, Task> tailJ = J.tailMap(start);

                                Map<Integer, Task> headC = C.headMap(start);
                                Map<Integer, Task> tailC = C.tailMap(start);

                                J = new TreeMap<>();
                                C = new TreeMap<>();

                                J.putAll(headJ);
                                J.putAll(tailC);

                                C.putAll(headC);
                                C.putAll(tailJ);

                                if (canFitLowerJ) {
                                    J.put(start, newTask);
                                } else {
                                    C.put(start, newTask);
                                }
//                                System.out.println(J.toString());
//                                System.out.println(C.toString());
                            }
                        } else {
                            possible = false;
                        }
                    }
                }
            }

            if (possible) {
                String[] arr = new String[N];
                for (Task x : J.values()) {
                    arr[x.number] = "J";
                }
                for (Task x : C.values()) {
                    arr[x.number] = "C";
                }

                System.out.printf("Case #%d: %s\n", caseN, String.join("", arr));
            } else {
                System.out.printf("Case #%d: %s\n", caseN, "IMPOSSIBLE");
            }
            caseN++;
        }
    }
}

class Task {
    int start, end, number;

    Task(int number, int start, int end) {
        this.number = number;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Task{" +
                "start=" + start +
                ", end=" + end +
                ", number=" + number +
                '}';
    }
}
