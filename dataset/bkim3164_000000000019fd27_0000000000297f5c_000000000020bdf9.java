import java.util.*;
import java.io.*;
 
class Solution{
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
 
        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i+1) + ": ");
            solve(in);
        }
        in.close();
 
    }
    static void solve(Scanner in){
        int N = in.nextInt();
        int[][] array = new int[N][2];
        int[] ar = new int[N];
        int[] array2 = new int[N];
        boolean work1 = false;
        int work1i = 0;
        boolean work2 = false;
        int work2i = 0;
        boolean work3 = false;
        String string = "";
        for (int i = 0; i < N; i++) {
            array[i][0] = in.nextInt();
            ar[i] = array[i][0];
            array[i][1] = in.nextInt();
        }
        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] entry1,  
                               int[] entry2) {
                  Integer a = entry1[0];
                  Integer b = entry2[0];
                  return a.compareTo(b);
            }
          });
        f1: for (int i = array[0][0]; i < array[N-1][1]+1; i++) {
            for (int j = 0; j < N; j++) {
                if(i == array[j][0] && work1 == true && work2 == true){
                    work3 = true;
                    break f1;
                }
                else if(i == array[j][0] && work1 == true){
                    work2 = true;
                    work2i = j;
                    array2[j] = array[j][0];
                    string += 'J';
                }
                else if(i == array[j][0]){
                    work1 = true;
                    work1i = j;
                    array2[j] = array[j][0];
                    string += 'C';
                }
                if(i == array[j][1]){
                    if(j == work1i){
                        work1 = false;
                    }
                    else if(j == work2i){
                        work2 = false;
                    }
                }
            }
           
        }
        if(work3 == true){
            System.out.println("IMPOSSIBLE");
        }
        else{
            char[] strings = string.toCharArray();
            String newString = "";
            for (int i = 0; i < array2.length; i++) {
                for (int j = 0; j < array2.length; j++) {
                    if(ar[i] == array2[j]){
                        newString += strings[j];
                    }
                }
            }
            System.out.println(newString);
        }
 
}
}