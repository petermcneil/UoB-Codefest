package year2018.dec.level6;

import java.lang.reflect.Constructor;

/**
 * @author Almas Baimagambetov
 */
public class Solutions implements Codefest {
    @Override
    public int challenge1 (String s) {
        String[] c = s.split(" ");
        int total = 0;
        String operation = "+";
        for (String x : c) {
            try {
                int numberToAdd = Integer.parseInt(String.valueOf(x));

                switch (operation) {
                    case "+":
                        total = numberToAdd + total;
                        break;
                    case "*":
                        total = numberToAdd * total;
                        break;
                    case "-":
                        total = total - numberToAdd;
                        break;
                    case "/":

                        total = total / numberToAdd;
                        break;
                    default:
                        total = numberToAdd + total;
                        break;
                }

            } catch (NumberFormatException ne) {
                operation = x;
            }
        }


        return total;
    }

    @Override
    public int[] challenge2 (int[] array, int a) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int k = array[i] + array[j];
                if (k == a) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    @Override
    public int challenge3 (int[] array1, int[] array2) {
        int t1 = find(array1);
        int t2 = find(array2);


        return t1 + t2;
    }

    /// 103, 105
    /// 802
    private int find (int[] array1) {
        int total = 0;
        for (int i = 0; i < array1.length; i++) {
            int temp = array1[i];

            char[] charArray = String.valueOf(temp).toCharArray();

            String tempString = "";

            for (int j = charArray.length - 1; j >= 0; j--) {
                tempString = tempString.concat(String.valueOf(charArray[j]));
            }

            total = total + Integer.parseInt(tempString);
        }
        return total;
    }

    @Override
    public <T> T challenge4 (Class<T> c, double a, double b) {
        Constructor<?>[] con = c.getDeclaredConstructors();

        for (Constructor f : con) {
            try {
                T temp = (T) f.newInstance(a, b);
                return temp;
            } catch (Throwable re) {

            }
        }
        return null;
    }

    @Override
    public int challenge5 (String s, int a) {
        int i = s.indexOf("return");
        int j = s.indexOf(";");

        String function = s.substring(i + 6, j);

        function = function.replace("i", String.valueOf(a)).trim();

        if (!function.contains(" ")) {
            function = function.replace("+", " + ");
        }
        return challenge1(function);
    }
}
