package Q1_01_Is_Unique;

/**
 * my solution to the above problem
 */
public class MySol {

    public static void main(String[] args) {
        String[] str = {"hello", "abcde", "america"};
        for (String word : str) {
            System.out.println(isUnique(word)+" "+word);
        }
    }

    static boolean isUnique(String str) {
        // since there are only 128 unique ASCII characters
        if (str.length() > 128) return false;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) return false;
            }
        }
        return true;
    }
}
