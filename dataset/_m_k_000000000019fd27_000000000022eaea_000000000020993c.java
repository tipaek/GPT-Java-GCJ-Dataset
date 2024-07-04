import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        for(int i=0;i<a;i++) {
            int b = s.nextInt();
            int c[][] = new int[b][b];
            int trace = 0,col=0,row=0;
            for (int j = 0; j < b; j++) {
                HashSet<Integer> hash=new HashSet<>();
                for (int k = 0; k < b; k++) {
                    c[j][k] = s.nextInt();
                    if (k == j)
                        trace += c[j][k];
                    hash.add(c[j][k]);
                }
                if(hash.size()!=b)
                    row++;
            }
            for (int j = 0; j < b; j++) {
                HashSet<Integer> hash = new HashSet<>();
                for (int k = 0; k < b; k++)
                    hash.add(c[k][j]);
                if (hash.size() != b)
                    col++;
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+row+" "+col);
        }
    }
}
