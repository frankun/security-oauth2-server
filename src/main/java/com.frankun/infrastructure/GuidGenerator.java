package com.frankun.infrastructure;

import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;

import java.util.UUID;

/**
 * 2016/10/13
 *
 * 随机数生成工具
 *
 * @author frankun
 */
public abstract class GuidGenerator {
    private static RandomValueStringGenerator defaultClientSecretGenerator = new RandomValueStringGenerator(32);

    /**
     * private constructor
     */
    private GuidGenerator(){
    }

    public static String generate(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String generateClientSecret(){
        return defaultClientSecretGenerator.generate();
    }
}
