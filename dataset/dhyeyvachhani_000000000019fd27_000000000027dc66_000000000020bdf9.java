
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = in.nextInt();
        boolean isImpossible=false;
        boolean c=true,j=true;

        for(int i=0;i<total;i++){
            int cases = in.nextInt();in.nextLine();
            char[] task = new char[cases];
            //int taskCount=0;

            String work[] = new String[cases];
            for(int k=0;k<cases;k++){
                work[k] = in.nextLine();
            }
            int start[] = new int[cases];
            int end[] = new int[cases];

            //set START and END
            for(int k=0;k<cases;k++){
                String temp[] = work[k].split(" ");
                start[k] = Integer.parseInt(temp[0]);
                end[k] = Integer.parseInt(temp[1]);
            }

            //set ID
            int id[] = new int[cases];
            for(int k=0;k<cases;k++){
                id[k]=k;
            }

            //sortby START

            for(int k =0;k<cases-1;k++){
                for(int l=0;l<cases-k-1;l++){

                    int temp;

                    if(start[l]>start[l+1]){
                        temp = start[l];
                        start[l]=start[l+1];
                        start[l+1]=temp;

                        temp=end[l];
                        end[l]=end[l+1];
                        end[l+1]=temp;

                        temp=id[l];
                        id[l]=id[l+1];
                        id[l+1]=temp;
                    }
                }
            }
            int cEnd=0,jEnd=0;

            for(int k=0;k<cases;k++){
                if(cEnd<=start[k]){
                    cEnd=end[k];
                    task[id[k]]='C';
                    continue;
                    //taskCount++;
                    //c=false;
                }
                else if(jEnd<=start[k]){
                    jEnd=end[k];
                    task[id[k]]='J';
                    continue;
                    //taskCount++;
                    //j=false;
                }
                else{
                    isImpossible=true;
                    break;
                }
            }
            if(isImpossible){
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE" );
                isImpossible=false;
            }
            else{
                String str = new String(task);
                System.out.println("Case #" + (i+1) + ": "+str );
            }
        }
    }
}