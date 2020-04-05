package Q1_06_String_Compression;

/**
 * couple tricks
 * take compressed_string as a string instead of char[]
 *
 */
public class MySol {

    static String string_compression(String s) {

        //String cs = "";
        int index = 0;
        StringBuilder cs = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            index++;
            // i + 1 to get the last character in the array
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                //cs += "" + s.charAt(i) + index; // without "" string this doesn't work
                cs.append(s.charAt(i));
                cs.append(index);
                index = 0;
            }
        }
        return cs.length() < s.length() ? cs.toString() : s;
    }

    public static void main(String[] args) {
        String s1 = "aabccccaaaa";
        String s2 = "aaaaabcd";

        System.out.println(string_compression(s1));
    }
}
