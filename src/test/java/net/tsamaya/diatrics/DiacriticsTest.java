package net.tsamaya.diatrics;

import net.tsamaya.diacritics.DiacriticsUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tsamaya on 08/02/16.
 */
public class DiacriticsTest {

    @Test
    public void funTest() {
        String input = "Tĥïŝ ĩš â fůňķŷ Šťŕĭńġ";
        String actual = DiacriticsUtils.removeDiacritic(input);
        String actual1 = StringUtils.stripAccents(input);
        String expected = "This is a funky String";
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actual1);
    }

    @Test
    public void frenchDiatricts() {
        String input = "àäâéèëêïîöôüû";
        String actual = DiacriticsUtils.removeDiacritic(input);
        String actual1 = StringUtils.stripAccents(input);
        String expected = "aaaeeeeiioouu";
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actual1);
    }
    @Test
    public void spanishDiatricts() {
        String input = "ù";
        String actual = DiacriticsUtils.removeDiacritic(input);
        String actual1 = StringUtils.stripAccents(input);
        String expected = "u";
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actual1);
    }

    @Test
    public void frenchLigatures() {
        String input = "œæÆŒ";
        String actual = DiacriticsUtils.removeDiacritic(input);
        String actual1 = StringUtils.stripAccents(input);
        String expected = "œæÆŒ";
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actual1);
    }

    @Test
    public void frenchSpecials() {
        String input = "ç";
        String actual = DiacriticsUtils.removeDiacritic(input);
        String actual1 = StringUtils.stripAccents(input);
        String expected = "c";
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actual1);
    }

    @Test
    public void norgeSpecials() {
        String input = "ø";
        String actual = DiacriticsUtils.removeDiacritic(input);
        String actual1 = StringUtils.stripAccents(input);
        String expected = "ø";
        // not equal because ø should become o
        Assert.assertNotEquals(expected, actual);
        // this is an error
        Assert.assertEquals(expected, actual1);
    }

    @Test
    public void russe() {
        String input = "й";
        String actual = DiacriticsUtils.removeDiacritic(input);
        String actual1 = StringUtils.stripAccents(input);
        String expected = "й";
        Assert.assertEquals(expected, actual);
        // fail ! they should be equals
        Assert.assertNotEquals(expected, actual1);
    }
}
