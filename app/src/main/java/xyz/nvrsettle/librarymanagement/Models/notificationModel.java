package xyz.nvrsettle.librarymanagement.Models;

/**
 * Created by sai on 17/2/18.
 */

public class notificationModel {

    String uid;
    String title;
    String message;


    public notificationModel() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
