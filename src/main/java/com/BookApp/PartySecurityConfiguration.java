// Copyright (c) 2018 Travelex Ltd

package com.BookApp;

import io.crnk.security.ResourcePermission;
import io.crnk.security.SecurityConfig;
import io.crnk.security.SecurityModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PartySecurityConfiguration {

    /**
     * Crnk security authorization config.
     *
     * @return the module.
     */
    @Bean
    public SecurityModule securityModule() {
        SecurityConfig.Builder builder = SecurityConfig.builder();
        builder.permitAll(ResourcePermission.ALL);
        return SecurityModule.newServerModule(builder.build());
    }
}
