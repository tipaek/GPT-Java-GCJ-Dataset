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
        List<Integer[]> bases = constructList(n);
        
        for(Integer[] base : bases) {
            int trace = 0;
            
            for (int i=0; i<n; i++) {
                // System.out.println("before shift right");
                
                // for (int t=0; t<base.length; t++)
                //     System.out.print(base[t] + " ");
                // System.out.println();
                
                Integer[] array = shiftRight(base, i);
                
                // System.out.println("after shift right");
                
                // for (int t=0; t<array.length; t++)
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
        
        for(Integer[] base : bases) {
            int trace = 0;
            
            for (int i=0; i<n; i++) {
                
                // System.out.println("before shift left");
                
                // for (int t=0; t<base.length; t++)
                //     System.out.print(base[t] + " ");
                // System.out.println();
                
                Integer[] array = shiftLeft(base, i);
                
                // System.out.println("after shift left");
                
                // for (int t=0; t<array.length; t++)
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
        
        return false;
    }
    
    public static Integer[] shiftLeft(Integer[] array, int index) {
        Integer[] newArray = new Integer[array.length];
        
        for (int i=0; i<array.length; i++)
            newArray[i] = array[(i + index) % (array.length)];
            
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
            for (int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}