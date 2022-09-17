package com.edu.ulab.app.storage;

import com.edu.ulab.app.dto.BookDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    //todo создать хранилище в котором будут содержаться данные
    private static Map<Integer, List<BookDto>> mapStorage = new HashMap<>();
    // сделать абстракции через которые можно будет производить операции с хранилищем
    // продумать логику поиска и сохранения
    // продумать возможные ошибки
    // учесть, что при сохранеии юзера или книги, должен генерироваться идентификатор
    // продумать что у узера может быть много книг и нужно создать эту связь
    // так же учесть, что методы хранилища принимают другой тип данных - учесть это в абстракции
}
