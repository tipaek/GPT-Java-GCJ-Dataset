import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    static class Range implements Comparable<Range>{
        int start;
        int end;
        int index;
        Range(int start , int end,int index){
            this.start=start;
            this.end = end;
            this.index = index;
        }


        @Override
        public int compareTo(Range o) {
            if(this.start != o.start) return this.start-o.start;
            if(this.end != o.end) return this.end-o.end;
            return 0;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            PriorityQueue<Range> r = new PriorityQueue<>();
            int[] accum = new int[1440+1];
            for (int j = 0; j < N; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                accum[start] += 1;
                accum[end] -= 1;
                r.add(new Range(start,end,j));
            }


            boolean possible = true;
            char[] result = new char[N];

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                accum[j+1] += accum[j];
                if(accum[j+1]>2){
                    possible = false;
                    break;
                }
            }
            if(possible){

                int  jamieWorkingUntil = -1;
                int  cameronWorkingUntil = -1;
                while(!r.isEmpty()){
                    Range range =  r.remove();
                    int start = range.start;
                    int end = range.end;

                    if(jamieWorkingUntil ==-1 ){//not working
                        result[range.index]='J';
                        jamieWorkingUntil = end;
                    }else if(start>=jamieWorkingUntil){ //working but until start
                        result[range.index]='J';
                        jamieWorkingUntil = end;
                    }else{//Cameronw should work
                        if(cameronWorkingUntil ==-1 ){//not working
                            result[range.index]='C';
                            cameronWorkingUntil = end;
                        }else if(start>=cameronWorkingUntil) { //working but until start
                            result[range.index] = 'C';
                            cameronWorkingUntil = end;
                        }
                    }
                }
            }

            if(!possible){
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE"  );
            }else{
                System.out.println("Case #"+(i+1)+": " + new String(result)  );
            }
        }

    }
}