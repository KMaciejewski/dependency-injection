package com.km.dependencyinjection.config;

import com.km.dependencyinjection.examplebeans.FakeDataSource;
import com.km.dependencyinjection.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Since Spring version 3.1
 *
 * '@PropertySource({"classpath:datasource.properties"', "classpath:jms.properties"})
 *
 * Since Spring version 4.0
 */
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
@Configuration
public class PropertyConfig {

    @Value("${com.km.username}")
    private String username;

    @Value("${com.km.password}")
    private String password;

    @Value("${com.km.dbUrl}")
    private String dbUrl;

    @Value("${com.jms.username}")
    private String jmsUsername;

    @Value("${com.jms.password}")
    private String jmsPassword;

    @Value("${com.jms.dbUrl}")
    private String jmsDbUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setDbUrl(dbUrl);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUsername(jmsUsername);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setDbUrl(jmsDbUrl);
        return fakeJmsBroker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
