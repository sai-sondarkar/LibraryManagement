package xyz.nvrsettle.librarymanagement.Acitivites;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import xyz.nvrsettle.librarymanagement.R;

public class HomeActivity extends AppCompatActivity {

    MaterialDialog dialog;
    List<String> booksCategories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        InitElements();
    }

    public void InitElements() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");

        TextView tx = (TextView) toolbar.findViewById(R.id.tx);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Rubik-Regular.ttf");
        tx.setTypeface(custom_font);
    }

    public void openAllBooks(View view){
        showListDialog();
    }

    public void showListDialog(){

        booksCategories = new ArrayList<>();

        booksCategories.add("personal Development");
        booksCategories.add("Computer engineering");
        booksCategories.add("Mechanical engineering");
        booksCategories.add("Civil Engineering");
        booksCategories.add("Physiotherapy");
        booksCategories.add("Pharmacy");
        booksCategories.add("Electrical engineering");

        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .title("Select Category")
                .items(booksCategories)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {

                        Intent intent = new Intent(HomeActivity.this,BooksActivity.class);
                        intent.putExtra("category",booksCategories.get(which));
                        startActivity(intent);

                    }
                });

        dialog = builder.build();
        dialog.show();
    }

    public void showToast(View view){
        Toast.makeText(getApplicationContext(),"under build",Toast.LENGTH_SHORT).show();
    }


}
