import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String lines;

        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; i++){
            StringBuilder result = new StringBuilder("");
            lines = in.nextLine();
            String[] strs = lines.split("");
            int[] s = new int[strs.length];

            for (int j=0; j < strs.length; j++) {
                s[j] = Integer.parseInt(strs[j]);
            }

            //First digit
            String openPar = "(";
            String closePar = ")";
            int sumOPar = 0;
            int sumCPar = 0;
            int front = 0;
            if (s[0] != 0){
                int l=0;
                while (l < s[0]){
                    result.append(openPar);
                    l++;
                    sumOPar++;
                    front++;
                }
                result.append(s[0]);
                front++;

                l=0;
                while (l < s[0]){
                    result.append(closePar);
                    l++;
                    sumCPar++;
                }

                if (1 > strs.length){
                    if (s[0] > s[1]){
                        front = front + (s[0] - s[1]);
                    }
                }

            } else{
                result.append("0");
                front++;
            }

            //Next digits
            for (int k=1; k < strs.length; k++){
                int l=0;
                if (s[k] == s[k-1]){
                    result.insert(front, s[k]);
                    front++;
                    continue;
                }
                if (s[k] != 0){
                    if (s[k] >= sumOPar && s[k] != s[k-1]){
                        l = (s[k]-sumOPar) + sumCPar;
                        while (l > 0){
                            result.insert(front, openPar);
                            l--;
                            sumOPar++;
                            front++;
                        }
                        result.insert(front, s[k]);
                        front++;

                        l = s[k]-sumCPar;
                        while (l > 0){
                            result.append(closePar);
                            l--;
                            sumCPar++;
                        }

                        if (sumOPar > sumCPar){
                            l = sumOPar - sumCPar;
                            while (l > 0) {
                                result.append(closePar);
                                l--;
                                sumCPar++;
                            }
                        }
                    }
                    else{
                        result.insert(front, s[k]);
                        front++;
                    }
                }

                /*if (k+1 < strs.length && k < k+1){
                    front = front + (s[k+1] - s[k]);
                }*/
                else{
                    result.append("0");
                    front++;
                }
            }
            System.out.println("Case #" + (i+1) + ": " + result);
        }
    }
}