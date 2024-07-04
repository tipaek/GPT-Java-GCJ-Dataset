class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0; i < t; i++){
            int n = s.nextInt();
            int[][] r = new int[n][n];
            int[][] c = new int[n][n];
            int trace = 0;
            int rows = 0;
            int cols = 0;
            for(int j = 0; j<n; j++){
                for(int k = 0 ; k<n; k++){
                    int tmp = s.nextInt();
                    if(j == k){
                        trace += tmp;
                    }
                    r[j][tmp] += 1;
                    c[k][tmp] += 1;
                }
            }
            for(int j = 0; j<n; j++){
                for(int k = 0 ; k<n; k++){
                    if(r[j][k] != 1){
                        rows++;
                        break;
                    }
                }
                for(int k = 0 ; k<n; k++){
                    if(c[j][k] != 1){
                        cols++;
                        break;
                    }
                }
            }
        x = i+1;
        System.out.println("#"+x+": "+trace+" "+rows+" "+cols);
        }
    }
}
