import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            StringBuffer ans = new StringBuffer();
            int start[] = new int[n];
            int end[] = new int[n];
            int minParent = 0;
            char parent[] = {'C','J'};
            int currentParent = 0;
            int copy[] = new int[n];
            for(int i = 0 ; i < n ; i++){
                start[i] = sc.nextInt();
                copy[i] = start[i];
                end[i] = sc.nextInt();
            }
            Arrays.sort(start);
            Arrays.sort(end);
            int count = 0;
            StringBuffer actual = new StringBuffer();
            for(int i = 0, j = 0; i < n && j < n ;){
                if(start[i] < end[j]){
                    count++;
                    minParent = count > minParent ? count : minParent;
                    i++;
                    ans.append(parent[currentParent]);
                    currentParent = currentParent == 0 ? 1 : 0;
                }
                else if(start[i] > end[j]){
                    count--;
                    j++;
                    currentParent = currentParent == 0 ? 1 : 0;
                }
                else{
                    j++;
                    count--;
                }
            }
            if(minParent > parent.length){
                actual = new StringBuffer("IMPOSSIBLE");
            }
            else{
                int length = ans.length();
                for(int i = 0 ; i < (n - length) ; i++){
                    ans.append(parent[currentParent]);
                }

                for(int i = 0 ; i < n ; i++){
                    for(int j = 0 ; j < n ; j++){
                        if(copy[i] == start[j]){
                            actual.append(ans.charAt(j));
                            break;
                        }
                    }
                }
            }
            System.out.printf("\nCase #%d: %s",(x),actual);
        }
    }
}
