package com.example.notes;

import java.io.Serializable;

public class SimpleNote implements Serializable {
    private final String title;
    private final String desc;
    private final String data;

    public SimpleNote(String title, String desc, String data) {
        this.title = title;
        this.desc = desc;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return data;
    }

        @Override
        public String toString () {
            return title + " " + desc + " " + data;
        }
    }

