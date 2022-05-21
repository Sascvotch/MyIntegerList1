

public class SortArr {
    public void quickSort(MyIntList arr, int begin, int end) throws MyIntList.MyException {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(MyIntList arr, int begin, int end) throws MyIntList.MyException {
        int pivot = arr.get(end);
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr.get(j) <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }
    public void sortInsertion(MyIntList arr) throws MyIntList.MyException {
        for (int i = 1; i < arr.size(); i++) {
            Integer temp = arr.get(i);
            int j = i;
            while (j > 0 && arr.get(j - 1) >= temp) {
                arr.set(j, arr.get(j - 1));
                j--;
            }
            arr.set(j, temp);
        }
    }

    public void sortSelection(MyIntList arr) throws MyIntList.MyException {
        for (int i = 0; i < arr.size() - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j) < arr.get(minElementIndex)) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public void sortBubble(MyIntList arr) throws MyIntList.MyException {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    private static void swapElements(MyIntList arr, int indexA, int indexB) throws MyIntList.MyException {
        Integer tmp = arr.get(indexA);
        arr.set(indexA, arr.get(indexB));
        arr.set(indexB, tmp);
    }
}
