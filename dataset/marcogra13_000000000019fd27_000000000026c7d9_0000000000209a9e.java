import java.util.*;
import java.io.*;

public class Solution{
    
static final int size = 10;
static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

static char printResult(int[] output){
    for (int i = 0; i < size; i++){
        System.out.println(output[i]);
    }
    return in.next().charAt(0);
}

static int query(int P){
    System.out.println(P);
    return in.nextInt();
}

public static void main(String[] args) {
   
    int first = in.nextInt(); // Number of test cases
    int second = in.nextInt(); // Number of bits
    
    int[] result = new int[size];
    // Send query
    for(int i = 0; i < size; ){
        result[i] = query(++i);
    }
    
    System.out.println(Solution.printResult(result));
   }
}