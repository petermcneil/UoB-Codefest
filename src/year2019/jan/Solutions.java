package year2019.jan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Almas Baimagambetov
 */
public class Solutions implements Codefest {
    @Override
    public int challenge1 (String s) {
        final Map<String, Integer> numerals = new HashMap() {{
            put("M", 1000);
            put("I", 1);
            put("X", 10);
            put("V", 5);
        }};

        Integer total = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            final String character = String.valueOf(s.charAt(i));
            String nextCharacter = null;

            if (i > 0) {
                nextCharacter = String.valueOf(s.charAt(i - 1));
            }

            if (nextCharacter != null && nextCharacter.equals("I") && !character.equals("I")) {
                total = total + (numerals.get(character) - numerals.get(nextCharacter));
                i--;
            } else {
                total = total + numerals.get(character);
            }

        }

        return total;
    }

    @Override
    public boolean challenge2 (String a, String b) {
        final Map<Character, Integer> aMap = generateMap(a);
        final Map<Character, Integer> bMap = generateMap(b);


        return aMap.equals(bMap);
    }

    private Map<Character, Integer> generateMap (String a) {
        a = a.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            Character c = a.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        return map;
    }

    @Override
    public int challenge3 (int a, int b) {
        return (int) Math.pow(a, b);
    }

    @Override
    public int challenge4 (int a) {
        boolean negative = false;
        final String aString = Integer.toString(a)
                .replace("-", "");

        if (a < 0) {
            negative = true;
        }

        final int length = aString.length();
        final int middlePos = (length + 1) / 2;

        final String start = String.valueOf(aString.charAt(0));
        final String middle = String.valueOf(aString.charAt(middlePos - 1));
        final String end = String.valueOf(aString.charAt(length - 1));

        int fin = Integer.parseInt(start + middle + end);

        if (negative) {
            fin = fin * -1;
        }

        return fin;
    }

    @Override
    public String challenge5 (String s) {
        s = s.toLowerCase();

        StringBuilder fin = new StringBuilder();
        for (int i = 0; i < s.length(); i = i + 2) {
            int first = s.charAt(i) - 96;
            int second = s.charAt(i + 1) - 96;

            char c = (char) (first + second + 96);

            fin.append(c);
        }

        return fin.toString();
    }
}
