    import java.util.Scanner;
    import java.util.*;
    public class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int cas = sc.nextInt();
            for (int i = 0; i<cas; i++) {
                int num = sc.nextInt();
                num-=1;
                int possible = 1;
                while (true) {
                    if (num>possible) {
                        num-=possible;
                        possible++;
                    }
                    else {
                        break;
                    }
                }
                possible--;
                
                System.out.println("Case #"+(i+1)+":");
                System.out.println("1 1");
                for (int ia = 0; ia<possible; ia++) {
                    System.out.println((ia+2)+" 1");
                }
                for (int ia = 0; ia<num; ia++) {
                    System.out.println((ia+possible+1)+" 0");
                }
            }
        }
    }