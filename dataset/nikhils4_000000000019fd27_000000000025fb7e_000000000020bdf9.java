class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int caseno = 1;
        while(test-->0){
            boolean possible = true;
            int tasks = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int[] J = new int[1441];
            int[] C = new int[1441];
            while(tasks-->0){
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean Jfree = true;
                boolean Cfree = true;
                for(int i = start; i < end; i++){
                    if(J[i] != 0 && Jfree){
                        Jfree = false;
                    }
                    if(C[i] != 0 && Cfree){
                        Cfree = false;
                    }
                }
                
                if(Jfree){
                    sb.append('J');
                    for(int i = start; i < end; i++){
                        J[i] = 1;
                    }
                } else if (Cfree){
                    sb.append('C');
                    for(int i = start; i < end; i++){
                        C[i] = 1;
                    }
                } else {
                    possible = false;
                    break;
                }
            }
            if(possible){
                System.out.println("Case #" + caseno++ + ": " + sb);
            } else {
                System.out.println("Case #" + caseno++ + ": IMPOSSIBLE");
            }
            sb = new StringBuilder();
        }
    }
}