package com.socks.api;

import org.aeonbits.owner.Config;

/**
 * @author NardinVN
 *
 * Класс для работы с конфигурационным файлом
 */
@Config.Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

    @Key("baseUrl")
    String baseUrl();

    @DefaultValue("ru")
    String locale();

    boolean logging();

}
