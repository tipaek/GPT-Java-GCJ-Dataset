import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int q = 1; q <= t; ++q) {
            int count = in.nextInt();
            in.nextLine();

            int data[][] = new int[count][2];
            for(int i=0; i<count; i++) {
                String ss = in.nextLine();
                String newss[] = ss.split(" ");
                data[i][0] = Integer.parseInt(newss[0]);
                data[i][1] = Integer.parseInt(newss[1]);
            }

            int k[] = new int[count];
            for(int i=0; i<count; i++)
            {
                k[i] = i;
            }
            for(int i=0; i<(count-1); i++)
            {
                for(int j=0; j<(count-i-1); j++)
                {
                    if(data[j][0] > data[j+1][0])
                    {
                        int temp[] = data[j];
                        data[j] = data[j+1];
                        data[j+1] = temp;
                        int kk = k[j];
                        k[j] = k[j+1];
                        k[j+1] = kk;                    }
                }
            }
            int cpoint[] = data[0];
            int jpoint[] = new int[]{0,0};
            String res = "C";

            for(int i=1; i<count; i++) {
                if(data[i][0] >= cpoint[1]) {
                    cpoint = data[i];
                    res += "C";
                }
                else {
                    if(data[i][0] >= jpoint[1]) {
                        jpoint = data[i];
                        res += "J";
                    }
                    else {
                        if(data[i][1] <= cpoint[0]) {
                            res += "C";
                        }
                        else {
                            if(data[i][1] <= jpoint[0]) {
                                res += "J";
                            }
                            else {
                                res = "IMPOSSIBLE";
                                break;
                            }
                        }
                    }
                }
            }

            String newR = "";
            List newk = Arrays.asList(k);
            if(res.equals("IMPOSSIBLE")) {
                newR = res;
            } else {
                for(int i=0; i<k.length; i++) {
                    for(int j=0; j<k.length; j++) {
                        if (k[j] == i)
                            newR += res.charAt(j);
                    }
                }
            }
            System.out.println("Case #" + q + ": "+newR);
        }
    }
}