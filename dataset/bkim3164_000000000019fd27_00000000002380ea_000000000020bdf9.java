import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i+1) + ": ");
            solve(in);
            System.out.println();
        }
        in.close();

    }
    static void solve(Scanner in){
        int N = in.nextInt();
        int max = Integer.MIN_VALUE;
        int[] start = new int[N];
        int[] end = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean work1 = false;
        boolean work2 = false;
        boolean work3 = false;
        String string = "";
        for (int i = 0; i < N; i++) {
            start[i] = in.nextInt();
            end[i] = in.nextInt();
            if(end[i] > max){
                max = end[i];
            }
            map.put(start[i], end[i]);
        }
        Arrays.sort(start);
        


        f1 : for(int i = 0; i<max+10; i++){
            for (int j = 0; j < N; j++) {
            if(start[j] == i && work1 == true && work2 == true){
                work3= true;
                break f1;
                
            }
            else if(start[j] == i && work1 == true){
                work2 = true;
                string += "J";
            }
            else if(start[j] == i ){
                work1 = true;
                if(map.containsKey(map.get(start[j])) && j != 0){
                    string += "J";
                }
                else{
                string += "C";
                }
            }

            if(map.get(start[j]) == i && work1 == false){
                work2 = false;
            }  
            else if(map.get(start[j]) == i){
                work1 = false;
            }

        } 
    }
    if(work3 == true){
        System.out.println("IMPOSSIBLE");
    }
    else{
        System.out.println(string);
    }

}
}