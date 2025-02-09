import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.LongStream;

public class Solution {
    public  static Set<Integer> cases = new HashSet<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileReader("src/value.txt"));
        int T = Integer.parseInt(sc.next());
        for(int t = 0; t < T; ++t) {
            int size = Integer.parseInt(sc.next());
            int sum = Integer.parseInt(sc.next());
            findLatin(sum, size, t+1);
        }
        for(int t = 0; t < T; ++t) {
            if(cases.contains(t+1))
                System.out.println("Case #" + (t+1) +": " + "POSSIBLE");
            else
                System.out.println("Case #" + (t+1) +": " + "IMPOSSIBLE");
        }
    }

    private static void findLatin(int sum, int size, int test) {
        int permutaionSize = factorial(size);
        int[] nums = new int[size];
        for(int i = 0; i < size; ++i) {
            nums[i] = i + 1;
        }
        List<List<Integer>> lists = permute(nums);
        nums = new int[permutaionSize];
        int i = 0;
        for(List<Integer> list : lists) {
            int v = 0;
            for(Integer k : list) {
                v = v*10 + k;
            }
            nums[i++] = v;
            //System.out.println(v);

        }
        printCombination(nums, nums.length, size, sum, test);


    }

    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r, int sum, int test)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            StringJoiner stringJoiner = new StringJoiner(" ");
            for (int j=0; j<r; j++)
                stringJoiner.add(String.valueOf(data[j]));
                if(!cases.contains(test))
                findPossilbeMatrix(stringJoiner.toString(), sum, test);
            //findPossilbeMatrix(stringJoiner.toString(), sum, test);
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r, sum, test);
        }
    }

    private static void findPossilbeMatrix(String toString, int sum, int test) {
       // System.out.println(toString);
        String[] strs = toString.split("\\s+");
        int[][] mat = new int[strs.length][strs.length];
        for(int i = 0; i < strs.length; ++i) {
            String s = strs[i];
            for(int j = 0; j < strs.length; ++j) {
                mat[i][j] = s.charAt(j) - '0';
            }
        }
        int localSum = 0;
        for(int k = 0; k < mat.length; ++k) {
            localSum += mat[k][k];
        }
        if(sum == localSum && !cases.contains(test))
            cases.add(test);
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int arr[], int n, int r, int sum, int test)
    {
        // A temporary array to store all combination one by one
        int data[]=new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n-1, 0, r, sum, test);
    }

    public static int factorial( int n )
    {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    static void helper(int start, int[] nums, List<List<Integer>> result){
        if(start==nums.length-1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            result.add(list);
            return;
        }

        for(int i=start; i<nums.length; i++){
            swap(nums, i, start);
            helper(start+1, nums, result);
            swap(nums, i, start);
        }
    }

    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
