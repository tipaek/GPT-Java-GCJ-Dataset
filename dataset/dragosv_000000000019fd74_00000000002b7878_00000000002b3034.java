import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static class Pair {
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int t = 1; t <= tests; t++) {
            int n = sc.nextInt();
            List<String> words = new ArrayList<>();
            int goodIdx = 0;
            int max = 0;
            for(int j = 0; j<n;j++) {
                String str = sc.next();
                if(str.length() > max) {
                    max = str.length();
                    goodIdx = j;
                }
                words.add(str);
            }
            Boolean possible = true;
            for(int j=0;j<n;j++) {
                for(int i=j+1;i<n;i++) {
                    char[] arr1 = words.get(i).toCharArray();
                    char[] arr2 = words.get(j).toCharArray();
                    int idx1 = arr1.length-1;
                    int idx2 = arr2.length-1;
                    while(idx1 > 0 && idx2 > 0) {
                        if(arr1[idx1] != arr2[idx2]) {
                            possible = false;
                            break;
                        }
                        idx1--;
                        idx2--;
                    }
                    if(!possible) {
                        break;
                    }
                }
                if(!possible) {
                    break;
                }
            }
            if(!possible) {
                System.out.println("Case #" + t + ": *");
            } else {
                System.out.println("Case #" + t + ": " + words.get(goodIdx).substring(1));
            }
        }
    }

    public static int sum (int x, int y) {
        return x + y;
    }

}