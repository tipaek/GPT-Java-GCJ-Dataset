// import java.io.*;
// import java.util.*;


// class Solution{ //Copy and use this
//         public static void main(String[] args) throws Exception {
//         int TEST;
//         String[]ip;
//         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//         Solution obj = new Solution();
//         TEST = Integer.parseInt(in.readLine().trim());
//         while(TEST-->0){
//             //Reading ip
//             ip = in.readLine().trim().split(" ");

//             obj.solve();
//         }
//     }

//     private void solve(){
//         //Code logic here
//     }
// }

import java.io.*;
import java.util.*;


class Solution{ //Copy and use this
    private List<List<Long>> pascal;
    Solution(){
        pascal = new ArrayList<>();
        int ele, colLimit = 1;
        for(int row = 0; row < 500; row++){
            List<Long> temp = new ArrayList<>();
            for(int col = 0; col < colLimit; col++){
                if(col==0||col==colLimit-1) temp.add((long)1);
                else{
                    temp.add(pascal.get(row-1).get(col)+pascal.get(row-1).get(col-1));
                }
            }
            colLimit++;
            pascal.add(temp);
        }
        // System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        // pascal.stream().forEach(x->System.out.println("as"+x));
    }
    public static void main(String[] args) throws Exception {
        int TEST;
        String[]ip;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Solution obj = new Solution();
        TEST = Integer.parseInt(in.readLine().trim());
        for(int caseNo = 1; caseNo <= TEST; caseNo++){
            //Reading ip

            System.out.println("Case #"+caseNo+":");
            obj.solve(Long.parseLong(in.readLine().trim()));
        }
    }

    private void solve(long n){
        //Code logic here
        n -= 1;
        StringBuilder ans = new StringBuilder();
        ans.append("1 1");
        int rowPos = 0, colPos = 0;
        while(n != 0){//covers just the visible tcs
            //stays in 2 colpos, 0 or 1
            if(colPos==0){//can go to r+1,c or r+1,c+1
                if(n - pascal.get(rowPos+1).get(colPos+1) >= 0) {
                    ans.append("\n"+(rowPos+2)+" "+(colPos+1));
                    n -= pascal.get(++rowPos).get(++colPos);
                }
                else {
                    ans.append("\n"+(rowPos+2)+" "+(colPos+1));
                    n -= pascal.get(++rowPos).get(colPos);
                }

            }
            else{
                if(n - pascal.get(rowPos+1).get(colPos) >= 0){
                    ans.append("\n"+(rowPos+2)+" "+(colPos+1));
                    n -= pascal.get(++rowPos).get(colPos);
                }
                else{
                    ans.append("\n"+(rowPos+1)+" "+(colPos));
                    n -= pascal.get(rowPos).get(--colPos);
                }
            }
            // System.out.println("N = "+n);
        }
        System.out.println(ans.toString());
    }
}

