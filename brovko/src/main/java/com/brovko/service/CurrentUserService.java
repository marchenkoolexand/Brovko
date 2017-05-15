package com.brovko.service;

import com.brovko.domain.CurrentUser;

public interface  CurrentUserService {
    boolean canAccessUser(CurrentUser currentUser, Long userId);
}
