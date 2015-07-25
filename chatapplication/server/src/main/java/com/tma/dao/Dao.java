package com.tma.dao;

/**
 * Created by dhnhan on 7/2/15.
 */
public interface Dao {
    <T> void save(T t);
    <T> void update(T t);
    <T> void delete(T t);
    <T> T getObjectById(long id);
}
