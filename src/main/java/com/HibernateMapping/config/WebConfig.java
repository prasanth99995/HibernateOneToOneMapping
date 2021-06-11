package com.HibernateMapping.config;/*
package com.springboot.Mapping.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.awt.image.BufferedImage;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(createImageHttpMessageConverter());
        converters.add(new ResourceHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(new ByteArrayHttpMessageConverter());
        converters.add(new StringHttpMessageConverter(StringHttpMessageConverter.DEFAULT_CHARSET));
        converters.add(new FormHttpMessageConverter());
        converters.add(new Jaxb2RootElementHttpMessageConverter());
        converters.add(new SourceHttpMessageConverter<>());
        //converters.add(new AtomFeedHttpMessageConverter());
        //converters.add(new RssChannelHttpMessageConverter());
    }

    private HttpMessageConverter<BufferedImage> createImageHttpMessageConverter(){
        return new BufferedImageHttpMessageConverter();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }
}
*/
