package com.ds.baza.dsbaza.service;

import java.util.HashSet;
import java.util.Set;

public interface CrudService <T, ID> {

    T save (T object);

    Set<T> findAll();



}
