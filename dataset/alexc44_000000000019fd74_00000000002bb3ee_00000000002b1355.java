import java.util.*;

public class Solution {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int cases = 0;
        if(scanner.hasNextLine()) {
            cases = Integer.parseInt(scanner.nextLine());
        }
        for(int i = 0; i < cases; i++) {
            String curr = scanner.nextLine();
            int row = 0;
            int col = 0;
            for(int j = 0; j <= curr.length(); j++) {
                if(j == curr.length() || curr.charAt(j) == ' ') {
                    row = Integer.parseInt(curr.substring(0, j));
                    col = Integer.parseInt(curr.substring(j+1, curr.length()));
                    break;
                }
            }
            System.out.println("Case #" + Integer.toString(i+1) + ": " + output(scanner, row, col));
        }
    }

    public static int output(Scanner scanner, int row, int col) {
        HashSet<String> set = new HashSet<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int comp = 0;
        for(int i = 0; i < row; i++) {
            String curr = scanner.nextLine();
            int last = 0;
            int count = 0;
            for(int j = 0; j <= curr.length(); j++) {
                if(j == curr.length() || curr.charAt(j) == ' ') {
                    String loc = getLoc(i, count);
                    set.add(loc);
                    //System.out.println("Adding: " + loc);
                    map.put(loc, Integer.parseInt(curr.substring(last, j)));
                    comp += Integer.parseInt(curr.substring(last, j));
                    last = j+1;
                    count++;
                }
            }
        }

        boolean valid = true;
        while(valid) {
            int tempComp = 0;
            boolean tmp = false;
            HashSet<String> keep = new HashSet<String>();
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    String curr = Integer.toString(i) + "," + Integer.toString(j);
                    if(set.contains(curr)) {
                        //System.out.println("Check neighbor for: " + curr);
                        if(neighbor(i, j, row, col, set, map)) {
                            keep.add(curr);
                            tempComp += map.get(curr);
                        }
                        else {
                            tmp = true;
                        }
                    }
                }
            }
            set = keep;
            valid = tmp;
            if(valid)
                comp += tempComp;
        }

        return comp;
    }

    public static boolean neighbor(int i, int j, int row, int col, HashSet<String> set, HashMap<String, Integer> map) {
        int sum = 0;
        int count = 0;
        int curr = j-1;
        while(curr >= 0) {
            if(set.contains(getLoc(i, curr))) {
                sum += map.get(getLoc(i, curr));
                count++;
                break;
            }
            curr--;
        }
        curr = j+1;
        while(curr < col) {
            if(set.contains(getLoc(i, curr))) {
                sum += map.get(getLoc(i, curr));
                count++;
                break;
            }
            curr++;
        }
        curr = i-1;
        while(curr >= 0) {
            if(set.contains(getLoc(curr, j))) {
                sum += map.get(getLoc(curr, j));
                count++;
                break;
            }
            curr--;
        }
        curr = i+1;
        while(curr < row) {
            if(set.contains(getLoc(curr, j))) {
                sum += map.get(getLoc(curr, j));
                count++;
                break;
            }
            curr++;
        }

        if (count == 0)
            return true;
        else {
            return ((double) map.get(getLoc(i, j))) >= ((double) sum)/count;
        }
    }

    public static String getLoc(int i, int j) {
        return Integer.toString(i) + "," + Integer.toString(j);
    }
}