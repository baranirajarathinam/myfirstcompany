package com.startup.mvp.repo;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import com.startup.mvp.entity.User;

public interface UserRepository
        extends FirestoreReactiveRepository<User> {
}
