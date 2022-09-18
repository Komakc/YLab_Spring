package com.edu.ulab.app.storage;

import com.edu.ulab.app.entity.BookEntity;
import com.edu.ulab.app.entity.UserEntity;

import java.util.*;

public class Storage {
    static List<UserEntity> userEntityList = new LinkedList<>();

    private static final Map<Long, UserEntity> userEntityMap = new HashMap<>();

    private static final Map<Long, BookEntity> bookEntityMap = new HashMap<>();

    private static final Map<Long, Set<Long>> idUserWithIdBooksMap = new HashMap<>();

    public static void addUser(Long id, UserEntity userEntity) {
        userEntityMap.put(id, userEntity);
        idUserWithIdBooksMap.put(id, new HashSet<>());
    }

    public static UserEntity updateUser(Long id, UserEntity userEntity) {
        System.out.println(id + " " + userEntity.getFullName());
        if (userEntityMap.containsKey(id)) {
            return userEntityMap.put(id, userEntity);
        }
        return null;
    }

    public static UserEntity getUserById(Long id) {
        return userEntityMap.get(id);
    }

    public static void deleteUserById(Long id) {
        userEntityMap.remove(id);
    }

    public static void addBook(Long id, Long userId, BookEntity bookEntity) {
        bookEntityMap.put(id, bookEntity);
        idUserWithIdBooksMap.get(userId).add(id);
    }

    public static BookEntity updateBook(Long id, BookEntity bookEntity) {
        if (bookEntityMap.containsKey(id)) {
            return bookEntityMap.put(id, bookEntity);
        }
        return null;
    }

    public static BookEntity getBookById(Long id) {
        return bookEntityMap.get(id);
    }

    public static void deleteBookById(Long id) {
        bookEntityMap.remove(id);
        for (Set<Long> value : idUserWithIdBooksMap.values()) {
            if (value.contains(id)) {
                value.remove(id);
                break;
            }
        }
    }

    public static List<Long> getBooksIdOfUser(Long userId) {
        return new ArrayList<>(idUserWithIdBooksMap.get(userId));
    }
}
