import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            List<Object> input = readInput(in);
            String result = solve(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static List<Object> readInput(Scanner in) {
        List<Integer> coords = Arrays.asList(in.nextInt(), in.nextInt());
        String path = in.nextLine().substring(1);
        return Arrays.asList(coords, path);
    }
    
    public static List<Integer> walk(List<Integer> pos, int c) {
        switch (c) {
        case 'N': return Arrays.asList(pos.get(0),pos.get(1)+1);
        case 'S': return Arrays.asList(pos.get(0),pos.get(1)-1);
        case 'E': return Arrays.asList(pos.get(0)+1,pos.get(1));
        case 'W': return Arrays.asList(pos.get(0)-1,pos.get(1));
        }
        throw new RuntimeException("impos");
    }

    public static String solve(List<Object> input) {
        List<Integer> coords = (List<Integer>) input.get(0);
        if (coords.get(0) == 0 && coords.get(1) == 0)
            return "0";
        String path = (String) input.get(1);
        List<Integer> initial = new ArrayList<Integer>(coords);
        List<List<Integer>> positions = path.chars().mapToObj(c -> {
            List<Integer> newpos = walk(initial, c);
            initial.set(0, newpos.get(0));
            initial.set(1, newpos.get(1));
            return newpos;
        }).collect(Collectors.toList());

        int smallest = 10000;
        for (int i = 0; i < positions.size(); i++) {
            List<Integer> pos = positions.get(i);
            int t = i + 1;
            int dist = Math.abs(pos.get(0)) + Math.abs(pos.get(1));
            if (dist <= t) {
                if (t < smallest) {
                    smallest = t;
                }
            }
        }
        if (smallest == 10000) {
            return "IMPOSSIBLE";
        }
        return Integer.toString(smallest);
    }
}
