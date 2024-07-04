import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt();
		for (int t = 0; t < T; t++) {
			Boolean flag = false;
            while (!flag) {
                for (int x = -5; x <= 5; x++) {
                    for (int y = -5; y <= 5; y++) {
                        System.out.println(x+" "+y);
                        if (sc.nextLine() == "CENTER") {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                } 
            }
		}
	}	
}