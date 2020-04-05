package Q1_03_URLify;

public class MySol {

    public static void main(String[] args) {

        String s = "Mr john smith    ";
        int len = 13;
        System.out.println(urlify(s, len));
    }

    static String urlify(String s, int l) {
        s = s.substring(0, Math.min(s.length(), l));// No exceptions and trims even shorter
        int spc = (s.length() - s.replaceAll(" ", "").length()) * 2;
        char[] ca = new char[l + spc];
        int j = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == ' ') {
                ca[j] = '%';
                j++;
                ca[j] = '2';
                j++;
                ca[j] = '0';
            } else {
                ca[j] = s.charAt(i);
            }
            j++;
        }
        return new String(ca);
    }

}
