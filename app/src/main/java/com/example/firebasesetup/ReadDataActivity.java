package com.example.firebasesetup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

@SuppressWarnings("ConstantConditions")
public class ReadDataActivity extends AppCompatActivity implements FireStoreInterface{

    private ArrayList<String> dataList = new ArrayList<>();
    private ListView listView;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);

        listView = findViewById(R.id.list);
        FirestoreHandler fh = new FirestoreHandler();
        db = fh.getObject();

        readData();
    }

    @Override
    public void insertData(DataModel data) { }

    @Override
    public void readData(){
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                String name = document.getData().get("name").toString();
                                String fatherName = document.getData().get("father name").toString();
                                String email = document.getData().get("email").toString();
                                String institute = document.getData().get("institute").toString();
                                DataModel d = new DataModel(name, fatherName, email, institute);

                                dataList.add(d.toString());
                            }
                            listView.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, dataList));
                        }
                    }
                });
    }
}
