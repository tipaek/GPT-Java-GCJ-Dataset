import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = sc.nextInt();
		int n = sc.nextInt();
	
	}

    public static void p (int i) {
        System.out.println(i);
    }	
    
    public static void postRes (int[] b) {
        String str = "";
        for (int i=0;i<b.length;i++) {
            str += b[i];
        }
        
        System.out.println(str);
    }
    
    public static int[] flipAll (int[] b) {
        for (int i=0;i<b.length;i++) {
            b[i] = flip(b[i]);
        }
        
        return b;
    }
    
    public static int[] reverse (int[] b) {
        for(int i = 0; i < b.length / 2; i++) {
            int temp = b[i];
            b[i] = b[b.length - i - 1];
            b[b.length - i - 1] = temp;
        }
        
        return b;
    }
    
    public static int flip (int i) {
        return i == 0 ? 1 : 0;
    }
}