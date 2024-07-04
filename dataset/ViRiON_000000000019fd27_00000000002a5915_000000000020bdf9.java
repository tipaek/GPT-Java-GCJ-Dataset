import java.util.*;
class Solution{
    static class Pair{
        int first;
        int second;
        int pos;
        String name;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());
        for(int i=1; i<=cases; i++){
            int size=Integer.parseInt(scan.nextLine());
            Pair []p=new Pair[size];
            for(int j=0; j<size; j++){
                String []task=scan.nextLine().split(" ");
                int start=Integer.parseInt(task[0]);
                int end=Integer.parseInt(task[1]);
                Pair n=new Pair();
                n.first=start;
                n.second=end;
                n.pos=j;
                p[j]=n;

            }

            Arrays.sort(p, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    if(p1.first>p2.first){return 1;}
                    else if(p1.first<p2.first){return -1;}
                    else{
                        return 0;
                    }
                }
            });

            int prev=0;
            int cur=0;
            String []result=new String[size];
            boolean done=true;
            for(int k=0; k<size; k++){
                Pair task=p[k];
                if(prev<=task.first){
                    prev=task.second;
                    result[task.pos]="C";
                }
                else if(cur<= task.first){
                    cur=task.second;
                    result[task.pos]="J";

                }
                else{
                    done=false;
                    break;
                }
            }

            if(done){
                System.out.print("Case #"+i+": ");
                for(int m=0; m<size; m++){
                    System.out.print(result[m]);
                }
                System.out.println();
            }else{System.out.println("Case #"+i+": IMPOSSIBLE");}
            
        }

    }
}