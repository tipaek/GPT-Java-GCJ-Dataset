import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            ArrayList<String> myList = new ArrayList<String>();
            ArrayList<int[]> int_strings = new ArrayList<int[]>();
            ArrayList<String> answers = new ArrayList<String>();
            for(int i = 0; i < t; i ++){
                myList.add(in.next());
            }
            for(int i = 0; i < myList.size(); i++){
                int[] temp = new int[myList.get(i).length()];
                for(int j = 0; j < myList.get(i).length(); j++){
                    temp[j] = Character.getNumericValue(myList.get(i).charAt(j));
                }
                int_strings.add(temp);
            }
            for(int i = 0; i < t; i ++){
                int[] str = int_strings.get(i);
                int[] min_left = new int[str.length];
                int[] min_right = new int[str.length];

                int [] s = str.clone();
                while(true) {
                    int max = -1;
                    int index = -1;
                    for (int j = 0; j < s.length; j++) {
                        if (s[j] > max) {
                            max = s[j];
                            index = j;
                        }
                    }
                    if(max==0) break;

                    //right parenthesis
                    int[] right_temp = s.clone();
                    boolean rightMin = true;
                    int r_min = max;
                    int r_min_index = index;
                    while (rightMin) {
                        r_min = right_temp[index];
                        for (int j = index; j < right_temp.length; j++) {
                            if (right_temp[j] == 0) break;
                            if (right_temp[j] <= r_min) {
                                r_min = right_temp[j];
                                r_min_index = j;
                            }
                            if(right_temp[j] >= r_min){
                                r_min_index = j;
                            }
                        }

                        if (r_min == 0) break;
                        min_right[r_min_index] += r_min;

                        for (int j = index; j <= r_min_index; j++) {
                            right_temp[j] -= r_min;
                        }
                        //System.out.println(Arrays.toString(min_right) + " min right");

                    }

                    int[] left_temp = s.clone();
                    boolean leftMin = true;
                    int l_min_index = index;
                    int l_min = max;

                    while (leftMin) {
                        l_min = left_temp[index];
                        for (int j = index; j >= 0; j--) {
                            if (left_temp[j] == 0) break;
                            if (left_temp[j] <= l_min) {
                                l_min = left_temp[j];
                                l_min_index = j;
                            }
                            if(left_temp[j] >= l_min){
                                l_min_index = j;
                            }
                        }
                        if (l_min == 0) break;
                        min_left[l_min_index] += l_min;

                        for (int j = index; j >= l_min_index; j--) {
                            left_temp[j] -= l_min;
                        }
                    }


//                    System.out.println(max);
//                    System.out.println(Arrays.toString(min_right) + " min right");
//                    System.out.println(Arrays.toString(min_left) + " min left");


                    int [] updated = new int[left_temp.length];
                    for(int j = 0; j < left_temp.length; j++){
                        if(j <= index) {
                            updated[j] = left_temp[j];
                        }
                        if(j>= index){
                            updated[j] = right_temp[j];

                        }
                    }
                    s = updated;
                }
                String sol = "";
                for(int j = 0; j < str.length; j++){
                    for(int q = 0; q < min_left[j]; q++){
                        sol+= "(";
                    }
                    sol+= str[j];
                    for(int q = 0; q < min_right[j]; q++){
                        sol+= ")";
                    }

                }
                answers.add(sol);

            }
            for(int i = 0; i < answers.size(); i++){
                int cas = i + 1;
                System.out.println("Case " + cas + ": " + answers.get(i));
            }

        }
}