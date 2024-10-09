package com.rookie.bigdata.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @Class CustomerApplicationRunner
 * @Description
 * @Author rookie
 * @Date 2024/10/9 17:55
 * @Version 1.0
 */
@Component
@Slf4j
public class CustomerApplicationRunner implements ApplicationRunner {

    @Autowired
    private ConfigurableEnvironment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        MutablePropertySources propertySources = environment.getPropertySources();

        //获取所有配置信息
        Map<String, String> props = StreamSupport.stream(propertySources.spliterator(), false)
                .filter(ps -> ps instanceof EnumerablePropertySource<?>)
                .map(ps -> ((EnumerablePropertySource) ps).getPropertyNames())
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toMap(Function.identity(), environment::getProperty));
// key 和 value 之间的最小间隙
        int interval = 20;
        int max = props.keySet().stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("")
                .length();

        // 打印
        props.keySet().stream()
                .sorted()
                .forEach(k -> {
                    int i = max - k.length() + interval;
                    String join = String.join("", Collections.nCopies(i, " "));
                    log.info("配置参数: {}", String.format("%s%s%s", k, join, props.get(k)));
                });

    }
}
