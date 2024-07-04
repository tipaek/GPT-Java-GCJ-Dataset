
import java.util.*;
public class Solution {

    static int b;
    static int sameIndex = -1, diffIndex = -1; // array[sameIndex] and array[b-sameIndex-1] are equal
    static Scanner in;
    static int prevSameBit = -1, prevDiffBit = -1;
    static int queryCount; // if queryCount%10 == 0, next query will cause fluctuation
    static int[] array;
    static boolean swappedState = false;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int t = in.nextInt();
        b = in.nextInt();
        
        for (int ti = 1; ti <= t; ++ti) {
            sameIndex = -1;
            diffIndex = -1;
            prevSameBit = -1;
            prevDiffBit = -1;
            queryCount = 0;
            array = new int[b];

            findIndexes();

            for (int i=0; i<b; i++) {
                if (queryCount%10 == 0) {
                    fluctuate();
                }
                if (swappedState) {
                    array[b-i-1] = query(b-i-1);
                } else {
                    array[i] = query(i);
                }
            }

            printArray();

            String response = in.next();
            if (response.equals("N")) {
                System.out.println("Response is N");
                System.out.flush();
                System.exit(0);
            }
        }
    }

    //Should be called right before fluctuation
    static void findIndexes() {
        int i=0;
        while(sameIndex == -1 || diffIndex == -1) {
            if (queryCount%10 == 0) {
                // update the bit value after fluctuation
                if (sameIndex != -1) {
                    int s = query(sameIndex);
                    prevSameBit = s;
                    query(0);
                } else if (diffIndex != -1) {
                    int s = query(diffIndex);
                    prevDiffBit = s;
                    query(0);
                }
            }
            int val1 = query(i);
            int val2 = query(b-i-1);
            array[i] = val1;
            array[b-i-1] = val2;
            if (val1 == val2) {
                if (sameIndex == -1) {
                    sameIndex = i;
                    prevSameBit = val1;
                }
            } else {
                if (diffIndex == -1) {
                    diffIndex = i;
                    prevDiffBit = val1;
                }
            }
            i++;
            if (i >= b/2) {
                break;
            }
        }
    }

    // Find which effects occurred and apply them to array.
    // fluctuate uses 2 queries so 8 queries will be left until next one.
    // Make sure first query is the one that fluctuates.
    static void fluctuate() {
        if (diffIndex == -1) {
            int s = query(sameIndex);
            if (s != prevSameBit) {
                inverse();
                prevSameBit = s;
            }
        } else if (sameIndex == -1) {
            int d = query(diffIndex);
            if (d != prevDiffBit) {
                swap();
                prevDiffBit = d;
            }
        } else {
            int s = query(sameIndex);
            int d = query(diffIndex);

            if (s == prevSameBit && d != prevDiffBit) {
                swap();
            } else if (s != prevSameBit && d == prevDiffBit) {
                swapInverse();
            } else if (s != prevSameBit && d != prevDiffBit) {
                inverse();
            } // else no change

            prevSameBit = s;
            prevDiffBit = d;
        }
    }

    static void inverse() {
        for (int i=0; i<b; i++) {
            array[i] = (array[i]+1)%2;
        }
    }

    static void swap() {
        for (int i=0, j=b-1; i<j; i++,j--) {
            int v = array[i];
            array[i] = array[j];
            array[j] = v;
        }
        swappedState = !swappedState;
    }

    static void swapInverse() {
        for (int i=0, j=b-1; i<j; i++,j--) {
            int v = array[i];
            array[i] = (array[j]+1)%2;
            array[j] = (v+1)%2;
        }
        swappedState = !swappedState;
    }

    static int query(int index) {
        queryCount++;
        System.out.println(index+1);
        System.out.flush();
        int val = in.nextInt();
        return val;
    }

    static void printArray() {
        for (int i=0; i<b; i++) {
            System.out.print(array[i]);
        }
        System.out.print("\n");
        System.out.flush();
    }
}
