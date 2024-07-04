import java.util.*;
import java.io.*;

public class Solution {
    private static int B;
    private static int query_time = 0;

    enum fluctuation {
        None,
        Comp,
        Rev,
        Comp_Rev,
        None_or_Rev,
        Comp_or_Comp_Rev,
        None_or_Comp_Rev,
        Comp_or_Rev,
    }

    static void readPair(Scanner sc, int[] bits, int index) {
        System.out.println(index + 1);
        bits[index] = sc.nextInt();
        query_time++;

        System.out.println(B - index);
        bits[B - index - 1] = sc.nextInt();
        query_time++;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = sc.nextInt();
        B = sc.nextInt();
        for (int k = 1; k <= testCase; k++) {
            query_time = 0;
            int bits[] = new int[B];
            for (int i = 0; i < B; i++) {
                bits[i] = -1;
            }

            int index = 0;
            int index_same = -1;
            int index_not_same = -1;
            for (int i = 0; i < 5; i++) {
                index = i;
                readPair(sc, bits, index);
                if (index_same == -1 && bits[index] == bits[B - index - 1]) {
                    index_same = index;
                }
                if (index_not_same == -1 && bits[index] != bits[B - index - 1]) {
                    index_not_same = index;
                }
            }
            List<fluctuation> history = new ArrayList<>();
            List<Integer> index_history = new ArrayList<>();
            index++;
            index_history.add(index);

            while (index < B / 2) {
                if (index_same == -1 || index_not_same == -1) {
                    int current_0 = bits[0];
                    readPair(sc, bits, 0);
                    if (index_not_same == -1) { // All pairs with index under {@code index} are same bits
                        if (current_0 == bits[0]) {
                            history.add(fluctuation.None_or_Rev);
                        } else {
                            history.add(fluctuation.Comp_or_Comp_Rev);
                        }
                    } else {
                        if (current_0 == bits[0]) {
                            history.add(fluctuation.None_or_Comp_Rev);
                        } else {
                            history.add(fluctuation.Comp_or_Rev);
                        }
                    }
                    for (int i = 0; i < 4; i++) {
                        if (index >= B / 2) break;
                        readPair(sc, bits, index);
                        if (index_same == -1 && bits[index] == bits[B - index - 1]) {
                            index_same = index;
                        }
                        if (index_not_same == -1 && bits[index] != bits[B - index - 1]) {
                            index_not_same = index;
                        }
                        index++;
                    }
                } else {
                    int current_index_same = bits[index_same];


                    System.out.println(index_same + 1);
                    bits[index_same] = sc.nextInt();
                    bits[B - index_same - 1] = bits[index_same];
                    //readPair(sc, bits, index_same);
                    int current_index_not_same = bits[index_not_same];


                    System.out.println(index_not_same + 1);
                    bits[index_not_same] = sc.nextInt();
                    bits[B - index_not_same - 1] = bits[index_not_same] == 0 ? 1 : 0;
                    //readPair(sc, bits, index_not_same);
                    if (current_index_same == bits[index_same]) {
                        if (current_index_not_same == bits[index_not_same]) {
                            history.add(fluctuation.None);
                        } else {
                            history.add(fluctuation.Rev);
                        }
                    } else {
                        if (current_index_not_same == bits[index_not_same]) {
                            history.add(fluctuation.Comp_Rev);
                        } else {
                            history.add(fluctuation.Comp);
                        }
                    }
                    for (int i = 0; i < 4; i++) {
                        if (index >= B / 2) break;
                        readPair(sc, bits, index);
                        index++;
                    }
                }
                index_history.add(index);
            } // end of while

            for (int i = 0; i < history.size(); i++) {
                for (int j = 0, id = index_history.get(i); j < id; j++) {
                    if (j == index_same || j == index_not_same) {
                        continue;
                    }
                    fluctuation f = history.get(i);
                    switch(f) {
                        case None:
                            break;
                        case Comp:
                            bits[j] = bits[j] == 0 ? 1 : 0;
                            bits[B - j - 1] = bits[B - j - 1] == 0 ? 1 : 0;
                            break;
                        case Rev:
                            int tmp = bits[j];
                            bits[j] = bits[B - j - 1];
                            bits[B - j - 1] = tmp;
                            break;
                        case Comp_Rev:
                            bits[j] = bits[j] == 0 ? 1 : 0;
                            bits[B - j - 1] = bits[B - j - 1] == 0 ? 1 : 0;
                            int tmp1 = bits[j];
                            bits[j] = bits[B - j - 1];
                            bits[B - j - 1] = tmp1;
                            break;
                        case None_or_Rev:
                        case None_or_Comp_Rev:
                            break;
                        case Comp_or_Comp_Rev:
                        case Comp_or_Rev:
                            bits[j] = bits[j] == 0 ? 1 : 0;
                            bits[B - j - 1] = bits[B - j - 1] == 0 ? 1 : 0;
                            break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bits.length; i++) {
                sb.append(bits[i]);
            }

            System.out.println(sb.toString());
            String ans = sc.next();
            if (ans.equals("Y")) {
                continue;
            } else {
                break;
            }
        }
    }
}