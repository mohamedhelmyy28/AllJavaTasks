package Lab2;

import java.util.function.Predicate;
import java.util.function.BiPredicate;

public class StringUtils {
    public boolean betterString(String s1, String s2, BiPredicate<String, String> p) {
        return p.test(s1, s2);
    }

    public boolean isLetter(String string1, Predicate<Character> p2) {
        boolean letter = true;
        for (int i = 0; i < string1.length(); i++) {
            char c = string1.charAt(i);
            if (!p2.test(c))
                letter = false;
        }
        return letter;
    }
}
