import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int bit_count = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < t; i++) {
            solve(scanner, i+1, bit_count);
        }
    }

    //Regular 0001 10 1111
    //Reverse 1111 01 1000
    //Inverse 1110 01 0000
    //Both    0000 10 0111

    public static void solve(Scanner in, int id, int bit_count) {
        //Currently known state (Shifted by 1!)
        boolean[] state = new boolean[bit_count];
        int nextQuery = 0;
        int queryCount = 0;

        while(nextQuery < (bit_count + 1) / 2) {
            //We need more bits, fix current state
            if(queryCount != 0 && queryCount % 10 == 0) {
                fix(state, in, nextQuery);
                queryCount += 2;
            }

            //Read 2
            System.out.println(nextQuery + 1);
            state[nextQuery] = nextChar(in) == '1';

            System.out.println((bit_count - nextQuery - 1) + 1);
            state[bit_count - nextQuery - 1] = nextChar(in) == '1';

            //Update state
            nextQuery++;
            queryCount += 2;
        }

        for(int i = 0; i < bit_count; i++) {
            System.out.print(state[i] ? "1" : "0");
        }
        System.out.println();
    }

    private static void fix(boolean[] array, Scanner in, int nextQuery) {
        int same = findSame(array, nextQuery);
        int different = findDifferent(array, nextQuery);
        if(same == -1 && different == -1) throw new IllegalStateException();
        else if(same == -1 || different == -1) {
            //If it changed, invert
            int index = same;
            if(same == -1) index = different;
            System.out.println(index + 1);
            char result = nextChar(in);
            if((result == '1') != array[index]) invert(array);

            //We have to do 2 queries
            System.out.println(index + 1);
            nextChar(in);
        } else {
            System.out.println(same + 1);
            boolean sameChanged = (nextChar(in) == '1') != array[same];
            System.out.println(different + 1);
            boolean differentChanged = (nextChar(in) == '1') != array[different];

            if(!sameChanged && !differentChanged) return;
            else if(!sameChanged && differentChanged) {
                reverse(array);
            }else if(sameChanged && differentChanged) {
                invert(array);
            }else{ //sameChanged && !differentChanged
                reverse(array); invert(array);
            }
        }
    }

    private static int findSame(boolean[] array, int nextQuery) {
        for(int i = 0; i < nextQuery; i++) {
            if(array[i] == array[array.length - i - 1]) return i;
        }
        return -1;
    }

    private static int findDifferent(boolean[] array, int nextQuery) {
        for(int i = 0; i < nextQuery; i++) {
            if(array[i] != array[array.length - i - 1]) return i;
        }
        return -1;
    }

    private static void reverse(boolean[] array) {
        for(int i=0; i<array.length/2; i++){
            boolean temp = array[i];
            array[i] = array[array.length -i -1];
            array[array.length -i -1] = temp;
        }
    }

    private static void invert(boolean[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = !array[i];
        }
    }

    private static char nextChar(Scanner in) {
        char c = in.nextLine().charAt(0);
        if(c == 'N') System.exit(1);
        return c;
    }
}