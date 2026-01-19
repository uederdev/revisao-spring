package br.com.ueder.revisaospring.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class Util {

    public static URI getUri(Object obj, String path) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(path)
                .buildAndExpand(obj)
                .toUri();
    }

}
