import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // number of test
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); //number of tasks

            int[] sList = new int[n];
            int[] eList = new int[n];
            boolean[] isAllocatedList = new boolean[n];
            char[] namePerTaskList = new char[n];

            for(int j = 0; j<n; j++){
                isAllocatedList[j] = false;
                namePerTaskList[j] = '@';
            }

            for(int j = 0; j<n; j++){
                int s = in.nextInt();
                int e = in.nextInt();
                sList[j] = s;
                eList[j] = e;
            }


            //allocate C first
            int lastEndTime = 0;
            for(int j = 0; j < n; j++) {
                int smallest = 1441; // max minute val + 1
                int indexTmp = -1;
                for(int k = 0; k < n; k++) {
                    if(namePerTaskList[k] == '@'){
                        if((sList[k]-lastEndTime) >= 0 && ((sList[k]-lastEndTime) < smallest)){
                            smallest = (sList[k]-lastEndTime);
                            indexTmp = k;
                        }
                    }
                }
                if(indexTmp != -1) {
                    isAllocatedList[indexTmp] = true;
                    lastEndTime = eList[indexTmp];
                    namePerTaskList[indexTmp] = 'C';
                }
            }

            //then do J
            lastEndTime = 0;
            for(int j = 0; j < n; j++) {
                int smallest = 1441; // max minute val + 1
                int indexTmp = -1;
                for(int k = 0; k < n; k++) {
                    if(namePerTaskList[k] == '@'){
                        if((sList[k]-lastEndTime) >= 0 && ((sList[k]-lastEndTime) < smallest)){
                            smallest = (sList[k]-lastEndTime);
                            indexTmp = k;
                        }
                    }
                }
                if(indexTmp != -1) {
                    isAllocatedList[indexTmp] = true;
                    lastEndTime = eList[indexTmp];
                    namePerTaskList[indexTmp] = 'J';
                }
            }


            String rtn = "";
            for(int j=0; j<n; j++){
                if(namePerTaskList[j] == '@'){
                    rtn = "IMPOSSIBLE";
                    break;
                }
                else{
                    rtn += namePerTaskList[j];
                }
            }

            System.out.println("Case #" + i + ": " + rtn);
        }
    }
}