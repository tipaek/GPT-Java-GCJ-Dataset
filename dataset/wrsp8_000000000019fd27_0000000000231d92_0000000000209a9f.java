import java.util.*;

public class Solution{

    static Scanner in;
    static int[] nums;
    static int[][] par;
    public static void main(String[] args){
        in = new Scanner(System.in);
        int cases = Integer.parseInt(in.nextLine());
        for(int i = 0; i < cases; i++){
            parse();
            solve();
            System.out.print("Case #"+(i+1)+": ");
            print();
        }
    }
    public static void parse(){
        String c = in.nextLine();
        nums = new int[c.length()];
        for(int i =0; i< c.length(); i++){
            nums[i] =c.charAt(i) -'0';
        }
    }
    public static void solve(){
        par = new int[nums.length+1][2];
        int[] numsc = nums.clone();
        int pointer = 0;
        for(int i = 0; i < numsc.length; i++){
            while(numsc[i]!=0){
                //System.out.println(Arrays.toString(par));
                par[i][0]++;
                boolean flag = true;
                for(int j = i; j < numsc.length; j++){
                    if(numsc[j]>0){
                        numsc[j]--;
                    } else {
                        par[j-1][1]++;
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    par[numsc.length-1][1]++;
            }
        }
    }
    public static void print(){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < par[i][0]; j++){
                System.out.print("(");
            }
            System.out.print(nums[i]);
            for(int j = 0; j < par[i][1]; j++){
                System.out.print(")");
            }
            
        }
        System.out.println();
    }

}