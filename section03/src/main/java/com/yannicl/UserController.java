package com.yannicl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserPreferencesRepository userPreferencesRepository;

    @GetMapping("api/user")
    public UserPreferences getUser(@RequestParam(value = "userId", required = false) String userId, @RequestParam(value = "accountId", required = false) String accountId) {
        if (userId != null) {
            return userPreferencesRepository.findById(userId).orElse(null);
        }
        if (accountId != null) {
            return userPreferencesRepository.findByAccountId(accountId);
        } else {
            throw new IllegalArgumentException("userId || accountId");
        }
    }

    @PostMapping("api/user")
    public UserPreferences createuser(@RequestParam(value = "userId") String userId) {
        UserPreferences userPreferences = new UserPreferences();
        userPreferences.setUserId(userId);
        userPreferences.setAccountId("account-" + userId);
        userPreferences.setConsentCookies("ALL");
        userPreferences.setLanguage("fr");
        userPreferencesRepository.save(userPreferences);
        return userPreferences;
    }


}
