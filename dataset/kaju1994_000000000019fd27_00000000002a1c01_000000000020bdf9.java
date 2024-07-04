import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++){
            int n = sc.nextInt();
            int arr[][] = new int[24*60+1][2];
            int end[][] = new int[24*60+1][2];
            int act=1;
            boolean impossible = false;
            for(int j=0;j<n;j++){
                int s = sc.nextInt();
                int e = sc.nextInt();
                if(arr[s][0]==0)
                    arr[s][0]=act;
                else if(arr[s][1]==0)
                    arr[s][1]=act;
                else {
                    impossible = true;
                }
                if(end[e][0]==0)
                    end[e][0]=act;
                else if(end[e][1]==0)
                    end[e][1]=act;
                else {
                    impossible = true;
                }
                act++;
            }
            String result = "";
            if(impossible){
                result = "IMPOSSIBLE";
            }else {
                char res[] = new char[n];
                boolean first = false;
                int firstAct = 0;
                int secondAct = 0;
                boolean second = false;
                for (int j = 0; j < arr.length; j++) {
                    int k = 0;
                    while ( k<2 && end[j][k] > 0 ) { // any activity ending
                        if (firstAct == end[j][k]) {
                            first = false;
                            firstAct = 0;
                        } else if (secondAct == end[j][k]) {
                            second = false;
                            secondAct = 0;
                        }
                        k++;
                    }
                    k = 0;
                    while (k<2 && arr[j][k] > 0) { // any activity starting
                        if (first && second) {
                            result = "IMPOSSIBLE";
                            break;
                        }
                        if (!first) {
                            first = true;
                            firstAct = arr[j][k];
                            res[firstAct - 1] = 'C';
                        } else {
                            second = true;
                            secondAct = arr[j][k];
                            res[secondAct - 1] = 'J';
                        }
                        k++;
                    }
                }
                if (result.equals(""))
                    result = new String(res);
            }
            System.out.println("Case #"+i+": "+result);
        }
    }
}