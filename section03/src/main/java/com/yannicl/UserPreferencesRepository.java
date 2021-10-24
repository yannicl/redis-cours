package com.yannicl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserPreferencesRepository extends CrudRepository<UserPreferences, String> {

        UserPreferences findByAccountId(String accountId);
}
