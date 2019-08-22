package com.example.firebasesetup;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

class FirestoreHandler implements FireStoreInterface{
    private FirebaseFirestore db;

    FirestoreHandler(){
        db = FirebaseFirestore.getInstance();
    }

    FirebaseFirestore getObject(){ return FirebaseFirestore.getInstance(); }

    @Override
    public void insertData(DataModel data){
        Map<String,Object> user = new HashMap<>();
        user.put("name", data.getName());
        user.put("father name", data.getFatherName());
        user.put("email", data.getEmail());
        user.put("institute", data.getInstitute());

        db.collection("users")
            .add(user)
            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Log.d("Database","Document added with ID: "+documentReference.getId());
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("Database","Error adding document.",e);
                }
            });
    }

    @Override
    public void readData() {}
}
