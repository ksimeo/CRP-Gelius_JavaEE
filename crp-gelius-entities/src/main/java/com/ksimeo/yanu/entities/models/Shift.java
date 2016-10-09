package com.ksimeo.yanu.entities.models;

/**
 * @author Ksimeo. Created on 19.08.2016 at 19:20 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public enum Shift {
    DAY("Дневная_смена"), NIGHT("Ночная_смена");

    private String name;
    Shift(String name) {
        this.name = name;
    }
}
