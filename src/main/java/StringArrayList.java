import java.util.Arrays;

public class StringArrayList implements StringList {

    private String[] items;

    public StringArrayList(int size) {
        if (size > 0) {
            this.items = new String[size];
        } else if (size == 0) {
            this.items = new String[0];
        } else {
            throw new IllegalArgumentException("Требуется указать размер коллекции больше и равным 0");
        }
    }

    public StringArrayList(String[] array) {
        if (array != null) {
            this.items = array;
        } else {
            throw new IllegalArgumentException("Требуется указать массив для передачи в коллекцию");
        }
    }

    private void checkInputIsNotNull(String item) {
        if (item == null || item.isEmpty() || item.isBlank()) {
            throw new IllegalArgumentException("Требуется ввести корректное значение");
        }
    }

    private void checkCorrectIndex(int index) {
        if (index > this.items.length - 1 || index < 0) {
            throw new IllegalArgumentException("Значение index за пределами размера коллекции");
        }
    }

    private void checkAndIncreaseListSize() {
        if (this.items[this.items.length - 1] != null) {
            this.items = Arrays.copyOf(this.items, this.items.length + 1);
        }
    }

    public String add(String item) {
        checkInputIsNotNull(item);
        checkAndIncreaseListSize();
        if (this.items[0] == null) {
            this.items[0] = item;
        } else {
            for (int i = 0; i < this.items.length; i++) {
                if (this.items[i] == null) {
                    this.items[i] = item;
                    break;
                }
            }
        }
        return item;
    }

    public String add(int index, String item) {
        checkInputIsNotNull(item);
        checkCorrectIndex(index);
        checkAndIncreaseListSize();
        for (int i = 0; i < this.items.length; i++) {
            if (i > index) {
                int j = i - 1;
                this.items[this.items.length - j] = this.items[this.items.length - i];
            }
        }
        this.items[index] = item;
        return item;
    }

    public String set(int index, String item) {
        checkInputIsNotNull(item);
        checkCorrectIndex(index);
        this.items[index] = item;
        return item;
    }

    public String remove(String item) {
        checkInputIsNotNull(item);
        if (!contains(item)) {
            throw new IllegalArgumentException("Элемент item = " + item + " не найден в коллекции");
        } else {
            for (int i = 0; i < this.items.length; i++) {
                if (this.items[i].equals(item)) {
                    this.items[i] = null;
                    for (int j = i; j < this.items.length - 1; j++) {
                        this.items[j] = this.items[j + 1];
                    }
                    this.items = Arrays.copyOf(this.items, this.items.length - 1);
                    break;
                }
            }
        }
        return item;
    }

    public String remove(int index) {
        checkCorrectIndex(index);
        remove(this.items[index]);
        return items[index];
    }

    public boolean contains(String item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(String item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String item) {
        for (int i = this.items.length - 1; i >= 0; i--) {
            if (this.items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public String get(int index) {
        checkCorrectIndex(index);
        for (int i = 0; i < this.items.length; i++) {
            if (i == index) {
                return this.items[i];
            }
        }
        return null;
    }

    public boolean equals(StringList otherList) {
        if (this == otherList) return true;
        if (otherList == null) {
            throw new IllegalArgumentException("Требуется ввести корректное значение");
        }
        StringArrayList that = (StringArrayList) otherList;
        return Arrays.equals(items, that.items);
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                count++;
            }
        }
        return count;
    }

    public boolean isEmpty() {
        for (int i = 0; i < this.items.length; i++) {
            return this.items[i] == null;
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < this.items.length; i++) {
            this.items[i] = null;
        }
    }

    public String[] toArray() {
        String[] array = new String[this.items.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = this.items[i];
        }
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringArrayList that = (StringArrayList) o;
        return Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(items);
    }
}