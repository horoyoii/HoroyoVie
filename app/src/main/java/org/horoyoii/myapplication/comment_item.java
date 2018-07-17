package org.horoyoii.myapplication;

public class comment_item {
    String ID;
    String Content;
    int RecCount;
    String Time;
    double Rating;

    public comment_item(String ID, String content, int recCount, String time, double rating) {
        this.ID = ID;
        Content = content;
        RecCount = recCount;
        Time = time;
        Rating = rating;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getRecCount() {
        return RecCount;
    }

    public void setRecCount(int recCount) {
        RecCount = recCount;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    @Override
    public String toString() {
        return "comment_item{" +
                "ID='" + ID + '\'' +
                ", Content='" + Content + '\'' +
                ", RecCount=" + RecCount +
                ", Time='" + Time + '\'' +
                ", Rating=" + Rating +
                '}';
    }
}

