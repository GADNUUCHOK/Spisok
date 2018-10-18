package com.example.work_gadnuuk.spisok;

import java.util.UUID;

public class Pole {

    private UUID mId;
    private String mTitle;

    public Pole() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }
}
