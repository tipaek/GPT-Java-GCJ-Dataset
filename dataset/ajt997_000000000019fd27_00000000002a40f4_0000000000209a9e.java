import java.util.*;
import java.io.*;

public class Solution {
    
    public static int[] flip(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
        }
        
        return arr;
    }
    
    public static int[] reverse(int[] arr) {
        for(int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i];
            arr[arr.length - i] = temp;
        }
        
        return arr;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        for(int i = 0; i < T; i++) {
            int currid = 0;
            boolean nd = false;
            int currtime = 0;
            int flipnode = -1;
            int nonflipnode = -1;
            boolean complete = false;
            boolean backtrack = false;
            int bt = -1;
            
            int[] arr = new int[B];
            
            while(!complete) {
                // First: process
                if(nd) {
                    System.out.println(B - currid);
                    System.out.flush();
                }
                else {
                    System.out.println(currid);
                    System.out.flush();
                }
            
                // Get proper integer
                int next = Integer.parseInt(f.readLine());
                if(nd && next != arr[currid] && flipnode == -1) {
                    // Check if can check flip
                    flipnode = currid;
                }
                else if(nd && next == arr[currid] && nonflipnode == -1) {
                    nonflipnode = currid;
                }
                
                
                
                // Check if it's time to backtrack
                if(currtime % 10 == 0) {
                    if(nd) {
                        bt = currid + 1;
                        nd = !nd;
                    }
                    else {
                        bt = currid;
                        nd = !nd;
                    }
                    backtrack = true;
                    if(flipnode == -1 && nonflipnode == -1) {
                        backtrack = false;
                    }
                    else if(flipnode == -1) {
                        currid --;
                        while(backtrack) {
                            System.out.println(currid);
                            System.out.flush();
                            int check = Integer.parseInt(f.readLine());
                            
                            if(check != arr[currid]) {
                                arr = flip(arr);
                            }
                            backtrack = false;
                            currid = bt;
                            currtime ++;
                        }
                    }
                    else if(nonflipnode == -1) {
                        currid = flipnode;
                        while(backtrack) {
                            System.out.println(currid);
                            System.out.flush();
                            int check = Integer.parseInt(f.readLine());
                            
                            
                            if(check != arr[currid]) {
                                arr = flip(arr);
                            }
                            backtrack = false;
                            currid = bt;
                            currtime ++;
                        }
                    }
                    else {
                        while(backtrack) {
                            System.out.println(currid);
                            System.out.flush();
                            int check1 = Integer.parseInt(f.readLine());
                            
                            System.out.println(nonflipnode);
                            System.out.flush();
                            int check2 = Integer.parseInt(f.readLine());
                            
                            // 1 0  0 0 -> 0 0 0 1 then its reverse
                            // 1 0  0 0 -> 0 1 1 1 then its flip
                            // 1 0  0 0 -> 1 1 1 0 then its reverse and flip
                            
                            if(check1 == arr[currid]) {
                                if(check2 != arr[nonflipnode]) {
                                    arr = flip(arr);
                                    arr = reverse(arr);
                                }
                            }
                            else {
                                if(check2 != arr[nonflipnode]) {
                                    // 0, 1 -> 1, 0 / 0, 0 -> 1, 1
                                    arr = flip(arr);
                                }
                                else {
                                    arr = reverse(arr);
                                }
                            }
                            
                            currtime += 2;
                            backtrack = false;
                            currid = bt;
                        }
                    } 
                }
                else {
                    nd = !nd;
                    currtime++;
                    currid++;
                }
                
                if(currid == B/2) {
                    complete = true;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < B; j++) {
                sb.append(arr[j]);
            }
            
            System.out.println(sb);
            
            if(f.readLine().charAt(0) == 'N') {
                System.exit(0);
            }
            
        }
        
    }
}