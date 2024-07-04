import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        in.nextLine();
        for(int id = 1; id <= t; id++) {
            solution(in, id);
        }
    }

    private static void solution(Scanner in, int id) {
        int alreadyBy = in.nextInt();
        int sortBy = in.nextInt();
        //1..ab 1..ab (sb times)
        int[] array = new int[sortBy * alreadyBy];
        for(int i = 0; i < sortBy; i++) {
            for(int j = 0; j < alreadyBy; j++) {
                array[i*alreadyBy+j] = j+1;
            }
        }
        int[] sorted = array.clone();
        Arrays.sort(sorted);


        //Repeatedly take
        ArrayList<Move> moves = new ArrayList<>();
        while(true) {
            //Find first highest not sorted
            int highest = -1;
            int highest_i = -1;
            for (int i = 0; i < array.length; i++) {
                if(array[i] > highest && array[i] != sorted[i]) {
                    highest_i = i;
                    highest = array[i];

                }
            }
            if(highest_i == -1) break;

            //Find last not sorted
            int last_not_sorted = -1;
            for(int i = array.length - 1; i >= 0; i--) {
                if(array[i] != sorted[i]){
                    last_not_sorted = i;
                    break;
                }
            }

            //Perform swap
            int a = highest_i + 1;
            int b = last_not_sorted - highest_i;
            moves.add(new Move(a, b));
            int[] a_range = Arrays.copyOfRange(array, 0, a);
            int i = 0;
            for(; i < b; i++) {
                array[i] = array[a+i];
            }
            for(; i < a+b; i++) {
                array[i] = a_range[i-b];
            }
        }

        System.out.println("Case #" + id + ": " + moves.size());
        for(Move move : moves) {
            System.out.println(move.a + " " + move.b);
        }
    }
}

class Move {
    int a;
    int b;

    public Move(int a, int b) {
        this.a = a;
        this.b = b;
    }
}