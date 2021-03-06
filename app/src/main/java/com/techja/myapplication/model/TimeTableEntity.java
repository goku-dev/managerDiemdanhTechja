package com.techja.myapplication.model;

import androidx.annotation.Nullable;

public class TimeTableEntity {
    private String day, time, detail, teacher, note;

    public TimeTableEntity(String day, String time, String detail, String teacher, String note) {
        this.day = day;
        this.time = time;
        this.detail = detail;
        this.teacher = teacher;
        this.note = note;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TimeTableEntity) {
            TimeTableEntity item = (TimeTableEntity) obj;
            return item.day.equals(day) && item.detail.equals(detail)
                    && item.note.equals(note) && item.teacher.equals(teacher)
                    && item.time.equals(time) && item.note.equals(note);
        }
        return super.equals(obj);
    }

}
