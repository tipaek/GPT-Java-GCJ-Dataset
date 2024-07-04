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
            List<String> words1 = new ArrayList<>();
            List<String> words2 = new ArrayList<>();
            int goodIdx1 = 0;
            int max1= 0;
            int max2 = 0;
            int goodIdx2 = 0;
            for(int j = 0; j<n;j++) {
                String str = sc.next();
                String word1 = str.split("\\*")[0];
                String word2;
                if(str.endsWith("*")) {
                    word2 = "";
                } else {
                    word2 = str.split("\\*")[1];
                }
                if(word2.length() > max1) {
                    max1 = word2.length();
                    goodIdx1 = j;
                }
                if(word1.length() > max2) {
                    max2 = word1.length();
                    goodIdx2 = j;
                }
                words1.add(word1);
                words2.add(word2);
            }
            Boolean possible = true;
            for(int j=0;j<n;j++) {
                for(int i=j+1;i<n;i++) {
                    char[] arr1 = words2.get(i).toCharArray();
                    char[] arr2 = words2.get(j).toCharArray();
                    char[] arr3 = words1.get(i).toCharArray();
                    char[] arr4 = words1.get(j).toCharArray();
                    int idx1 = arr1.length-1;
                    int idx2 = arr2.length-1;
                    while(idx1 >= 0 && idx2 >= 0) {
                        if(arr1[idx1] != arr2[idx2]) {
                            possible = false;
                            break;
                        }
                        idx1--;
                        idx2--;
                    }
                    idx1 = 0;
                    idx2 = 0;
                    while(idx1 < arr3.length && idx2 < arr4.length) {
                        if(arr3[idx1] != arr4[idx2]) {
                            possible = false;
                            break;
                        }
                        idx1++;
                        idx2++;
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

                System.out.println("Case #" + t + ": " + words1.get(goodIdx2) + words2.get(goodIdx1));
            }
        }
    }

    public static int sum (int x, int y) {
        return x + y;
    }

}
