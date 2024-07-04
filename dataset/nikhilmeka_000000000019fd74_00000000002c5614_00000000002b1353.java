import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(s.nextLine());
            int[] x = makeArray((int) Math.sqrt(n)+1);
            x[0] = -1;
            System.out.println("Case #: " + (i+1));
            recurse(x, new int[][] {{1,1}}, 1, 2, n-1);
        }

    }
    public static int[] makeArray(int n){
        int nextIndex = 6;
        int[] array = new int[n*(n+1)/2];
        array[0] = 1;
        array[1] = 1;
        array[2] = 1;
        array[3] = 1;
        array[4] = 2;
        array[5] = 1;
        int prevIndex = 3;
        int k = 6;
        for(int i = 3; i < n; i++){
            k = nextIndex;
            for(int j = prevIndex; j < nextIndex; j++, k++){
                if(j == prevIndex){
                    array[k] = 1;
                    k++;
                }
                else if(j == nextIndex-1){
                    array[k] = 1;
                    k++;
                    break;
                }
                array[k] = array[j] + array[j+1];
            }
            prevIndex = nextIndex;
            nextIndex = k;
        }
        return array;
    }
    public static boolean recurse(int[] grid, int[][] path, int index, int depth, int sum){
        int temp;
        if(index < 0 || index >= grid.length || grid[index] == -1 || sum < 0){
            return false;
        }
        if(sum == 0){
            for(int i = 0; i < path.length; i++){
                System.out.println(path[i][0] + " " + path[i][1]);
            }
            return true;
        }
        else{
            //Tru neighbor
            int[][] newPath = Arrays.copyOf(path, path.length+1);
            int leftIndex = (depth*(depth-1)/2)-1;
            int elementNumber = index-leftIndex;
            temp = grid[index];
            grid[index] = -1;
            if(index < (depth*(depth+1)/2)-1 && temp != -1){
                newPath[path.length] = new int[] {depth, elementNumber+1};
                if(recurse(grid, newPath, index+1, depth, sum-temp)){
                    return true;
                }
                //grid[index] = temp;
            }
            //Try children
            newPath = Arrays.copyOf(path, path.length+1);
            int rightIndex = ((depth)*(depth+1)/2)- 1 +elementNumber;
            newPath[path.length] = new int[] {depth+1, elementNumber};

//                temp = grid[rightIndex];
//                grid[rightIndex] = -1;
            if(recurse(grid, newPath, rightIndex, depth+1, sum-temp)){
                return true;
            }
            //grid[rightIndex] = temp;
            newPath = Arrays.copyOf(path, path.length+1);
            newPath[path.length] = new int[] {depth+1, elementNumber+1};
//                temp = grid[rightIndex+1];
//                grid[rightIndex+1] = -1;
            if(recurse(grid, newPath, rightIndex+1, depth+1, sum-temp)){
                return true;
            }
            //grid[rightIndex+1] = temp;

        }
        grid[index] = temp;
        return false;
    }
}
