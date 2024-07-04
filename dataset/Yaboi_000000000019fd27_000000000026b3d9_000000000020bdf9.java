import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);

        int nbrcases = scan.nextInt();


        for(int i =0;i<nbrcases;i++){
            int acts = scan.nextInt();
            event[]sorted = new event[acts];


            for(int j =0;j<acts;j++){
                int start = scan.nextInt();
                int end = scan.nextInt();
                event e = new event(start,end,j);
                sorted[j]=e;
            }

            Arrays.sort(sorted);
            String[]ans = new String[acts];
            int Cend=0;
            int Jend=0;
            for(int k=0;k<acts;k++){
                event e =sorted[k];
                if(e.start>=Cend){
                    ans[e.index]="C";
                    Cend=e.end;
                }
                else if(e.start>=Jend){
                    ans[e.index]="J";
                    Jend=e.end;
                }
                else{
                    System.out.println("Case #" + i + ": Impossible!");
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<acts;j++){
                sb.append(ans[j]);
            }
            if(sb.length()==acts) {
                int king = i+1;
                System.out.println("Case #" + king + ": " + sb.toString());
            }


        }
    }

}
class event implements Comparable<event>{
    int start;
    int end;
    int index;
    public event(int start, int end,int index){
        this.start=start;
        this.end=end;
        this.index=index;
    }
    public int compareTo(event e){
        return Integer.compare(this.start,e.start);
    }

}

