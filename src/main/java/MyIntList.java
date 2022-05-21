import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MyIntList implements IntList {

    private int[] myArrayList;
    private int countElements = 0;
    private int capacity = 5;
    private final SortArr sortArr = new SortArr();


    public MyIntList(int countElements) {
        myArrayList = new int[capacity];
    }

    public MyIntList generateRandomArray(int countElements) throws MyException {
        java.util.Random random = new java.util.Random();
        MyIntList arr = new MyIntList(0);
        for (int i = 0; i < countElements; i++) {
            arr.addIndexItem(i, random.nextInt(100_000) + 100_000);
        }
        return arr;
    }

    public MyIntList copy(MyIntList myIntList) throws MyException {
        MyIntList tempArr = new MyIntList(0);
        for (int i = 0; i < myIntList.countElements; i++) {
            tempArr.addIndexItem(i, myIntList.get(i));
        }
        return tempArr;
    }

    public boolean binarySearch(MyIntList myIntList, int element) throws MyException {
        int min = 0;
        int max = myIntList.countElements - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (element == myIntList.get(mid)) {
                System.out.println("найден");
                return true;
            }
            if (element < myIntList.get(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println("не найден");
        return false;
    }

    @Override
    public boolean contains(int item) throws MyException {
        MyIntList myIntList = new MyIntList(0);
       // sortArr.sortInsertion(myIntList);
        sortArr.quickSort(myIntList,0,myIntList.size()-1);
        return myIntList.binarySearch(myIntList, item);
    }

    @Override
    public int add(int item) throws MyException {
        int index = countElements;
        if (index == capacity) {
            grow();
        }
        addIndexItem(index, item);
        return item;
    }

    @Override
    public String toString() {
        return "MyIntList{" +
                "myArrayList=" + Arrays.toString(myArrayList) +
                ", countElements=" + countElements +
                ", capacity=" + capacity +
                ", lenght=" + myArrayList.length +
                '}';
    }

    private int[] grow() {
        capacity = (int) (myArrayList.length * 1.5);
        int[] tempArray = Arrays.copyOf(myArrayList, myArrayList.length);
        myArrayList = new int[capacity];
        myArrayList = Arrays.copyOf(tempArray, capacity);
        return myArrayList;
    }

    @Override
    public int addIndexItem(int index, int item) throws MyException {
        if (index > countElements) {
            throw new MyException("Индекс не должен превышать количество элементов больше,чем на 1");
        } else {
            if (countElements + 1 == capacity) {
                grow();
            }
            int[] tempArray = Arrays.copyOf(myArrayList, index);
            int[] tempArrayAfterIndex = Arrays.copyOfRange(myArrayList, index, myArrayList.length);
            myArrayList = new int[capacity];
            myArrayList = Arrays.copyOf(tempArray, capacity);
            myArrayList[index] = item;
            System.arraycopy(tempArrayAfterIndex, 0, myArrayList, index + 1, countElements - index);
            countElements++;
            return item;
        }
    }

    @Override
    public int set(int index, int item) throws MyException {
        if (index > countElements) {
            throw new MyException("Индекс превышает массив");
        } else {
            myArrayList[index] = item;
            return item;
        }
    }

    @Override
    public int removeItem(int item) throws MyException {
        int index = indexOf(item);
        if (index == -1) {
            throw new MyException("Такого элемента нет");
        }
        remove(index);
        return item;
    }

    @Override
    public int remove(int index) throws MyException {
        if (index < 0 || index > capacity) {
            throw new MyException("Введите корректное значение в диапозоне от 0 до " + myArrayList.length);
        } else {
            int[] tempArray = Arrays.copyOf(myArrayList, countElements);
            myArrayList = new int[countElements - 1];
            System.arraycopy(tempArray, 0, myArrayList, 0, index);
            System.arraycopy(tempArray, index + 1, myArrayList, index, tempArray.length - index - 1);
            countElements--;
            return tempArray[index];
        }
    }

    @Override
    public int indexOf(int item) throws MyException {
        int index = -1;
        for (int i = 0; i < countElements && index == -1; i++) {
            if (myArrayList[i] == item) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Элемент " + item + "  не найден в массиве " + Arrays.toString(myArrayList));
        } else {
            System.out.println("Первое вхождение элемента " + item + " на позиции " + index + " в массиве " + Arrays.toString(myArrayList));
        }
        return index;
    }

    @Override
    public int lastIndexOf(int item) throws MyException {
        int index = -1;
        for (int i = countElements - 1; i >= 0 && index == -1; i--) {
            if (myArrayList[i] == item) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Элемент " + item + "  не найден в массиве " + Arrays.toString(myArrayList));
        } else {
            System.out.println("Последнее вхождение элемента " + item + " на позиции " + index + " в массиве " + Arrays.toString(myArrayList));
        }
        return index;
    }

    @Override
    public int get(int index) throws MyException {
        if (index < 0 || index > countElements) {
            throw new MyException("Введите корректное значение в диапозоне от 0 до " + myArrayList.length);
        } else {
            return myArrayList[index];
        }
    }

    @Override
    public boolean equals(MyIntList[] otherList) throws MyException {
        if (otherList == null) {
            throw new MyException("Введите значение");
        } else {
            boolean equal = true;
            for (int i = 0; i < myArrayList.length && equal == true; i++) {
                if (!Objects.equals(otherList[i], myArrayList[i])) {
                    equal = false;
                }
            }
            System.out.println("equal" + equal);
            return equal;
        }
    }

    @Override
    public int size() {
        //System.out.println("Размер маасива " + Arrays.toString(myArrayList) + " -- " + countElements + " элементов");
        return myArrayList.length;
    }

    @Override
    public boolean isEmpty() {
        if (countElements == 0) {
            System.out.println("Массив" + Arrays.toString(myArrayList) + "Пуст");
            return true;
        } else {
            System.out.println("Массив" + Arrays.toString(myArrayList) + "Полон");
            return false;
        }
    }

    @Override
    public void clear() {
        myArrayList = new int[0];
        countElements = 0;
    }

    @Override
    public int[] toArray() {
        List<Integer> listFromInt = Arrays.asList(0, 1, 2, 3, 4);
        int[] arrayFromList = new int[listFromInt.size()];
        for (int i = 0; i < listFromInt.size(); i++) {
            arrayFromList[i] = listFromInt.get(i);
        }
        return arrayFromList;
    }

    public int[] toArray(List<Integer> listFromInt) {
        int[] arrayFromList = new int[listFromInt.size()];
        for (int i = 0; i < listFromInt.size(); i++) {
            arrayFromList[i] = listFromInt.get(i);
        }
        return arrayFromList;
    }

    static class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }
}

