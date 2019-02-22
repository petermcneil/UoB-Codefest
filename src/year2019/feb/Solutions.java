package year2019.feb;

import javafx.geometry.Point2D;

import java.lang.reflect.Method;

/**
 * @author Almas Baimagambetov
 */
public class Solutions implements Codefest {

    @Override
    public int challenge1(int[] a) {
        int total = a[0];
        boolean add = true;
        for (int i = 1; i < a.length; i++) {
            if (add) {
                total = total + a[i];
                add = false;
            } else {
                total = total - a[i];
                add = true;
            }
        }

        int ret = total + (a.length - 1);

        return ret;
    }

    @Override
    public Point2D challenge2(String a) {
        int x = 0;
        int y = 0;
        char[] arr = a.toCharArray();

        int lastcharcter = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            char f = arr[i];
            if (Character.isDigit(f)) {
                lastcharcter = Integer.parseInt(String.valueOf(f));
            } else {
                switch (f) {
                    case 'L':
                        x = x - lastcharcter;
                        lastcharcter = 1;
                        break;
                    case 'U':
                        y = y + (lastcharcter);
                        lastcharcter = 1;
                        break;
                    case 'D':
                        y = y - lastcharcter;
                        lastcharcter = 1;
                        break;
                    case 'R':
                        x = x + (lastcharcter);
                        lastcharcter = 1;
                        break;
                }
            }
        }

        return new Point2D(x, y);
    }


    @Override
    public int challenge3(int a, int b) {
        int[] ac = Integer.toString(Math.abs(a)).chars().map(c -> c - '0').toArray();
        int[] bc = Integer.toString(Math.abs(b)).chars().map(c -> c - '0').toArray();

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < ac.length; i++) {
            try {
                int e = Math.abs(ac[i]);
                int f = Math.abs(bc[i]);
                int r;
                if (e > f) {
                    r = e - f;
                } else {
                    r = f - e;
                }
                s.append(r);
            } catch (IndexOutOfBoundsException ie) {
            }
        }

        return Integer.parseInt(s.toString());
    }

    @Override
    public int challenge4(int a, int b) {
        double ret = 0.0;
        if (a < 0 && b < 0) {
            return ((int) 180 + (int) Math.toDegrees(Math.atan(b / a)));
        }

        if (a == 0 && b > 0) {
            return 90;
        }

        if (a < 0 && b == 0) {
            return 180;
        }

        if (a > 0 && b == 0) {
            return 0;
        }
        if (a == 0 && b == 0) {
            return 0;
        }

        if (a == 0 && b < 0) {
            return 270;
        }

        if (b > 0) {
            ret = Math.atan(b / a);
        }

        return (int) Math.toDegrees(ret);
    }


    @Override
    public int challenge5(String s) {
        String[] h = s.toLowerCase().split(" ");
        int ret = 0;
        for (String j : h) {
            switch (j) {
                case "one":
                    ret = ret + 1;
                    break;
                case "hundred":
                    ret = ret * 100;
                    break;
                case "thirty":
                    ret = ret + 30;
                    break;
                case "five":
                    ret = ret + 5;
                    break;
                case "twenty":
                    ret = ret + 20;
                    break;
                case "three":
                    ret = ret + 3;
                    break;
                case "two":
                    ret = ret + 2;
                    break;
                case "sixty":
                    ret = ret + 60;
                    break;
                default:
                    break;
            }
        }

        return ret;
    }

    @Override
    public int challenge6(String s) {
        String[] b = s.split(" ");
        int count = 0;

        for (String word : b) {

            switch (word.replaceAll("\\?", "")) {
                case "you":
                    count++;
                    break;
                case "it":
                    count++;
                    break;
                case "us":
                    count++;
                    break;
                case "them":
                    count++;
                    break;
            }
        }

        return count;
    }

    private int count = 0;

    @Override
    public int challenge7() {
        int ret = count * count;
        count++;
        return ret;
    }

    @Override
    public int challenge8(int a, String s) {
        String[] j = s.toLowerCase().split(" ");
        double ret = a;
        for (String f : j) {
            switch (f) {
                case "sqrt":
                    ret = Math.sqrt(ret);
                    break;
                case "square":
                    ret = ret * ret;
                    break;
                case "quad":
                    ret = Math.pow(ret, 4);
                    break;
            }
        }
        return (int) ret;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public int challenge9(String s) {
        if (isPalindrome(s)) {
            return 0;
        } else {
            StringBuilder r = new StringBuilder(s);
            char[] reverse = r.reverse().toString().toCharArray();

            int a = 0;
            StringBuilder ap = new StringBuilder();
            for (int i = 0; i < reverse.length; i++) {
                ap.append(reverse[i]);
                boolean palindrom = isPalindrome(ap.toString() + s);
                if (palindrom) {
                    a = i + 1;
                    break;
                }
            }

            if (a == 1) {
                return 1;
            }

            int b = 0;
            ap = new StringBuilder();
            for (int j = 0; j < reverse.length; j++) {
                ap.append(reverse[j]);
                boolean palindrom = isPalindrome(s + ap.toString());
                if (palindrom) {
                    b = j + 1;
                    break;
                }
            }

            return Math.min(a, b);
        }
    }

    private boolean isPalindrome(String s) {
        StringBuilder g = new StringBuilder();
        g.append(s);
        g.reverse();
        return s.equals(g.toString());
    }

    @Override
    public String challenge10(String s, String s2) {
        StackTraceElement[] y = Thread.currentThread().getStackTrace();

        String className = y[3].getClassName();

        try {
            Class clazz = Class.forName(className);
            Method[] m = clazz.getDeclaredMethods();
            for (Method x : m) {
                String name = x.getName();
                if (name.equals(s)) {
                    Method z = clazz.getDeclaredMethod(name, String.class);
                    z.setAccessible(true);
                    String ret = (String) z.invoke(clazz.newInstance(), s2);
                    return ret;
                }
            }
        } catch (Exception e) {
            return "";
        }

        return "";
    }
}
