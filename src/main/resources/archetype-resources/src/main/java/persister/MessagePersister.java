package com.example.persister;

import com.google.inject.persist.Transactional;

public interface MessagePersister {

    @Transactional
    public abstract Long save(String message);

    @Transactional
    public abstract void update(Long id, String newMessage);

    public abstract Message getById(Long id);

    @Transactional
    public abstract void deleteById(Long id);

}