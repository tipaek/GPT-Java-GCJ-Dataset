import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

public static void main(String[] args) throws NumberFormatException, IOException {

int t = Integer.parseInt(br.readLine());

int index = 1;
while (t-- > 0) {
solve(index++);
}

}
//012 - 0(1(2))
private static void solve(int index) throws NumberFormatException, IOException {
String[] s = br.readLine().split("");

String result="";
int previousValue= 0;
for(int i=0 ; i < s.length ; i++){
int value = Integer.parseInt(s[i]);
if(value > previousValue){
for( int j=1 ; j <= value-previousValue ; j++){
    result+= "(";
}
}
else if (value < previousValue){
    for( int k=1 ; k <= previousValue-value ; k ++){
        result+= ")";
    }
}
result+=Integer.toString(value);
previousValue= value;
}

for(int a=1 ; a <= previousValue ; a ++){
    result+= ")";
}


System.out.println("Case #" + index + ": " + result);

}
}
