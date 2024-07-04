import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
public class Solution {
    private static Scanner scn;
    private static int tn=1;

    public static void main(String args[]) {

        scn=new Scanner(System.in);
        int t=scn.nextInt();
        scn.nextLine();

            while(t-->0){
                solve();
            }

        }

        private static void solve(){
        int n=scn.nextInt();
        int[][] arr=new int[n][n];
        int k=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=scn.nextInt();

                if(i==j)k+=arr[i][j];

            }
        }

        int r=r_help(arr);
        int c=c_help(arr);

        System.out.println("Case #" + (tn++)+": "+ k+" "+r+" "+c);


        }

        private static int r_help(int[][] arr){

        int res=0;
        for(int i=0;i<arr.length;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=0;j<arr[i].length;j++){
                if(set.contains(arr[i][j])){
                    res++;
                    break;
                }
                set.add(arr[i][j]);

            }
        }
        return res;
        }
        private static int c_help(int[][] arr){
            int res=0;
            for(int i=0;i<arr.length;i++){
                Set<Integer> set=new HashSet<>();
                for(int j=0;j<arr[i].length;j++){
                    if(set.contains(arr[j][i])){
                        res++;
                        break;
                    }
                    set.add(arr[j][i]);

                }
            }
            return res;

    }


    }






