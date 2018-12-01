import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter
 * combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 2-> abc
 * 3-> def
 * 4-> ghi
 * 5-> jkl
 * 6-> mno
 * 7-> pqrs
 * 8-> tuv
 * 9-> wxyz
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinations {
    private static Map<Character, char[]> keyMapping = new HashMap<>();

    static {
        keyMapping.put('2', new char[]{'a', 'b', 'c'});
        keyMapping.put('3', new char[]{'d', 'e', 'f'});
        keyMapping.put('4', new char[]{'g', 'h', 'i'});
        keyMapping.put('5', new char[]{'j', 'k', 'l'});
        keyMapping.put('6', new char[]{'m', 'n', 'o'});
        keyMapping.put('7', new char[]{'p', 'q', 'r', 's'});
        keyMapping.put('8', new char[]{'t', 'u', 'v'});
        keyMapping.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            System.out.println(new ArrayList<>());
        }
        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTracing(result, sb, chars, 0);
        return result;
    }

    private void backTracing(List<String> result, StringBuilder current, char[] chars, int index) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        if (current.length() > chars.length) {
            return;
        }

        for (int i = index; i < chars.length; i++) {
            for (int j = 0; j < keyMapping.get(chars[i]).length; j++) {
                current.append(keyMapping.get(chars[i])[j]);
                backTracing(result, current, chars, i + 1);
                if (current.length() > 0) current.deleteCharAt(current.length() - 1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("First case:");
        for (String s : new LetterCombinations().letterCombinations("23")) {
            System.out.println(s);
        }

        System.out.println("Second case: ");
        for (String s : new LetterCombinations().letterCombinations("239")) {
            System.out.println(s);
        }
    }
}
