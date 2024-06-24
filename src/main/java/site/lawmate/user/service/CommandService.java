package site.lawmate.user.service;

import site.lawmate.user.component.Messenger;

public interface CommandService<T> {
    Messenger save(T t);

    Messenger deleteById(Long id);

    Messenger modify(T t);
}
