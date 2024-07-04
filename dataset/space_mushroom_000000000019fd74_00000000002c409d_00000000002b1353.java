import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.*;

public class Solution{
    private static List<List<Integer>> triangle = new ArrayList<>();
    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));

    private static int getSum(List<Integer> list, int index){
        if(index == 0 || index == list.size())
            return 1;
        return list.get(index-1) + list.get(index);
    }

    private static void createTriangle(){
        triangle.add(new ArrayList<>(Collections.singletonList(1)));

        for(int i=1; i<500; i++){
            List<Integer> list = new ArrayList<>();

            for(int j=0; j<=i; j++){
                list.add(getSum(triangle.get(i-1), j));
            }

            triangle.add(list);
        }
    }

    private static class Move{
        private int r;
        private int k;

        public Move(int r, int k){
            this.r = r;
            this.k = k;
        }

        private String getMoveAsString(){
            return ""+(r+1)+" "+(k+1)+"\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Move)) return false;
            Move move = (Move) o;
            return r == move.r &&
                    k == move.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, k);
        }
    }

    private static int sumMoves(List<Move> moves){
        int sum = 0;
        for(Move move : moves){
            sum += triangle.get(move.r).get(move.k);
        }
        return sum;
    }

    private static void helper(List<Move> moves, int n, int r, int k){
        if(r < 0 || r >= 500 || k < 0 || k >= triangle.get(r).size())
            return;
        Move move = new Move(r,k);
        if(moves.contains(move))
            return;
        int sum = sumMoves(moves);
        if(sum == n)
            return;
        if(sum > n){
            moves.remove(moves.size()-1);
            return;
        }
        if(moves.size() == 500){
            moves.remove(moves.size()-1);
            return;
        }
        
        moves.add(move);
        helper(moves, n, r+1, k);
        helper(moves, n, r+1, k+1);
        helper(moves, n, r, k+1);
        helper(moves, n, r, k-1);
        helper(moves, n, r-1, k-1);
        helper(moves, n, r-1, k);
    }

    private static String solve(int n){
        ArrayList<Move> moves = new ArrayList<>();
        helper(moves, n, 0, 0);

        StringBuilder str = new StringBuilder("\n");
        for(Move move: moves)
            str.append(move.getMoveAsString());
        return str.toString();
    }

    public static void main(String[] args){
        int t = input.nextInt();
        input.nextLine();
        createTriangle();
        for(int i = 0; i < t; i++){
            int n = input.nextInt();
            System.out.println("Case #" + (i + 1) + ": " + solve(n));
        }
    }
}