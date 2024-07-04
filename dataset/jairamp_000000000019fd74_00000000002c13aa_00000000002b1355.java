import java.util.*;
import java.io.*;

/*
4
1 1
15
3 3
1 1 1
1 2 1
1 1 1
1 3
3 1 2
1 3
1 2 3

1
3 3
1 1 1
1 2 1
1 1 1

1
1 3
3 1 2

1
1 3
1 2 3

 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= cases; ++i) {
            int rows = in.nextInt();
            int columns = in.nextInt();
            int[][] arr = new int[rows][columns];
            for(int x = 0;x < rows;x++){
                for(int y = 0;y < columns;y++){
                    arr[x][y] = in.nextInt();
                }
            }
            Solution s = new Solution(arr);

            int result = s.solve();

            System.out.println("Case #" + i + ": " + result);
        }
    }
    private int[][] arr;
    private int[][][] sumArr;
    public Solution(int[][] arr){
        this.arr = arr;
    }
    public int solve(){
        int result = 0;

        boolean removed = false;

        do{
            sumArr = getSumArr();
            removed = false;
            result += getTotal();
//            System.out.println("Current total: " + result);
            for(int x =0;x < arr.length;x++){
                for(int y =0;y < arr[x].length;y++){
                    if(arr[x][y] != 0) {
                        double average = 1.0 * sumArr[x][y][0] / sumArr[x][y][1];
                        if (arr[x][y] < average) {
//                            System.out.println("Removing " + x + " , " + y);
                            removeNeighbor(x, y);
                            arr[x][y] = 0;
                            removed = true;
                        }
                    }
                }
            }
        }while(removed);

        return result;
    }

    private int[][][] getSumArr(){
        int[][][] sumArr = new int[arr.length][arr[0].length][2];
        for(int x = 0;x < arr.length;x++){
            for(int y = 0;y < arr[x].length;y++){
                int[] neighbors = getSumOfNeighbors(x, y);
                sumArr[x][y][0] = neighbors[0];
                sumArr[x][y][1] = neighbors[1];
            }
        }
        return sumArr;
    }

    private int[] getSumOfNeighbors(int x, int y){
        int[] total = new int[2];
        int count = 0;
        int sum = 0;
        int[] currentNeighbor = null;
        currentNeighbor = getNeighbor(x,y,0,1);
        if(currentNeighbor[0] >= 0){
            count++;
            sum += arr[currentNeighbor[0]][currentNeighbor[1]];

        }
        currentNeighbor = getNeighbor(x,y,1,0);
        if(currentNeighbor[0] >= 0){
            count++;
            sum += arr[currentNeighbor[0]][currentNeighbor[1]];
        }
        currentNeighbor = getNeighbor(x,y,-1,0);
        if(currentNeighbor[0] >= 0){
            count++;
            sum += arr[currentNeighbor[0]][currentNeighbor[1]];
        }
        currentNeighbor = getNeighbor(x,y,0,-1);
        if(currentNeighbor[0] >= 0){
            count++;
            sum += arr[currentNeighbor[0]][currentNeighbor[1]];
        }

        total[0] = sum;
        total[1] = count;
//        System.out.println("Total sum / count: " + sum + " / " + count);
        return total;
    }

    private int[] getNeighbor(int x, int y, int xAdder, int yAdder){
        int xIndex = x + xAdder;
        int yIndex = y + yAdder;
        int [] neighborArr = new int[2];
        neighborArr[0] = -1;
        neighborArr[1] = -1;
        while(xIndex >=0 && xIndex < arr.length && yIndex >=0 && yIndex < arr[0].length){
            if(arr[xIndex][yIndex] > 0){
                neighborArr[0] = xIndex;
                neighborArr[1] = yIndex;
//                System.out.println("For " + x + ", " + y + ", got neighbor x / y: " + neighborArr[0] + ", " + neighborArr[1]);
                return neighborArr;
            }
            xIndex += xAdder;
            yIndex += yAdder;
        }
//        System.out.println("For " + x + ", " + y + ", got neighbor x / y: " + neighborArr[0] + ", " + neighborArr[1]);
        return neighborArr;
    }

    private void removeNeighbor(int x, int y){
        int value = arr[x][y];
        int[] currentNeighbor = null;
        currentNeighbor = getNeighbor(x,y,0,1);
//        System.out.println("Current neighbor: " + currentNeighbor[0] + ", " + currentNeighbor[1]);
        if(currentNeighbor[0] >= 0){
            sumArr[currentNeighbor[0]][currentNeighbor[1]][0] -= value;
            sumArr[currentNeighbor[0]][currentNeighbor[1]][1]--;
        }
        currentNeighbor = getNeighbor(x,y,1,0);
        if(currentNeighbor[0] >= 0){
            sumArr[currentNeighbor[0]][currentNeighbor[1]][0] -= value;
            sumArr[currentNeighbor[0]][currentNeighbor[1]][1]--;
        }
        currentNeighbor = getNeighbor(x,y,-1,0);
        if(currentNeighbor[0] >= 0){
            sumArr[currentNeighbor[0]][currentNeighbor[1]][0] -= value;
            sumArr[currentNeighbor[0]][currentNeighbor[1]][1]--;
        }
        currentNeighbor = getNeighbor(x,y,0,-1);
        if(currentNeighbor[0] >= 0){
            sumArr[currentNeighbor[0]][currentNeighbor[1]][0] -= value;
            sumArr[currentNeighbor[0]][currentNeighbor[1]][1]--;
        }
//        System.out.println("Removing value: " + value);
        sumArr[x][y][0] = -1;
        sumArr[x][y][1] = -1;
    }

    private int getTotal(){
        int total = 0;
        for(int x = 0;x < arr.length;x++){
            for(int y = 0;y < arr[x].length;y++){
//                System.out.print("(" + sumArr[x][y][0] + "," + sumArr[x][y][1] + ")");
//                System.out.print(arr[x][y]);
                total += arr[x][y];
            }
//            System.out.println();
        }
//        System.out.flush();
        return total;
    }
}


