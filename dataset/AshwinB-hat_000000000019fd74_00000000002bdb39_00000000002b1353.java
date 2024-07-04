package CodeJam2020.QualificationRound.Round1A;

import java.util.Scanner;
import java.util.*;
public class Solution {
        private ArrayList<int[]> a = new ArrayList();
        private Boolean visited[][];
        ArrayList<int[]> recurseUtils(int one, int two, int sum){
            visited = new Boolean[sum][sum];
            for(Boolean[] row: visited){
                Arrays.fill(row, false);
            }
            if(recurse(one, two, sum)){
                return a;
            }
            return a;
        }
        Boolean recurse(int one, int two, int sum){
            //dimension check
            if(one<1 || two<1 || two>one){
                return false;
            }
            //visited check
            if(visited[one-1][two-1]){
                return false;
            }
            int value = Solution.binomialCoeff(one-1,two-1);
            
            if(value>sum){
                return false;
            }
            a.add(new int[]{one,two});
            visited[one-1][two-1]=true;
            sum = sum-value;
            if(sum == 0){
                return true;
            }
            //go in six directions
            
            //bottom right
            if(recurse(one+1, two+1, sum)){
                return true;
            }
            //top
            if(recurse(one-1, two, sum)){
                return true;
            }
            //top right
            if(recurse(one-1, two+1, sum)){
                return true;
            }
            //bottom
            if(recurse(one+1, two, sum)){
                return true;
            }
            //left
            if(recurse(one, two-1, sum)){
                return true;
            }
            //right
            if(recurse(one, two+1, sum)){
                return true;
            }
            
            
            a.remove(a.size()-1);
            visited[one-1][two-1]=false;
            return false;
        }
        // Returns value of Binomial Coefficient C(n, k) 
        static int binomialCoeff(int n, int k) 
        { 
            int res = 1; 
          
            // Since C(n, k) = C(n, n-k) 
            if ( k > n - k ) 
                k = n - k; 
          
            // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1] 
            for (int i = 0; i < k; ++i) 
            { 
            res *= (n - i); 
            res /= (i + 1); 
            } 
          
            return res; 
        }
        static void solve(int a,int iteration){
            ArrayList<int[]> ans = new Solution().recurseUtils(1,1,a);
            System.out.println("Case #"+iteration+": ");
            for(int[] temp: ans){
                System.out.println(temp[0]+" "+temp[1]);
            }
        }
        public static void main(String[] args) {
            Scanner s= new Scanner(System.in);
            int t = s.nextInt();
            int it = 1;
            while(it<=t){
                solve(s.nextInt(),it);
                it++;
            }
        }
}