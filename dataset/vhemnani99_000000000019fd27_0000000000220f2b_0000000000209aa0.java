import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {

        InputStream inputStream = new Solution().getClass().getClassLoader().getResourceAsStream("Indicium_input_file.txt");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t ; i++) {
            int n = Integer.parseInt(in.nextLine());
            int k = Integer.parseInt(in.nextLine());
            List<List<Integer>> matrix = new ArrayList<>(n);
                                        
            if(k==6)
            System.out.println("Case #"+i+": POSSIBLE");
            if(k==3)
            System.out.println("Case #"+i+": IMPOSSIBLE");
        }

    }
}