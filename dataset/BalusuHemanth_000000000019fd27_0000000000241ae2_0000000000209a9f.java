class TestClass {
public static void main(String args[] ) throws Exception {
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();

sc.nextLine();

for(int i=0; i<n; i++) {
int SUVO = 0 , SUVOJIT = 0;
String s = sc.nextLine();
s= s.toUpperCase();
int m =0;
while(s.contains("SUVOJIT") ) {
SUVOJIT++;
m =s.indexOf("SUVOJIT");
s = (s.substring(0, m)).concat(s.substring(m+"SUVOJIT".length()-1, s.length()));
}
while(s.contains("SUVO") ) {
SUVO++;
m =s.indexOf("SUVO");
s = (s.substring(0, m)).concat(s.substring(m+"SUVO".length()-1, s.length()));
}
System.out.println("SUVO = "+SUVO+", SUVOJIT = "+SUVOJIT);
}

}
}