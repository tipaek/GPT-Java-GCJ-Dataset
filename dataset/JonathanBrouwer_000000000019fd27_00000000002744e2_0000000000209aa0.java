import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            solve(scanner, i + 1);
        }
    }

    public static void solve(Scanner in, int id) {
        int matrix_size = in.nextInt();
        int required_trace = in.nextInt();

        //Check if it's possibles
        int[] diagonal = find_diagonal(matrix_size, required_trace);
        if(diagonal == null) {
            System.out.println("Case #" + id + ": IMPOSSIBLE");
            return;
        }else{
            System.out.println("Case #" + id + ": POSSIBLE");
            int[][] completed = complete(diagonal);
            for(int i = 0; i < matrix_size; i++) {
                for(int j = 0; j < matrix_size; j++) {
                    System.out.print(completed[i][j] + " ");
                }
                System.out.println();
            }
        }


    }

    private static int[][] complete(int[] diagonal) {
        int[][] starting_choices = new int[diagonal.length][diagonal.length];
        for(int i = 0; i < diagonal.length; i++) {
            for(int j = 0; j < diagonal.length; j++) {
                starting_choices[i][j] = (new Coordinate(i, j).hashCode() % diagonal.length) + 1;
            }
        }

        //Make empty field and set diagonal
        int[][] current_grid = new int[diagonal.length][diagonal.length];
        for(int i = 0; i < diagonal.length; i++) {
            current_grid[i][i] = diagonal[i];
        }

        //Keep trying to find good field
        Coordinate current_coordinate = new Coordinate(0, 0);
        loop: while(true) {
            //Are we there yet?
            if(current_coordinate == null) {
                return current_grid;
            }

            //Don't try to change diagonal
            if(current_coordinate.a == current_coordinate.b) {
                current_coordinate = current_coordinate.next(diagonal.length);
                continue;
            }

            //Set current coordinate
            {
                int starting_choice = starting_choices[current_coordinate.a][current_coordinate.b];
                int try_value = starting_choice;
                do {
                    //If it's possible to try this, continue with the next
                    if (is_possible(current_grid, current_coordinate, try_value)) {
                        current_grid[current_coordinate.a][current_coordinate.b] = try_value;
                        current_coordinate = current_coordinate.next(current_grid.length);
                        continue loop;
                    }

                    //Next value to try
                    try_value++;
                    if(try_value > current_grid.length) try_value -= current_grid.length;
                } while (try_value != starting_choice);
            }

            //It didn't work, we need to backtrack :c
            {
                current_grid[current_coordinate.a][current_coordinate.b] = 0;
                current_coordinate = current_coordinate.previous(diagonal.length);
                while (current_coordinate != null) {
                    //Don't try to change diagonal
                    if(current_coordinate.a == current_coordinate.b) {
                        current_coordinate = current_coordinate.previous(diagonal.length);
                        continue;
                    }

                    //Continue
                    int starting_choice = starting_choices[current_coordinate.a][current_coordinate.b];
                    int try_value = current_grid[current_coordinate.a][current_coordinate.b];

                    //Try further values for this
                    try_value++;
                    if(try_value > current_grid.length) try_value -= current_grid.length;

                    while(try_value != starting_choice) {
                        //If this is possible, continue
                        if(is_possible(current_grid, current_coordinate, try_value)) {
                            current_grid[current_coordinate.a][current_coordinate.b] = try_value;
                            current_coordinate = current_coordinate.next(current_grid.length);
                            continue loop;
                        }

                        //Next value to try
                        try_value++;
                        if(try_value > current_grid.length) try_value -= current_grid.length;
                    }

                    //We need to backtrack further
                    current_grid[current_coordinate.a][current_coordinate.b] = 0;
                    current_coordinate = current_coordinate.previous(diagonal.length);
                }
            }

            throw new IllegalStateException();
        }
    }

    private static boolean is_possible(int[][] grid, Coordinate coord, int value) {
        //Check row
        for(int i = 0; i < grid.length; i++) {
            if(grid[coord.a][i] != 0 && grid[coord.a][i] == value) return false;
            if(grid[i][coord.b] != 0 && grid[i][coord.b] == value) return false;
        }
        return true;
    }

    private static int[] find_diagonal(int matrix_size, int to_distribute) {
        int[] diagonal = new int[matrix_size];
        if(partition(to_distribute, diagonal, 0)){
            return diagonal;
        }else{
            return null;
        }
    }

    private static boolean partition(int left, int[] diagonal, int from) {
        if(from == diagonal.length) {
//            System.err.println(Arrays.toString(diagonal));
            return Arrays.stream(diagonal).boxed().collect(
                    Collectors.groupingBy(
                            Function.identity(), Collectors.counting()
                    )
            ).values().stream().max(Long::compareTo).get() != diagonal.length - 1;
        }

        //Calculate the least elements we must use here
        int most_next = diagonal.length * (diagonal.length - from - 1);
        int least_here = left - most_next;
        assert least_here <= diagonal.length;
        least_here = Math.max(1, least_here);

        //Calculate the most elements we can use here
        int least_next = diagonal.length - from - 1;
        int most_here = left - least_next;
        assert most_here >= 1;
        most_here = Math.min(diagonal.length, most_here);

        for(int use_here = least_here; use_here <= most_here; use_here++) {
            diagonal[from] = use_here;
            if(partition(left - use_here, diagonal, from + 1)) return true;
        }
        return false;
    }
}

class Coordinate {
    int a;
    int b;

    public Coordinate(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return a == that.a &&
                b == that.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public Coordinate next(int size) {
        if(a+1 == size && b+1 == size) return null;
        if(b + 1 == size) {
            return new Coordinate(a+1, 0);
        }
        return new Coordinate(a, b+1);
    }

    public Coordinate previous(int size) {
        if(a == 0 && b == 0) return null;
        if(b == 0) {
            return new Coordinate(a-1, size-1);
        }
        return new Coordinate(a, b-1);
    }
}