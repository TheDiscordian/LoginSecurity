package com.lenis0012.bukkit.loginsecurity.session;

import com.lenis0012.bukkit.loginsecurity.LoginSecurity;
import com.lenis0012.bukkit.loginsecurity.LoginSecurityConfig;
import com.lenis0012.bukkit.loginsecurity.modules.language.LanguageKeys;
import org.jetbrains.annotations.Nullable;

import static com.lenis0012.bukkit.loginsecurity.modules.language.LanguageKeys.*;

public enum AuthMode {
    /**
     * When the player is logged in.
     */
    AUTHENTICATED,
    /**
     * When the player registered but not logged in.
     */
    UNAUTHENTICATED,
    /**
     * When the player is not registered and not logged in.
     */
    UNREGISTERED;

    @Nullable
    public LanguageKeys getAuthMessage() {
        switch (this) {
            case UNAUTHENTICATED:
                return MESSAGE_LOGIN;
            case UNREGISTERED:
                LoginSecurityConfig config = LoginSecurity.getConfiguration();
                if (config.isRegistrationEnabled()) {
                    return config.isRegisterConfirmPassword()
                        ? MESSAGE_REGISTER2
                        : MESSAGE_REGISTER;
                } else {
                    return MESSAGE_REGISTRATION_DISABLED;
                }
            default:
                return null;
        }
    }
}
