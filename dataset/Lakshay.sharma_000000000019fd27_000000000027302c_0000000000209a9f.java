import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class Solution {
    public static int fill(char a[], char c, int i, int j, int min, int uIndex) {
       int k = uIndex;
       /*
        if (c == '0') {
            for (k = uIndex; k < uIndex + j - i ; k++) {
                a[k] = c;
            }
            uIndex = k;
            return uIndex;
        }
       */ //  int k = uIndex;
        int v = c - 48;
      //  System.out.println("v is =" + v);
        for (k = uIndex; k < uIndex + v - min; k++) {
            a[k] = '(';
        }
        uIndex = k;
        for (k = uIndex; k < uIndex + j - i + 1; k++) {
            a[k] = c;
        }
        uIndex = k;
        for (k = uIndex; k < uIndex + v - min; k++) {
            a[k] = ')';
        }
        uIndex = k;
        return uIndex;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int t = 0; t < T; t++) {

            String str = reader.readLine();
            int n = str.length();
            char arr[] = str.toCharArray();

            int min = Integer.MAX_VALUE;
            char minChar = '1';
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i] - 48;
                if (num < min) {
                    minChar = arr[i];
                    min = num;
                }
            }
            char a[] = new char[551];

            for (int i = 0; i < min; i++) {
                a[i] = '(';
            }
            int uIndex = min;
            int j = 0;
          //  System.out.println(uIndex);
            int i = 0;
            while (i < n) {
                for (j = i + 1; j < n; j++) {
                    if (arr[i] != arr[j]) {

                        uIndex = fill(a, arr[i], i, j - 1, min, uIndex);
                        // i=j;
                        break;
                    }
                    if (arr[i] == arr[j] && j == n - 1) {
                        uIndex = fill(a, arr[i], i, j, min, uIndex);
                    i=n+1;
                    break;
                    }
                }
                if(i!=n+1)
                i = j;
            }
           // System.out.println("uindex is="+uIndex+"i is="+i);


            if(i!=n+1) {
                if (arr[i - 1] == minChar) {
                    a[uIndex] = minChar;
                    uIndex += 1;
                    int m = uIndex;
                    for (m = uIndex; m < uIndex + min; m++)
                        a[m] = ')';
                    uIndex = m;
                } else {
                    uIndex = uIndex = fill(a, arr[n - 1], n - 1, n - 1, min, uIndex);
                    int m = uIndex;
                    for (m = uIndex; m < uIndex + min; m++)
                        a[m] = ')';
                    uIndex = m;
                }
            }
int v=t+1;
            System.out.print("Case #"+v+" :  ");
            for (int k = 0; k < uIndex; k++) {
                System.out.print(a[k]);
            }
            System.out.println() ;
        }
    }
}
