import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        String output="";
        int[] cameron;
        int[] jamie;
        int start;
        int end;
        int count = 1;
        boolean job = false;
        boolean j = true;
        boolean c = true;
        boolean imp = false;

        for(int i = 0; i<T;i++){
            int numberActivities = in.nextInt();
            cameron = new int[2*numberActivities];
            jamie = new int[2*numberActivities];

            for(int k = 0;k<numberActivities;k++){
                start = in.nextInt();
                end = in.nextInt();
                if(!imp){
                    for(int a = 0; a<2*numberActivities && !job;a+=2){
                        if(cameron[a] == cameron[a+1] && c){
                            cameron[a] = start;
                            cameron[a+1] =end;
                            job = true;
                            output += "C";
                        }
                        else if(jamie[a] == jamie[a+1] && j){
                            jamie[a] = start;
                            jamie[a+1] =end;
                            job = true;
                            output += "J";
                        }

                        if(cameron[a] < start && start < cameron[a+1] || cameron[a] < end && end < cameron[a+1] || start < cameron[a] && cameron[a+1] < end){
                            c = false;
                        }
                        if(jamie[a] < start && start < jamie[a+1] || jamie[a] < end && end <jamie[a+1] || start < jamie[a] && jamie[a+1] < end){
                            j = false;
                        }
                    }

                    if(job == false){
                        output = "IMPOSSIBLE";
                        imp = true;
                    }

                    job = false;
                    j= true;
                    c = true;
                }

            }

            System.out.print("Case #"+count+": ");
            System.out.print(output);
            System.out.println();
            imp = false;
            output = "";
            count ++;

        }

    }
}
