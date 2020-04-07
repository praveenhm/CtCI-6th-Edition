package Q1_05_One_Away;

public class MySol {

    static boolean oneWayReplace(String s1, String s2) {
        boolean found = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (found) {
                    return false;
                }
                found = true;
            }
        }
        return true;
    }

    static boolean oneWayInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            }
            index1++;
            index2++;
        }
        return true;
    }

    static boolean oneWay(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return oneWayReplace(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return oneWayInsert(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {
            return oneWayInsert(s2, s1);
        }
        return false;
    }

    public static void main(String[] args) {

        String a = "pale";
        String b = "pakes";
        System.out.println(oneWay(a,b));
    }
}