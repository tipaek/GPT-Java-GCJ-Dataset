
class Solution{
    public static void main(String[] args){
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int k = 1;
        while(k <= t){
            int N = sc.nextInt();
            int[][] nums = new int[N][N];
            for(int i=0; i<N; ++i){
                for(int j=0; j<N; ++j){
                    nums[i][j] = sc.nextInt();
                }
            }
            System.out.println("Case #" + k + " " + trace(nums,N) + " "+ rows(nums,N) +" "+ cols(nums,N));
        }
    }
    
    private int trace(int[][] nums, int N){
        int res = 0;
        for(int i=0; i<N; ++i){
            res += nums[i][i];
        }
        return res;
    }
    
    private int rows(int[][] nums, int N){
        int res=0;
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                if(s.contains(nums[i][j])){
                    res+=1;
                    break;
                }
                s.add(nums[i][j]);
                
            }
            s.clear();
        }
        return res;
    }
    private int cols(int[][] nums, int N){
        int res=0;
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                if(s.contains(nums[j][i])){
                    res+=1;
                    break;
                }
                s.add(nums[i][j]);
            }
            s.clear();
        }
        return res;
    }

}
