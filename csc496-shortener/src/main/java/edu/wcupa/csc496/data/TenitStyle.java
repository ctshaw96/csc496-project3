package com.tenitx.sumnews.tenitx;

import org.immutables.value.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@Value.Style(
        get = {"is*", "get*"},
        init = "with*",
        typeAbstract = {"*IF"},
        typeImmutable = "*",
        strictBuilder = true, // makes the objects immutable
        visibility = Value.Style.ImplementationVisibility.PUBLIC,
        deepImmutablesDetection = true,
        allParameters = true
)

public @interface TenitStyle {}
