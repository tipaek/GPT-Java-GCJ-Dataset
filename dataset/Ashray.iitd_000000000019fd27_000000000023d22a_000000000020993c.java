import java.util.*;
import java.io.*;


class Solution{
    public static ArrayList<Integer> func(int[][] arr,int n){
        // to calculate
        int k=0;
        int r=0;
        int c=0; 
        ArrayList<Integer> toreturn = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            HashMap<Integer,Boolean> cmap = new HashMap<Integer,Boolean>();
            HashMap<Integer,Boolean> rmap = new HashMap<Integer,Boolean>();
            int flagr = 0;
            int flagc = 0;
            for(int j=0;j<n;j++){
                if(i==j){
                    k += arr[i][j];
                }
                if(rmap.containsKey(arr[i][j])){
                    if(flagr == 0){
                        r += 1;
                        flagr = 1;
                    }
                }else{
                    rmap.put(arr[i][j],true);
                }

                if(cmap.containsKey(arr[j][i])){
                    if(flagc == 0){
                        flagc=1;
                        c += 1;
                    }
                }else{
                    cmap.put(arr[j][i],true);
                }
            }
        }
        toreturn.add(k);
        toreturn.add(r);
        toreturn.add(c);
        return toreturn;
    }
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            int n = s.nextInt();
            int[][] arr = new int[n][n];
            for(int a=0;a<n;a++){
                for(int b=0;b<n;b++){
                    arr[a][b] = s.nextInt();
                }
            }
            ArrayList<Integer> toprint = func(arr,n);
            String st = "Case #"+Integer.toString(i+1)+": "+Integer.toString(toprint.get(0))+" "+Integer.toString(toprint.get(1))+" "+Integer.toString(toprint.get(2));
            System.out.println(st);
        }
    }
}