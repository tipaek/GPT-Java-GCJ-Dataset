import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int y = 1; y <= t; ++y) {
            String line = in.next();
            char[]arr = line.toCharArray();
            int[]nums = new int[arr.length];
            int[]maxes = new int[arr.length];

            Par[] answer = new Par[arr.length];
            for (int i =0; i<arr.length; i++)
            {
                int temp = Character.getNumericValue(arr[i]);
                nums[i] = temp;
                maxes[i] = temp;
                answer[i] = new Par(0,0,temp);
            }
            Arrays.sort(maxes);

            int num, index, left, right;
            index =-3;
            for(int i = maxes.length-1; i>=0; i--) {

                num = maxes[i];

                    boolean go = true;

                for (int k = 0; k < nums.length; k++) {
                    if (num == nums[k]) {
                        index = k;
                        break;
                    } else if (num == nums.length - 1) {
                        go = false;
                    }

                }
                if(nums[index]>0){
                if (go) {
                    for (int j = 1; j <= num; j++) {
                        left = 0;
                        right = 0;
                        //find left limit
                        if (index >= 1) {
                            for (int l = index - 1; l >= 0; l--) {
                                if ((nums[l] < nums[index]) || (nums[l] == 0)) {

                                    left = l + 1;
                                 /*   System.out.println("nums[index]: " + nums[index]);
                                    System.out.println("index: " + index);
                                    System.out.println("nums[l] " + nums[l]);
                                    System.out.println("l: " + l);
                                    System.out.println("left: " + left);*/
                                    break;
                                } else if (l == 0) {
                                    left = 0;
                                  //  System.out.println("huh left");
                                    break;

                                }
                            }
                        } else {

                            left = 0;/*
                            System.out.println("nums[index]: " + nums[index]);
                            System.out.println("index: " + index);

                            System.out.println("left: " + left);*/
                        }
                        //find right limit
                        if (index < nums.length - 1) {
                            for (int r = index + 1; r < nums.length; r++) {
                                if ((nums[r] < nums[index]) || (nums[r] == 0)) {
                                    right = r - 1;
                            /*        System.out.println("nums[index]: " + nums[index]);
                                    System.out.println("index: " + index);
                                    System.out.println("nums[r] " + nums[r]);
                                    System.out.println("r: " + r);
                                    System.out.println("right: " + right);
                              */      break;
                                } else if (r == nums.length - 1) {
                                    right = r;
                                //    System.out.println("huh right");
                                    break;
                                }
                            }
                        } else {
                            right = nums.length - 1;
                          //  System.out.println("nums[index]: " + nums[index]);
                            //System.out.println("index: " + index);
                            //System.out.println("right: " + right);
                        }
                        answer[left].setLeft();
                        answer[right].setRight();
                        //get rid of that maxes[i] from nums
                        for (int b = left; b <= right; b++) {
                            nums[b]--;
                        }
                        if (nums[index] == 0) {
                         //   System.out.println("broken");
                            break;
                        }
                    }
                }
            }
            }
            String ans = "";
            for (int i =0; i<answer.length; i++)
            {
                for(int l =0; l<answer[i].getLeft(); l++)
                {
                    ans+="(";
                }
                ans+=answer[i].getVal();
                for(int l =0; l<answer[i].getRight(); l++)
                {
                    ans+=")";
                }
            }

            System.out.println("Case #" + y + ": " + ans);
        }
    }
    static class Par{
        private int le;
        private int ri;
        private int val;
        Par(int le, int ri, int val)
        {
            this.le = le;
            this.ri = ri;
            this.val = val;
        }
        public int getLeft(){
            return le;
        }
        public int getRight(){
            return ri;
        }
        public int getVal(){
            return val;
        }
        public void setLeft(){
            le++;
        }
        public void setRight()
        {
            ri++;
        }

    }
}
