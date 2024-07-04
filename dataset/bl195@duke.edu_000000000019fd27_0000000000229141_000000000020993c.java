import java.util.*;
import java.io.*;

class Vestigium{
    public static void main(String args[]){
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int size = scan.nextInt();
        for(int i = 0;i<size;i++){
            int n = scan.nextInt();
            int counter = 0;
            int k = 0;
            int r= 0;
            int c = 0;
            ArrayList<Integer> row = new ArrayList<Integer>();
            ArrayList<Integer> col = new ArrayList<Integer>();
            int[][] board = new int[n][n];
             for(int x = 0;x<n;x++){
                for(int y = 0;y<n;y++){
                    board[x][y]=scan.nextInt();
                    if(x==counter && y==counter){
                        k += board[x][y];
                        counter++;
                    }
                }
            }
            for(int x = 0;x<n;x++){
                row = new ArrayList<Integer>();
                for(int y = 0;y<n;y++){
                    if(row.contains(board[x][y])){
                        r++;
                        break;
                    }
                    row.add(board[x][y]);
                }
            }
            for(int x = 0;x<n;x++){
                col = new ArrayList<Integer>();
                for(int y = 0;y<n;y++){
                    if(col.contains(board[y][x])){
                        c++;
                        break;
                    }
                    col.add(board[y][x]);
                }
            }
            System.out.println("Case #" + (i+1)+": " + k + " " + r+ " " + c);
        }
        scan.close();
    }
    
}