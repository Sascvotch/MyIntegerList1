public interface IntList {

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    int add(int item) throws MyIntList.MyException;

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    int addIndexItem(int index, int item)throws MyIntList.MyException;

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    int set(int index, int item) throws MyIntList.MyException;

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    int removeItem (int item) throws MyIntList.MyException;

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    int remove(int index) throws MyIntList.MyException;

    // Проверка на существование элемента.
    // Вернуть true/false;
    boolean contains(int item) throws MyIntList.MyException;

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int indexOf(int item) throws MyIntList.MyException;

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int lastIndexOf(int item)throws MyIntList.MyException ;

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    int get(int index) throws MyIntList.MyException;

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    boolean equals(MyIntList[] otherList) throws MyIntList.MyException;

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
    int[] toArray();
}


