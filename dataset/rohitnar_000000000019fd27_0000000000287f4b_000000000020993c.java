class Solution{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        int count=1;
        List<String> result = new ArrayList<>();
        while(t--!=0){
            int n = sc.nextInt();
            int [][]a=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=sc.nextInt();
                }
            }
            int k=0,r=0,c=0,c1=0,c2=0;
            int sum = (n*(n+1))/2;
            Set<Integer> s1 = new HashSet<>();
            Set<Integer> s2 = new HashSet<>();
            for(int i=0;i<n;i++){
                r=0;
                c=0;
                s1.clear();
                s2.clear();
                for(int j=0;j<n;j++){
                    if(i==j) {
                        k = k + a[i][j];
                    }
                    s1.add(a[i][j]);
                    s2.add(a[j][i]);
                    r=r+a[i][j];
                    c=c+a[j][i];

                }
                if(s1.size()<n||r!=sum){
                    c1++;
                }
                if(s2.size()<n||c!=sum){
                    c2++;
                }
            }
            String s = "Case #"+count+":"+ k+" "+c1+" "+c2;
            result.add(s);
            count++;
        }
        result.forEach(s->{
            System.out.println(s);
            System.out.println();
        });

    }
}