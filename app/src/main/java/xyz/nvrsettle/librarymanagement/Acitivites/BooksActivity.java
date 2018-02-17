package xyz.nvrsettle.librarymanagement.Acitivites;

import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.List;

import xyz.nvrsettle.librarymanagement.Adapter.BooksRecyclerAdapter;
import xyz.nvrsettle.librarymanagement.FirebaseExtra.FirebaseInfo;
import xyz.nvrsettle.librarymanagement.FirebaseExtra.FirebaseInit;
import xyz.nvrsettle.librarymanagement.Models.BookModel;
import xyz.nvrsettle.librarymanagement.R;

public class BooksActivity extends AppCompatActivity {

    String category;
    private ListView booksListView;
    List<BookModel> bookModels =  new ArrayList<>();
    BooksRecyclerAdapter adapter;
    // Search EditText
    EditText inputSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        Bundle bundle = getIntent().getExtras();
        category = bundle.getString("category");
        InitElements();

        adapter = new BooksRecyclerAdapter(this, bookModels);
        booksListView.setAdapter(adapter);
        booksListView.setTextFilterEnabled(true);

        getFirebaseDatabase();
    }

    public void InitElements() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");

        TextView tx = (TextView) toolbar.findViewById(R.id.tx);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Rubik-Regular.ttf");
        tx.setTypeface(custom_font);
        booksListView = (ListView) findViewById(R.id.listViewAndroid);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                adapter.getFilter().filter(cs.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
    }



    public void getFirebaseDatabase(){
        FirebaseInit.getDatabase().getReference().child(FirebaseInfo.developmentNode).child(FirebaseInfo.books).orderByChild("category").equalTo(category).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                try{
                    BookModel bookModel = dataSnapshot.getValue(BookModel.class);
                    bookModels.add(bookModel);
                    Log.d("Books",bookModel.getBookName());
                    adapter.notifyDataSetChanged();
                }catch (Exception e){
                    Log.d("Book",dataSnapshot.getKey());

                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
