package org.sh.shopserver.service;

import org.sh.shopserver.model.User;

public interface AuthenticationService {
    public User signInAndReturnJWT(User signInRequest);
}
