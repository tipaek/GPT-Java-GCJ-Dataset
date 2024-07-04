import java.util.Scanner;

public class Solution {
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int j = 1; j <= t; j++) {
            int n = scn.nextInt();
            int[] s = new int[n];
            int[] e = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = scn.nextInt();
                e[i] = scn.nextInt();
            }
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=i;
            }
            for (int x = 0; x < n; x++) {
                for (int z = 0; z < n - x - 1; z++) {
                    if (s[z] > s[z + 1]) {
                        int temp = s[z];
                        s[z] = s[z + 1];
                        s[z + 1] = temp;
                        int temp2 = e[z];
                        e[z] = e[z + 1];
                        e[z + 1] = temp2;
                         temp=arr[z];
                         arr[z]=arr[z+1];
                         arr[z+1]=temp;
                    }
                }
            }
            int cam = 0;
            int jam = 0;
            int tc = 0;
            int tj = 0;
            int flag = 0;
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (s[i] >= tc)
                    cam = 0;
                if (s[i] >= tj)
                    jam = 0;
                if (cam == 0) {
                    cam = 1;
                    tc = e[i];
                    ans.append("C");
                } else if (jam == 0) {
                    jam = 1;
                    tj = e[i];
                    ans.append("J");
                } else {
                    flag = 1;
                    break;
                }

            }

            if (flag == 1) {
                System.out.println("Case #" + j + ": IMPOSSIBLE");
            } else{
                StringBuilder finalans=new StringBuilder();
                char[] b=new char[n];
                for(int i=0;i<n;i++){
                    b[arr[i]]=ans.charAt(i);
                }

                for(int i=0;i<n;i++){
                    finalans.append(b[i]);
                }
                System.out.println("Case #" + j + ": " + finalans);
            }
        }
    }


}