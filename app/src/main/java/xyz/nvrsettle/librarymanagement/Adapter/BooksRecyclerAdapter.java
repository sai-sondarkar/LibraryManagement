package xyz.nvrsettle.librarymanagement.Adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

import xyz.nvrsettle.librarymanagement.Models.BookModel;
import xyz.nvrsettle.librarymanagement.R;

/**
 * Created by sai on 17/11/17.
 */

public class BooksRecyclerAdapter extends ArrayAdapter<BookModel> {


    private final Activity activity;
    List<BookModel> bookModelOriginalList = new ArrayList<BookModel>();
    List<BookModel> bookModelsDisplay = new ArrayList<>();
    String avaliable;
    public ViewHolder holder;

    public BooksRecyclerAdapter(Activity activity,
                                List<BookModel> bookModelOriginalList) {
        super(activity, R.layout.item_book, bookModelOriginalList);
        this.activity = activity;
        this.bookModelsDisplay = bookModelOriginalList;
        this.bookModelOriginalList = bookModelOriginalList;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.item_book, null, true);
            holder = new ViewHolder();
            holder.firstLetterTextView = (TextView) view.findViewById(R.id.first_letter_textView);
            holder.timeTextView = (TextView) view.findViewById(R.id.id_text_view);
            holder.nameTextView = (TextView) view.findViewById(R.id.name_text_view);
            holder.messageTextView = (TextView) view.findViewById(R.id.author_text_view);
            holder.color_band_view = (TextView) view.findViewById(R.id.text_view_color_band);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Typeface customEnglishTypeFace = Typeface.createFromAsset(activity.getAssets(), "fonts/Rubik-Light.ttf");
        holder.firstLetterTextView.setTypeface(customEnglishTypeFace);

        holder.firstLetterTextView.setText(bookModelOriginalList.get(position).getBookName());
        holder.timeTextView.setText(bookModelOriginalList.get(position).getBookId());
        holder.nameTextView.setText(bookModelOriginalList.get(position).getBookName());

        if(bookModelOriginalList.get(position).isAvaliable()){
            avaliable = "Avaliable";
        }else
        {
            avaliable = "Not Avalaiable";
        }
        holder.messageTextView.setText(bookModelOriginalList.get(position).getBookAuthor() + "\nQuantity - "+ bookModelOriginalList.get(position).getQuantity()+"\n Avaliability - "+ avaliable);
        return view;
    }




    static class ViewHolder {
        TextView firstLetterTextView;
        TextView timeTextView;
        TextView nameTextView;
        TextView messageTextView;
        TextView color_band_view;

    }
}