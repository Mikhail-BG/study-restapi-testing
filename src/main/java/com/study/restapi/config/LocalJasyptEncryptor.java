package com.study.restapi.config;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

public final class LocalJasyptEncryptor
{
    private LocalJasyptEncryptor()
    {
    }

    public static PooledPBEStringEncryptor stringEncryptor()
    {
        final PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(environmentVariablesConfiguration());
        return encryptor;
    }

    private static EnvironmentStringPBEConfig environmentVariablesConfiguration()
    {
        final EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setPasswordEnvName("APP_ENCRYPTION_PASSWORD");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        return config;
    }
}
