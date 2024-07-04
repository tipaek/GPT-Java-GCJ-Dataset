import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int truce = 0, rowCount = 0, colCount = 0;
            
            Node[] cols = new Node[n];
            
            for(int z = 0; z < n; z++) {
                cols[z] = new Node(n);
            }
            
            for(int row = 0; row < n; row++) {
                Node rows = new Node(n);
           
                for(int col = 0; col < n; col++) {
                    int elem = in.nextInt();
                    if(!cols[col].add(elem))
                        colCount++;

                    
                    if(!rows.add(elem)) 
                        rowCount++;
                        
                    if(row == col)
                        truce += elem;
                }
            }
            
            System.out.println("Case #" + i + ": " + truce + " " + rowCount + " " + colCount);
        }
    }
}

class Node {
    private int[] arr;
    private int ind;
    private boolean added;
    
    public Node(int len) { 
        added = true; 
        arr = new int[len]; 
        ind = 0; 
    }
    
    public boolean add(int a) {
        if(added) {
            for(int i = 0; i < ind; i++) {
                if(arr[i] == a) {
                    added = false;
                    return false;
                }
            }
        }
        arr[ind++] = a;
        return true;
    }
}