package cn.acutetr1angle.m0ss.features.event.annotations;

import java.lang.annotation.*;

/**
 * Annotation used to mark a method as an event handling method.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventTarget {
}