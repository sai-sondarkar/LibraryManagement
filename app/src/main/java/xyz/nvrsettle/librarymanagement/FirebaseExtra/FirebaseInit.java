package xyz.nvrsettle.librarymanagement.FirebaseExtra;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by saiso on 28-08-2017.
 */

public class FirebaseInit {
    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }


}
