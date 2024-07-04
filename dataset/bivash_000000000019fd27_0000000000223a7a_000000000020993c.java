import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = input.nextInt();
        String ans[] = new String[t];
        for(int a=0; a<t; a++) {
            int n = input.nextInt();
            int nums[] = new int[n*n];
            for(int i=0; i<n*n; i++) {
                nums[i]= input.nextInt();
            }
            /////////For sum
            int sum=0;
            int len = (int)Math.sqrt(nums.length);
            int track = 0;
            while(track < nums.length) {
                sum += nums[track];
                track = track + len + 1;
            } 
            ///////For Row
            int countRow = 0;
            boolean isDuplicate = false;
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<nums.length; i++) {
                if((i+1)%len == 0) {
                    if(isDuplicate == true) {
                        countRow++;
                    }
                    list = new ArrayList<Integer>();
                    isDuplicate = false;
                }
                else {
                    if(list.contains(nums[i])) {
                        isDuplicate = true;
                    }
                    else {
                        list.add(nums[i]);
                    }
                }
            }
            ////////////////////For column
            int countCol = 0;
            for(int i=0; i<len; i++) {

                ArrayList<Integer> listCol = new ArrayList<Integer>();
                for(int j=i; j<nums.length; j=j+len) {
                    if(listCol.contains(nums[j])) {
                        countCol++;
                        break;
                    }
                    else {
                        listCol.add(nums[j]);
                    }
                }
            }
            ////////
            ans[a] = "Case #"+(a+1)+": "+sum+" "+countRow+" "+countCol;
        }
        for(String s: ans) {
            System.out.println(s);
        }
    }
}
