/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author EliteBook
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {

        new Solution().getResult();
    }

    public void getResult() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= tc; t++) {
            String[] ip = br.readLine().trim().split(" ");
            int n = Integer.parseInt(ip[0]);
            int d = Integer.parseInt(ip[1]);
            String[] ipa = br.readLine().trim().split(" ");
            Map<Long, Integer> map = new TreeMap<>();
            boolean found = false;
            int res = 0;
            for (int i = 0; i < n; i++) {
                long l = Long.parseLong(ipa[i]);
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);
                } else {
                    map.put(l, 1);
                }

                if (map.get(l) == d) {
                    found = true;
                    break;
                }
            }
            if (n == 1) {
                found = true;
                res = d - 1;
            }
            if (!found) {
                res = calc(map, n, d);
            }

            System.out.print("Case #" + t + ": ");

            System.out.print(res);

            System.out.println();

        }

    }

    public int calc(Map<Long, Integer> map, int n, int d) {

        List<Long> list = new ArrayList<>(map.keySet());
//        System.out.println(list);
        long part = list.get(0);
        int[] serve = new int[n];
        for (int i = 0; i < n; i++) {
            serve[i] = (int) (list.get(i) / part);
        }
//        System.out.println(Arrays.toString(serve));
        printAllSubsets(serve, n, d);
        int cut=0;
        for(int a:minSub){
            cut+=(a-1);
        }
        
        return cut;
    }

    boolean[][] dp;
    int[] minSub;
    void display(ArrayList<Integer> v) {
        int n=v.size();
        if(minSub==null || minSub.length>n){
            minSub=new int[n];
            for(int i=0;i<n;i++){
                minSub[i]=v.get(i);
            }
        }
//        System.out.println(v);
    }

    // A recursive function to print all subsets with the 
    // help of dp[][]. Vector p[] stores current subset. 
    void printSubsetsRec(int arr[], int i, int sum,
            ArrayList<Integer> p) {
        // If we reached end and sum is non-zero. We print 
        // p[] only if arr[0] is equal to sun OR dp[0][sum] 
        // is true. 
        if (i == 0 && sum != 0 && dp[0][sum]) {
            p.add(arr[i]);
            display(p);
            p.clear();
            return;
        }

        // If sum becomes 0 
        if (i == 0 && sum == 0) {
            display(p);
            p.clear();
            return;
        }

        // If given sum can be achieved after ignoring 
        // current element. 
        if (dp[i - 1][sum]) {
            // Create a new vector to store path 
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            printSubsetsRec(arr, i - 1, sum, b);
        }

        // If given sum can be achieved after considering 
        // current element. 
        if (sum >= arr[i] && dp[i - 1][sum - arr[i]]) {
            p.add(arr[i]);
            printSubsetsRec(arr, i - 1, sum - arr[i], p);
        }
    }

    // Prints all subsets of arr[0..n-1] with sum 0. 
    void printAllSubsets(int arr[], int n, int sum) {
        if (n == 0 || sum < 0) {
            return;
        }

        // Sum 0 can always be achieved with 0 elements 
        dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = true;
        }

        // Sum arr[0] can be achieved with single element 
        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

        // Fill rest of the entries in dp[][] 
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < sum + 1; ++j) {
                dp[i][j] = (arr[i] <= j) ? (dp[i - 1][j]
                        || dp[i - 1][j - arr[i]])
                        : dp[i - 1][j];
            }
        }
        if (dp[n - 1][sum] == false) {
            System.out.println("There are no subsets with"
                    + " sum " + sum);
            return;
        }

        // Now recursively traverse dp[][] to find all 
        // paths from dp[n-1][sum] 
        ArrayList<Integer> p = new ArrayList<>();
        printSubsetsRec(arr, n - 1, sum, p);
    }
}
