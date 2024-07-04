import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();
        
        for(int tc=1; tc<=numTC; tc++) {
            int n = sc.nextInt();
            
            int[][] matrix = new int[n][n];
            
            for(int i=0; i<n; i++) {
                matrix[i][0] = 1;
                matrix[0][i] = 1;
            }
            
            for (int i=1; i<n; i++) {
                for (int j=1; j<n; j++) {
                    matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
                }
            }
            
            List<Integer[]> result = solve(matrix, n);
            
            System.out.println("Case #" + tc + ":");
            print(result);
        }
    }
    
    public static List<Integer[]> solve(int[][] matrix, int n) {
        List<Integer[]> currentPath = new ArrayList<Integer[]>();
        int currentSum = 0;
        HashSet<Integer> visited = new HashSet<Integer>();
        List<Integer[]> optimal = new ArrayList<Integer[]>();
        
        dfs(0, 0, n, matrix, currentPath, currentSum, visited, optimal);
        
        return optimal;
    }
    
    public static void dfs(int i, int j, int n, int[][] matrix, List<Integer[]> currentPath, int currentSum, HashSet<Integer> visited, List<Integer[]> optimal) {
        Integer[] node = new Integer[] {i, j};
        
        // if (visited.contains(getKey(node, n)))
        //     return;
        
        currentPath.add(node);
        currentSum += matrix[i][j];
        visited.add(getKey(node, n));
        
        // System.out.println(i + " " + j + ", current sum = " + currentSum);
        
        if (currentSum == n && currentPath.size() <= 500) {
            for (Integer[] element : currentPath)
                optimal.add(new Integer[] {element[0], element[1]});
                
            visited.remove(getKey(node, n));
            return;
        }
        
        if (currentPath.size() >= n) {
            visited.remove(getKey(node, n));
            return;
        }
        
        for (Integer[] neighbor : getNeighbors(i, j, n))
        {
            // if (!visited.contains(getKey(neighbor, n)))
                dfs(neighbor[0], neighbor[1], n, matrix, currentPath, currentSum, visited, optimal);
            // visited.remove(getKey(neighbor, n));
        }
    }
    
    public static List<Integer[]> getNeighbors(int i, int j, int n) {
        // (ri - 1, ki - 1), (ri - 1, ki), (ri, ki - 1), 
        // (ri, ki + 1), (ri + 1, ki), (ri + 1, ki + 1)
        
        // System.out.println(i + " " + j);
        
        List<Integer[]> neighbors = new ArrayList<Integer[]>();
        
        if (i-1 >= 0) {
            if (j-1 >= 0)
                neighbors.add(new Integer[] { i-1, j-1 });
            
            neighbors.add(new Integer[] { i-1, j });
            
            if (j+1 < n)
                neighbors.add(new Integer[] { i-1, j+1 });
        }
        
        if (i+1 < n) {
            if (j-1 >= 0)
                neighbors.add(new Integer[] { i+1, j-1 });
            
            neighbors.add(new Integer[] { i+1, j });
            
            if (j+1 < n)
                neighbors.add(new Integer[] { i+1, j+1 });
        }
        
        // for (Integer[] neighbor : neighbors) {
        //     System.out.println("neighbor: " + neighbor[0] + " " + neighbor[1]);
        // }
        
        return neighbors;
    }
    
    public static int getKey(Integer[] node, int n) {
        return node[0]*n + node[1];
    }
    
    public static void print(List<Integer[]> result) {
        for (Integer[] pair : result) 
            System.out.println((pair[0]+1) + " " + (pair[1]+1));
    }
}