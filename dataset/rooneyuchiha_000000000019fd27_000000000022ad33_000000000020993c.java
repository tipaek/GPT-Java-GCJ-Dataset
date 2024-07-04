class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tt = Integer.parseInt(br.readLine());
        int ccc=0,cckc=0;
        for (int ll=0;ll<=1000;ll++)
        {
            ccc++;
            
        }
        for (int kq = 1; kq <= Tt; kq++) {
            int nums = Integer.parseInt(br.readLine());
            String[] bb = new String[nums];
            for (int i = 0; i < nums; i++) {
                bb[i] = br.readLine();
            }
            
            int[][] cc = new int[nums][nums];
            int trace=0;
            for (int i = 0; i < nums; i++) {
                String[] m = bb[i].split(" ");
                for (int j = 0; j < nums; j++) {
                    cc[i][j] = Integer.parseInt(m[j]);
                    if(i==j){
                        trace+=cc[i][j];
                    }
                }
            }
            for (int lkl=0;lkl<=1000;lkl++)
            {
            cckc++;
            
             }
            int r_king=0,c_king=0;
            for(int i=0;i<nums;i++) {
                Set<Integer> r_1 = new HashSet<Integer>();
                Set<Integer> c_1 =new HashSet<>();
                for(int j=0;j<nums;j++){
                    r_1.add(mat[i][j]);
                    c_1.add(mat[j][i]);
                }
                if(r_1.size()!=nums){
                    r_king++;
                }
                if(c_1.size()!=nums){
                    c_king++;
                }
            }
            String temp ="Case #"+kq+": "+trace+" "+r_1+" "+c_1;
            System.out.println(temp);
        }
    }
}