import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    private static class Grid{
        private int n;
        private List<List<Cell>> grid;

        public Grid(int n) {
            this.n = n;
            grid = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Cell> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(new Cell(n));
                }
                grid.add(row);
            }
        }

        public void initialize(List<Integer> trace) {
            for (int i = 0; i < n; i++) {
                assign(i, i, trace.get(i));
            }
        }

        public void assign(int x, int y, int value){
            grid.get(x).get(y).numberAssigned = value;

            for(int i=0; i<n; i++){
                grid.get(x).get(i).removeFromAvailable(value);
                grid.get(i).get(y).removeFromAvailable(value);
            }
        }

        public boolean isEmpty(int x, int y) {
            return grid.get(x).get(y).isEmpty();
        }

        public boolean fillCellIfOnlyOneElementAvailable(int x) {
            for(int i=0; i<n; i++){
                if(grid.get(x).get(i).isEmpty() && grid.get(x).get(i).numbersAvailable.size() == 1){
                    assign(x, i, grid.get(x).get(i).numbersAvailable.get(0));
                    return true;
                }
            }
            return false;
        }

        public boolean fillCellIfOneElementCanFitOnlyOneCell(int x) {
            for(int num=1; num<=n; num++){
                Set<Integer> indices = new HashSet<>();
                for(int i=0; i<n; i++){
                    if(grid.get(x).get(i).isEmpty() && grid.get(x).get(i).numbersAvailable.contains(num))
                        indices.add(i);
                }
                if(indices.size() == 1){
                    assign(x, (int)(indices.toArray()[0]), num);
                    return true;
                }
            }
            return false;
        }

        public void assignFirst(int x, int y) {
            assign(x, y, grid.get(x).get(y).numbersAvailable.get(0));
        }

        private int minPossibilities(){
            int min = 100;
            for(int x=0; x<n; x++) {
                for (int y = 0; y < n; y++) {
                    int available = grid.get(x).get(y).numbersAvailable.size();
                    if(grid.get(x).get(y).isEmpty() && available < min)
                        min = available;
                }
            }
            return min;
        }

        public boolean assignFirstWithLeastPossibilities(){
            int minAvailable = minPossibilities();
            if(minAvailable == 100 || minAvailable == 0)
                return false;
            for(int x=0; x<n; x++) {
                for (int y = 0; y < n; y++) {
                    int available = grid.get(x).get(y).numbersAvailable.size();
                    if(grid.get(x).get(y).isEmpty() && available == minAvailable){
                        assignFirst(x, y);
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for(int x=0; x<n; x++){
                for(int y=0; y<n; y++){
                    if(y != 0)
                        stringBuilder.append(" ");
                    stringBuilder.append(grid.get(x).get(y).numberAssigned);
                }
                if(x != n-1)
                    stringBuilder.append("\r\n");
            }
            return stringBuilder.toString();
        }
    }

    private static class Cell{
        private List<Integer> numbersAvailable;
        private int numberAssigned;

        public Cell(int n){
            numbersAvailable = new ArrayList<>();
            for(int i=0; i<n; i++){
                numbersAvailable.add((i+1));
            }
            numberAssigned = 0;
        }

        public boolean isEmpty(){
            return numberAssigned == 0;
        }

        public void removeFromAvailable(int num){
            numbersAvailable.remove(Integer.valueOf(num));
        }
    }

    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));

    private static String solve(int n, int k){
        if(!checkIfPossibile(n, k))
            return "IMPOSSIBLE";
        List<Integer> trace = getTraceNumbers(n, k);

        Grid grid = new Grid(n);
        grid.initialize(trace);

        while (true){
            for(int row=0; row<n; row++) {
                while (grid.fillCellIfOnlyOneElementAvailable(row) || grid.fillCellIfOneElementCanFitOnlyOneCell(row));
            }
            if(!grid.assignFirstWithLeastPossibilities())
                break;
        }

        if(grid.minPossibilities() == 0)
            return "IMPOSSIBLE";

        return "POSSIBLE\r\n" + grid.toString();
    }

    private static List<Integer> getTraceNumbers(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int base = k/n;
        int module = k % n;

        if(module == 1){
            nums.add(base-1);
            nums.add(base+1);
            nums.add(base+1);
            for(int i=0; i<n-3; i++){
                nums.add(base);
            }
            return nums;
        }

        if(module == n-1){
            nums.add(base);
            nums.add(base);
            nums.add(base+2);
            for(int i=0; i<module-2; i++){
                nums.add(base+1);
            }
            return nums;
        }

        for(int i=0; i<(n-module); i++){
            nums.add(base);
        }
        for(int i=0; i<module; i++){
            nums.add(base+1);
        }

        return nums;
    }

    private static boolean checkIfPossibile(int n, int k) {
        if(n==k || n*n == k)
            return true;
        if(k <= n+1 || k >= n*n-1)
            return false;
        if(n==3 && (k==5 || k==7))
            return false;
        return true;
    }

    public static void main(String[] args){
        int t = input.nextInt();
        input.nextLine();
        for(int i = 0; i < t; i++){
            int n = input.nextInt();
            int k = input.nextInt();
            System.out.println("Case #" + (i + 1) + ": " + solve(n, k));
        }
    }
}