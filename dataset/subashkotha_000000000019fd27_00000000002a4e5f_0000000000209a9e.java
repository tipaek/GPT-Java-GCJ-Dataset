import java.util.Scanner;

class Solution {

    public static int[] complement(int ans[]) {
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = 1 - ans[i];
        }
        return ans;
    }

    public static int[] reverse(int ans[]) {
        int temp[] = new int[ans.length];
        for (int i = 0; i < ans.length; ++i) {
            temp[i] = ans[ans.length - 1 - i];
        }
        return temp;
    }

    public static int find_x(int ans[]) {
        for (int i = 0; i < ans.length; ++i) {
            if (ans[i] == ans[ans.length - 1 - i])
                return i;
        }
        return -1;
    }

    public static int find_y(int ans[]) {
        for (int i = 0; i < ans.length; ++i) {
            if (ans[i] != ans[ans.length - 1 - i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();

        while(t!=0){
            int ans[] = new int[b];
            int i=0,j=b-1;
            int qnum = 1;
            boolean flip = true;
            while(qnum<=150&&i<=j){
                if(flip){
                    System.out.println(i+1);
                    int key = sc.nextInt();
                    ans[i] = key;
                    i++;
                }
                else{
                    System.out.println(j+1);
                    int key = sc.nextInt();
                    ans[j] = key;
                    j--;
                }
                flip = !flip;
                qnum++;
                if(qnum>10&&qnum%10==1){
                    int x = find_x(ans);
                    int y = find_y(ans);

                    if(y==-1||x==-1)
                    {
                        System.out.println(1);
                        qnum++;
                        int p = sc.nextInt();
                        if(p==ans[0])
                            continue;
                        else
                            ans = complement(ans);
                    }

                    else{
                        System.out.println(x+1);
                        int p = sc.nextInt();
                        System.out.println(y+1);
                        int q = sc.nextInt();
                        int r = ans[x];
                        int s = ans[y];
                        if(p==r&&q==s)
                            continue;
                        else if(p==1-r&&q==1-s)
                            ans = complement(ans);
                        else if(p==ans[ans.length-x-1]&&q==ans[ans.length-y-1])
                            ans = reverse(ans);
                        else 
                            ans = reverse(complement(ans));
                        qnum = qnum+2;
                    }
                }
            }
            for(int k=0; k<b; ++k){
                System.out.print(ans[k]);
            }
            System.out.println();
            if(sc.next().equals("N"))
                break;
            t--;
        }
        sc.close();
    }
}