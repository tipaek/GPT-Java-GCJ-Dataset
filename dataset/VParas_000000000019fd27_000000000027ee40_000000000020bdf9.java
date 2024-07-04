
import java.util.Scanner;

public class Solution {
    static void merge(int arr[], int b[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
        int LL[] = new int[n1];
        int RR[] = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
            LL[i] = b[l + i];
        }

        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
            RR[j] = b[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                b[k] = LL[i];
                i++;
            } else {
                arr[k] = R[j];
                b[k] = RR[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            b[k] = LL[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            b[k] = RR[j];
            j++;
            k++;
        }
    }

    static void sort(int arr[], int b[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, b, l, m);
            sort(arr, b, m + 1, r);
            merge(arr, b, l, m, r);
        }
    }
    public static void main (String[] args) throws java.lang.Exception {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        int count=1;
        while (t != 0)
        {
            int n = ob.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ob.nextInt();
                b[i] = ob.nextInt();
            }
            sort(a,b,0,n-1);
            StringBuilder ab=new StringBuilder();
            boolean j= false;
            boolean c = true;
            boolean ans=true;
            ab.append("J");
            int jc=b[0];
            int cc=-1;
            for(int i=1;i<n;i++)
            {
                if(jc>a[i])
                {
                    if(cc>a[i])
                    {
                        ans=false;
                        break;
                    }else
                    {
                        ab.append("C");
                        cc=b[i];
                    }
                }else
                {
                    jc=b[i];
                    ab.append("J");
                }

            }if(ans)
            {
                System.out.println("Case #"+count+": "+ab.toString());
            }else
            {
                System.out.println("Case #"+count+": IMPOSSIBLE");
            }
            count++;
            t--;
        }
    }
}
