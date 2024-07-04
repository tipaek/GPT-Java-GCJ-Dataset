import java.util.*;

class Solution{
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        for(int t = 0;t< tc;t++){
			int K = in.nextInt();
			ArrayList<int[]> pairs = new ArrayList<int[]>();
			for(int i = 0;i< K;i++){
			    int[] pair = new int[3];
			    pair[0] = in.nextInt();
			    pair[1] = in.nextInt();
			    //in.nextLine();
			    pair[2] = i;
			    pairs.add(pair);
			}
            solve(pairs,t+1);
        }
    }
    private static void solve(List<int[]> times, int caseNo){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            if(a[1] != b[1])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int J = 0;
        int C = 0;
        char[] res = new char[times.size()];
        for(int[] p: times){
            pq.offer(p);
        }
        while(pq.size() >0){
            int[] pair = pq.poll();
            if(pair[0]<J && pair[0]<C){
                System.out.println("Case #"+caseNo+": IMPOSSIBLE");
                return;
            }
            if(pair[0]>=J && pair[0]>=C){
                if(J<C){
                    res[pair[2]] = 'C';
                    C = pair[1];
                }
                else{
                    res[pair[2]] = 'J';
                    J = pair[1];
                }
            }
            else if(pair[0]>=J){
                res[pair[2]] = 'J';
                J = pair[1];
            }
            else{
                res[pair[2]] = 'C';
                C = pair[1];
            }
        }
        System.out.println("Case #"+caseNo+": "+new String(res));
    }
	
}