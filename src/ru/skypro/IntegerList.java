package ru.skypro;

public interface IntegerList {

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    Integer add(Integer item) throws MyIntegerList.MyException;

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    Integer add(int index, Integer item) throws MyIntegerList.MyException;

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    Integer set(int index, Integer item) throws MyIntegerList.MyException;

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    Integer remove(Integer item) throws MyIntegerList.MyException;

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    Integer remove(int index) throws MyIntegerList.MyException;

    // Проверка на существование элемента.
    // Вернуть true/false;
    boolean contains(Integer item) throws MyIntegerList.MyException;

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int indexOf(Integer item) throws MyIntegerList.MyException;

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int lastIndexOf(Integer item) throws MyIntegerList.MyException;

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    Integer get(int index) throws MyIntegerList.MyException;

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    boolean equals(MyIntegerList[] otherList) throws MyIntegerList.MyException;

    // Вернуть фактическое количество элементов.
    int size();

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    boolean isEmpty();

    // Удалить все элементы из списка.
    void clear();

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    Integer[] toArray();
}


