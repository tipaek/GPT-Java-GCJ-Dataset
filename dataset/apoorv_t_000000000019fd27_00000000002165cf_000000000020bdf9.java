import java.util.*;

class Solution{


    public static void main(String[] args){
        class Pair implements Comparable<Pair> {
            public final int index;
            public final int value;
            public char c;

            public Pair(int index, int value) {
                this.index = index;
                this.value = value;
            }

            @Override
            public int compareTo(Pair other) {
                //multiplied to -1 as the author need descending sort order
                return Integer.valueOf(this.value).compareTo(other.value);
            }
        }
        int t;
        int n,flag;
        StringBuilder res;
        int endJ,endC;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        int testC=0;
        while(t!=0){
            res=new StringBuilder();
            endC=0;
            endJ=0;
            flag=0;
            n = in.nextInt();
            int[][] activities = new int[n][2];
            Pair[] arr = new Pair[n];
            for(int i=0;i<n;i++){
                endJ=0;
                endC=0;
                activities[i][0] = in.nextInt();
                activities[i][1]= in.nextInt();
                arr[i]= new Pair(i,activities[i][0]);
                int[] a = activities[0];
            }
            Arrays.sort(arr);
            for(int i=0;i<n;i++){
                System.out.println(arr[i].index + " " + arr[i].value);
                if(endC<=arr[i].value){
                    endC=activities[arr[i].index][1];
                    arr[i].c='C';
                }
                else if(endJ<=arr[i].value){
                    endJ=activities[arr[i].index][1];
                    arr[i].c='J';
                }
                else{
                    flag=-1;
                    break;
                }
            }
            if(flag==-1)
                res=new StringBuilder("IMPOSSIBLE");
            else {
                Arrays.sort(arr, new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return o1.index-o2.index;
                    }
                });
                for(int i=0;i<n;i++)
                    res.append(arr[i].c);
            }
            System.out.println("Case #" + (++testC) + ": " + res.toString());
            t--;
        }
    }

}