package ru.skypro;

public class Main {

    public static void main(String[] args) throws MyIntegerList.MyException {
        MyIntegerList myIntegerList = new MyIntegerList(0);
        myIntegerList = myIntegerList.generateRandomArray(100000);

        MyIntegerList arrSortInsertion = new MyIntegerList(0);
        arrSortInsertion = arrSortInsertion.copy(myIntegerList);

        long start3 = System.currentTimeMillis();
        arrSortInsertion.sortInsertion();
        System.out.println("время сорт инсекшен" + (System.currentTimeMillis() - start3));
        System.out.println(myIntegerList.BinarySearch(myIntegerList, 143345));
    }
}
