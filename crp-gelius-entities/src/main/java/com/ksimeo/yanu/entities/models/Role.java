package com.ksimeo.yanu.entities.models;

/**
 * @author Ksimeo. Created on 17.09.2016 at 19:49 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public enum Role {
    ADMIN(0,"Администратор"), MANAGER(1, "Менеджер"), PLANNER(2, "Планировщик"), TAIWANESE(3, "Рабочий центр: Тайванец"),
    BOBST(4, "Рабочий центр: Бобст"), PACKAGING(5, "Рабочий центр: Упаковщик"), WHAREHOUSE(6, "Кладовщик");

    final int id;
    final String name;

    Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
