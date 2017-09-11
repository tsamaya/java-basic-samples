package net.tsamaya.diacritics;

/**
 * Created by tsamaya on 08/02/16.
 */
public class DiacriticsUtils {

    /**
     * Mirror of the unicode table from 00c0 to 017f without diacritics.
     *
     * Code from: http://stackoverflow.com/a/10831704/91226
     *            http://stackoverflow.com/questions/3322152/
     *
     * useful link for unicode : http://unicode-table.com/
     *
     * updated with ligatures Æ æ Œ œ
     *              ø
     */
    private static final String tab00c0 =
            "AAAAAAÆCEEEEIIII" +
            "DNOOOOO\u00d7OUUUUYP\u00df" +
            "aaaaaaæceeeeiiii" +
            "dnooooo\u00f7ouuuuypy" +
            "AaAaAaCcCcCcCcDd" +
            "DdEeEeEeEeEeGgGg" +
            "GgGgHhHhIiIiIiIi" +
            "IiJjJjKkkLlLlLlL" +
            "lLlNnNnNnnNnOoOo" +
            "OoŒœRrRrRrSsSsSs" +
            "SsTtTtTtUuUuUuUu" +
            "UuUuWwYyYZzZzZzF";

    /**
     * Returns string without diacritics - 7 bit approximation.
     *
     * @param source string to convert
     * @return corresponding string without diacritics
     */
    public static String removeDiacritic(String source) {
        char[] vysl = new char[source.length()];
        char one;
        for (int i = 0; i < source.length(); i++) {
            one = source.charAt(i);
            if (one >= '\u00c0' && one <= '\u017f') {
                one = tab00c0.charAt((int) one - '\u00c0');
            }
            vysl[i] = one;
        }
        return new String(vysl);
    }
}
