
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest {
    private final SortArr sortArr = new SortArr();
    private MyIntList arr = new MyIntList(5);
    private MyIntList tempArrInsertion = new MyIntList(0);
    private MyIntList tempArrSelection = new MyIntList(0);
    private MyIntList tempArrBubble = new MyIntList(0);

    public void speedTest(Runnable r) {
        long start = System.currentTimeMillis();
        try {
            r.run();
        } finally {
            System.out.println("время " + (System.currentTimeMillis() - start));
        }
    }

    @Test
    public void speed() throws MyIntList.MyException {
        arr = arr.generateRandomArray(1000);
        tempArrInsertion = tempArrInsertion.copy(arr);
        tempArrBubble = tempArrBubble.copy(arr);
        tempArrSelection = tempArrSelection.copy(arr);
        MyIntList finalTempArrSelection = tempArrSelection;
        speedTest(new Runnable() {
            public void run() {
                try {
                    sortArr.sortSelection(finalTempArrSelection);

                } catch (MyIntList.MyException e) {
                    e.printStackTrace();
                }

            }
        });
        MyIntList finalTempArrInsertion = tempArrInsertion;
        speedTest(new Runnable() {
            public void run() {
                try {
                    sortArr.sortInsertion(finalTempArrInsertion);
                } catch (MyIntList.MyException e) {
                    e.printStackTrace();
                }

            }
        });
        MyIntList finalTempArrBubble = tempArrBubble;
        speedTest(new Runnable() {
            public void run() {
                try {
                    sortArr.sortBubble(finalTempArrBubble);
                } catch (MyIntList.MyException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Test
    public void containsTest() throws MyIntList.MyException {
        arr.add(0);
        arr.add(4);
        arr.add(2);
        arr.add(1);
        arr.add(1);
        arr.add(5);
        Integer item = 2;
        if (item == null) {
            throw new MyIntList.MyException("Введите значение");
        } else {
            //sortArr.sortInsertion(arr);
            sortArr.quickSort(arr,0,arr.size()-1);
            arr.binarySearch(arr, item);
            System.out.println(arr.toString());
        }
    }

    @Test
    public void addTest() throws MyIntList.MyException {
        arr.add(8);
        arr.add(2);
        arr.add(1);
        arr.add(1);
        arr.add(5);
        arr.add(6);
        arr.addIndexItem(2, 0);
        arr.add(9);
        System.out.println(arr.toString());
        assertEquals(10, arr.size());
    }

}
