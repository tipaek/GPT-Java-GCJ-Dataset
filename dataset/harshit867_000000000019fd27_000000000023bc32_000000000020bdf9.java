//coding jam#2
import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc= new Scanner(System.in);

        int t=1;

        t= Integer.parseInt(br.readLine());
        int caseNo=1;

        while(caseNo<=t){
            int n=Integer.parseInt(br.readLine());
            Temp[] tempArr= new Temp[n];

            for(int i=0;i<n;i++){
                String[] strArr = br.readLine().split(" ");
                int start=Integer.parseInt(strArr[0]);
                int end=Integer.parseInt(strArr[1]);

                Temp temp = new Temp(start,end);

                tempArr[i]=temp;
            }

            Arrays.sort(tempArr);

            System.out.println(findSolution(tempArr,n,caseNo));
            caseNo++;
        }

    }

    static String findSolution(Temp[] tempArr,int n,int caseNo){
        String res="Case #"+caseNo+": ";
        String str1="";

        int c=-1;
        int j=-1;

        for(int i=0;i<n;i++){
            int start = tempArr[i].start;
            int end = tempArr[i].end;

            if(j>=0){
                if(tempArr[j].end<=start){
                    j=-1;
                }
            }

            if(c>=0){
                if(tempArr[c].end<=start){
                    c=-1;
                }
            }


            if(j<0){
                str1+="J";
                j=i;
                continue;
            }else if(c<0){
                str1+="C";
                c=i;
                continue;
            }

            if(c>=0&&j>=0){
                if(tempArr[j].end<=start){
                    str1+="J";
                    j=i;
                }else if(tempArr[c].end<=start){
                    str1+="C";
                    c=i;
                }else{
                    str1="IMPOSSIBLE";
                    break;
                }
            }

        }



        return res+str1;
    }

    static class Temp implements Comparable<Temp>{
        int start;
        int end;

        Temp(int s, int e){
            start=s;
            end=e;
        }

        @Override
        public int compareTo(Temp o) {
            if(start>o.start){
                return 1;
            }else if(start<o.start){
                return -1;
            }else{
                return 0;
            }
        }
    }



}









