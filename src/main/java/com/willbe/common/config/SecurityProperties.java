package com.willbe.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@ConfigurationProperties(prefix = "willbe.security")
public class SecurityProperties {

    private static final List<String> DEFAULT_PERMIT_ALL = List.of(
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/v3/api-docs",
            "/swagger-resources/**",
            "/webjars/**",
            "/api/**",
            "/actuator/**"
    );

    private List<String> additionalPermitAll = new ArrayList<>();
    private boolean stateless = true;
    private boolean enableJwtFilter = true;

    public List<String> getPermitAll() {
        Set<String> permitAll = new LinkedHashSet<>(DEFAULT_PERMIT_ALL);
        permitAll.addAll(additionalPermitAll);
        return new ArrayList<>(permitAll);
    }

    public List<String> getAdditionalPermitAll() {
        return additionalPermitAll;
    }

    public void setAdditionalPermitAll(List<String> additionalPermitAll) {
        this.additionalPermitAll = additionalPermitAll;
    }

    public boolean isStateless() {
        return stateless;
    }

    public void setStateless(boolean stateless) {
        this.stateless = stateless;
    }

    public boolean isEnableJwtFilter() {
        return enableJwtFilter;
    }

    public void setEnableJwtFilter(boolean enableJwtFilter) {
        this.enableJwtFilter = enableJwtFilter;
    }
}

