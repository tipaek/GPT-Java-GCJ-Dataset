import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int z = 1; z <= t; z++){ //Round
            int n = in.nextInt();
            String [] arr = new String [n+2]; String str = "", end = ""; 
            int [] flip = new int [n+2];
            boolean poss = true;

            for(int j = 0; j < n; j++) arr[j] = in.next();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < arr[i].length(); j++){
                    if(arr[i].charAt(j) == '*' && flip[i] == 0){
                        flip[i] = j+1;
                        if(str.startsWith(arr[i].substring(0, j))) continue;
                        else if(arr[i].substring(0, j).startsWith(str)) str = arr[i].substring(0, j);
                        else poss = false; 
                    }
                    else if(flip[i] != 0 && j == arr[i].length()-1){
                        if(end.endsWith(arr[i].substring(flip[i], j+1))) continue;
                        else if(arr[i].substring(flip[i], j+1).endsWith(end)) end = arr[i].substring(flip[i], j+1);
                        else poss = false;
                    }
                }
            }
            if(poss)System.out.println("Case #" + z + ": " + str + end);
            else System.out.println("Case #" + z + ": *");
        }
    }
}