
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt();
        for(int t =0; t<T; t++){
            solve(in, B);
        }
    }

    public static void inverse(int[] a){
        for(int i=0; i<a.length; i++){
            a[i] = 1 - a[i];
        }
    }

    public static void reverse(int[] a){
        int l = a.length;
        for(int i=1; i<l/2; i++){
            // arr 101, 1 <> 100
            if(a[i] != a[l-i]){
                a[i] = 1 - a[i];
                a[l-i] = 1 - a[l-i];
            }
        }
    }

    public static void solve(Scanner in, int b){
        String read = "";
        int c = 0; // counter from 1~b;
        int ask = 0;
        int sameFlag = -1, diffFlag = -1; // flags
        int[] ans = new int[b+1]; // dont use 1st bit
        while(!read.equals("N")){

            // ask left
            c++;
            ask++;
            System.out.println(ask); // c = 1,
            int r1 = in.nextInt();
            ans[ask] = r1;

            // ask right
            c++; // c=2
            System.out.println(b +1 -ask); // c = 2,
            int r2 = in.nextInt();
            ans[b +1 -ask] = r2;

            if(r1 == r2 && sameFlag < 0){
                sameFlag = ask;
                if(debugging){
                    System.out.println("found same flag -> " + ask);
                }
            }
            if(r1 != r2 && diffFlag < 0) {
                diffFlag = ask;
                if(debugging){
                    System.out.println("found diff flag -> " + ask);
                }
            }

            if(c % 10 == 0){
                c = 0;
            }
            
            if(debugging){
                System.out.println("ask = "+ ask + "c = " + c);
            }
            
            if(c == 0){
                if(debugging){
                    System.out.println("c == 0");
                    printArr(ans);
                }
                // things might been changed.
                // detect how it've been changed
                if(sameFlag > 0){
                    System.out.println(sameFlag);
                    c++;
                    int sameL = in.nextInt();
                    if(ans[sameFlag] != sameL){
                        // INVERSED
                        inverse(ans);
                        if(debugging){
                            System.out.println("inverse -> ");
                            printArr(ans);
                        }
                    }
                }else{
                    // ask but DO nothing
                    System.out.println(1);
                    c++;
                    int sameL = in.nextInt();
                }
                if(diffFlag > 0){
                    System.out.println(diffFlag);
                    c++;
                    int diffL = in.nextInt();
                    if(ans[diffFlag] != diffL){
                        // REVERSED
                        reverse(ans);
                        if(debugging){
                            System.out.println("REVERSE -> ");
                            printArr(ans);
                        }
                    }
                }else{
                    // ask but DO nothing
                    System.out.println(1);
                    c++;
                    int sameL = in.nextInt();
                }
            }

            if(ask > b/2){
                if(c == 0){
                    // collision
                    ask = b/2-4;
                    continue;
                } else {
                    guess(in, ans);
                    break;
                }
            }
        }
    }
    
    public static boolean debugging = false;
/**
cd "/d/CodingSpace/codejam2020/Qualification/esab"
javac --release 8 Solution.java
py runner.py py testing.py 0 -- java Solution


11111 00000
00000 11111

00011 00111

11101 01111 10101 01100
00110 10101 11110 10111

11000 10000 10000 00001
10000 00001 00001 00011
 */

    public static boolean guess(Scanner in, int[] ans ){
        printArr(ans);
        if(in.next() == "N"){
            return false;
        }
        else return true;
    }

    public static void printArr(int[] m){
        StringBuilder sb = new StringBuilder();

        for(int i= 1; i<m.length; i++){
            int b = m[i];
            sb.append(b);
        }
        print(sb.toString());
    }

    public static void printList(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        for(int i : list){
            sb.append(i);
        }
        print(sb.toString());
    }

    public static void print(Object o){
        System.out.println(o.toString());
    }
    
}
