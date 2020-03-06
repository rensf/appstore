package com.sys.appstore.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface CheckToken {
    boolean mustToke() default true;
}
