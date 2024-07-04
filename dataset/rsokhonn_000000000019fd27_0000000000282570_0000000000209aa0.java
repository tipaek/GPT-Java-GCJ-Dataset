import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();
        
        for(int tc=1; tc<=numTC; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int[][] matrix = new int[n][n];
            
            String result = "";
            boolean possible = true;
            
            if(!buildSuccessful(matrix, n, k))
                possible = false;
            
            if (!possible)
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            else {
                System.out.println("Case #" + tc + ": POSSIBLE");
                printMatrix(matrix, n);
            }
        }
    }
    
    public static boolean buildSuccessful(int[][] matrix, int n, int k) {
        if (k == n*(n+1)/2 && n > 2) {
            Integer[] base = new Integer[n];
            
            for (int i=0; i<n; i++) base[i] = i+1;
            
            // for (int i=0; i<n; i++) 
            //     System.out.print(base[i] + " ");
            // System.out.println();
            
            int trace = 0;
            for (int i=0; i<n; i++) {
                Integer[] array = shiftLeft(base, i);
                // System.out.println();
                // for (int t=0; t<n; t++) 
                //     System.out.print(array[t] + " ");
                // System.out.println();
                
                for (int j=0; j<n; j++) {
                    matrix[i][j] = array[j];
                    if (i == j) trace += array[j];
                }
            }
            
            // System.out.println("trace = " + trace);
            
            if (trace == k) return true;
        } 
        
        int baseNum = 0;
        for (int i=0; i<n; i++) {
            if ((i+1)*n == k)
                baseNum = i;
        }
        
        Integer[] base = new Integer[n];
        
        for (int i=0; i<n; i++) base[i] = ((baseNum+i) % n) + 1;
        
        int trace = 0;
        for (int i=0; i<n; i++) {
            Integer[] array = shiftRight(base, i);
            
            for (int j=0; j<n; j++) {
                matrix[i][j] = array[j];
                if (i == j) trace += array[j];
            }
        }
            
        // System.out.println("trace = " + trace);
            
        if (trace == k) return true;
        
        return false;
    }
    
    public static Integer[] shiftLeft(Integer[] array, int index) {
        Integer[] newArray = new Integer[array.length];
        
        for (int i=0; i<array.length; i++)
            newArray[i] = array[(i + 2*index) % (array.length)];
            
        return newArray;
    }
    
    public static Integer[] shiftRight(Integer[] array, int index) {
        Integer[] newArray = new Integer[array.length];
        
        for (int i=0; i<array.length; i++)
            newArray[i] = array[(array.length + i - index) % (array.length)];
            
        return newArray;
    }
    
    public static List<Integer[]> constructList (int n) {
        Integer[] base = new Integer[n];
        
        for (int i=0; i<n; i++)
            base[i] = i+1;
        
        return permute(base);
    }
    
    public static List<Integer[]> permute(Integer[] nums) {
        List<Integer[]> result = new ArrayList<Integer[]>();
        helper(0, nums, result);
        return result;
    }
 
    private static void helper(int start, Integer[] nums, List<Integer[]> result){
        if(start==nums.length-1){
            Integer[] list = nums.clone();
            result.add(list);
            return;
        }
     
        for(int i=start; i<nums.length; i++){
            swap(nums, i, start);
            helper(start+1, nums, result);
            swap(nums, i, start);
        }
    }
     
    public static void swap(Integer[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void printMatrix(int[][] matrix, int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n-1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(matrix[i][n-1]);
        }
    }
}