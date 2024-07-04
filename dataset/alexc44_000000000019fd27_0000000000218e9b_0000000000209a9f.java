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
            int[] arr = new int[curr.length()];
            for(int j = 0; j < arr.length; j++)
                arr[j] = Character.getNumericValue(curr.charAt(j));
            System.out.println("Case #" + Integer.toString(i+1) + ": " + output(arr));
        }
    }

    public static String output(int[] arr) {
        int[] original = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            original[i] = arr[i];
        String[] str = new String[arr.length + 1];
        for(int i = 0; i < str.length; i++)
            str[i] = "";

        for(int i = 0; i < arr.length; i++) {
            while(arr[i] > 0) {
                str[i] = str[i] + "(";
                arr[i]--;
                int next = i+1;
                while(next < arr.length && arr[next] > 0) {
                    arr[next]--;
                    next++;
                }
                str[next] = ")" + str[next];
            }
        }
        String out = str[0];
        for(int i = 0; i < original.length; i++) {
            out += original[i] + str[i+1];
        }

        return out;
    }
}