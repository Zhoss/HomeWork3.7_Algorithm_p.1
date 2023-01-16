import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringListTest {

    @Test
    void addString() {
        StringList expected = new StringArrayList (new String[]{"1", "2", "3", "4", "5"});

        StringList actual = new StringArrayList(3);
        actual.add("1");
        actual.add("2");
        actual.add("3");
        actual.add("4");
        actual.add("5");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addingIncorrectInputTrowsIllegalArgumentException() {
        StringList actual = new StringArrayList(3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> actual.add(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> actual.add(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> actual.add(" "));
    }

    @Test
    void addStringToPosition() {
        StringList expected = new StringArrayList (new String[]{"1", "2", "3", "4", "5"});

        StringList actual = new StringArrayList (new String[]{"1", "3", "4", "5"});

        actual.add(1, "2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void enterIncorrectIndexTrowsIllegalArgumentException() {
        StringList actual = new StringArrayList(3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> actual.add(5, "new value"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> actual.add(-11, "new value"));
    }

    @Test
    void setNewValue() {
        StringList expected = new StringArrayList (new String[]{"1", "2", "3", "4", "5"});

        StringList actual = new StringArrayList (new String[]{"1", "3", "3", "4", "5"});
        actual.set(1, "2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeString() {
        StringList expected = new StringArrayList (new String[]{"1", "2", "3", "5"});

        StringList actual = new StringArrayList (new String[]{"1", "2", "3", "4", "5"});
        actual.remove("4");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeStringFromPosition() {
        StringList expected = new StringArrayList (new String[]{"1", "2", "3", "5"});

        StringList actual = new StringArrayList (new String[]{"1", "2", "3", "4", "5"});
        actual.remove(3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removingIncorrectInputTrowsIllegalArgumentException() {
        StringList actual = new StringArrayList (new String[]{"1", "2", "3", "4", "5"});

        Assertions.assertThrows(IllegalArgumentException.class, () -> actual.remove("value"));
    }

    @Test
    void containsString() {
        StringList actual = new StringArrayList (new String[]{"1", "2", "3", "4", "5"});

        Assertions.assertTrue(actual.contains("3"));
        Assertions.assertFalse(actual.contains("8"));
    }

    @Test
    void indexOfString() {
        int expected = 0;
        StringList actual = new StringArrayList (new String[]{"4", "2", "3", "4", "5"});

        Assertions.assertEquals(expected, actual.indexOf("4"));
        Assertions.assertEquals(-1, actual.indexOf("9"));
    }

    @Test
    void lastIndexOfString() {
        int expected = 3;
        StringList actual = new StringArrayList (new String[]{"4", "2", "3", "4", "5"});

        Assertions.assertEquals(expected, actual.lastIndexOf("4"));
        Assertions.assertEquals(-1, actual.indexOf("9"));
    }

    @Test
    void getString() {
        String expected = "5";
        StringList actual = new StringArrayList (new String[]{"1", "2", "3", "4", "5"});

        Assertions.assertEquals(expected, actual.get(4));
    }

    @Test
    void ListEqualsList() {
        StringList expected = new StringArrayList (new String[]{"1", "2", "3", "4", "5"});
        StringList anotherExpected = new StringArrayList (new String[]{"1", "2", "3", "5"});

        StringList actual = new StringArrayList (new String[]{"1", "2", "3", "4", "5"});

        Assertions.assertEquals(expected, actual);
        Assertions.assertNotEquals(anotherExpected, actual);
    }

    @Test
    void comparisonListWithNullTrowsIllegalArgumentException() {
        StringList actual = new StringArrayList (new String[]{"1", "2", "3", "4", "5"});
        StringList nullList = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> actual.equals(nullList));
    }

    @Test
    void sizeOfList() {
        int expected = 2;
        StringList actual = new StringArrayList (new String[]{"1", "4", null});

        Assertions.assertEquals(expected, actual.size());
    }

    @Test
    void ListIsEmpty() {
        StringList actual = new StringArrayList (new String[]{"1", "4", "5"});
        StringList anotherActual = new StringArrayList (new String[]{null, null, null});

        Assertions.assertFalse(actual.isEmpty());
        Assertions.assertTrue(anotherActual.isEmpty());
    }

    @Test
    void clearList() {
        StringList expected = new StringArrayList (new String[]{null, null, null});
        StringList actual = new StringArrayList (new String[]{"1", "4", "5"});
        actual.clear();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void ListToArray() {
        String[] expected = {"1", "2", "3", "4", "5"};
        StringList actual = new StringArrayList(5);
        actual.add("1");
        actual.add("2");
        actual.add("3");
        actual.add("4");
        actual.add("5");

        Assertions.assertArrayEquals(expected, actual.toArray());
    }
}