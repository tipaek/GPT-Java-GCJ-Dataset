

import java.util.ArrayList;
import java.util.HashMap;
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
            HashMap<Integer, ArrayList<Integer>>all = new HashMap<>();
            ArrayList<Integer> atl=new ArrayList<>();
            atl.add(0);
            atl.add(1);
            atl.add(2);
            int aa[]=new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ob.nextInt();
                b[i] = ob.nextInt();
                if(all.containsKey(a[i]))
                {
                    ArrayList<Integer> al=all.get(a[i]);
                    al.add(i);
                    all.put(a[i],al);
                }else {
                    ArrayList<Integer> al=new ArrayList<>();
                    al.add(i);
                    all.put(a[i], al);
                }
            }
            sort(a,b,0,n-1);
            StringBuilder ab=new StringBuilder();
            boolean j= false;
            boolean c = true;
            boolean ans=true;
            int jc=b[0];
            int cc=-1;
            String as[]=new String[n];
            ArrayList<Integer> al=all.get(a[0]);
            int r=al.get(0);
            al.remove(0);
            all.put(a[0],al);
            as[r]="J";
            for(int i=1;i<n;i++)
            {   if(jc>a[i])
                {
                    if(cc>a[i])
                    {
                        ans=false;
                        break;
                    }else
                    {
                        ArrayList<Integer> arl=all.get(a[i]);
                        int rt=arl.get(0);
                        arl.remove(0);
                        as[rt]="C";
                        all.put(a[i],arl);
                        cc=b[i];
                    }
                }else
                {
                    jc=b[i];
                 //   ab.append("J");
                    ArrayList<Integer> arl=all.get(a[i]);
                    int rt=arl.get(0);
                    arl.remove(0);
                    as[rt]="J";
                    all.put(a[i],arl);
                }

            }if(ans)
            {
                for(int i=0;i<n;i++)
                {
                    ab.append(as[i]);
                }
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
