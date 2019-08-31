package com.clarkgarrett.testletterpicker2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener{
    private TextView tvLetter1, tvLetter2, tvLetter3, tvLetter4, tvRetrieve;
    private ListView lvLetters1, lvLetters2, lvLetters3, lvLetters4;
    private FrameLayout frLetter1, frLetter2, frLetter3, frLetter4;
    private Button btnRetrieve;
    private int tvLetter1Id, lvLetters1Id, frLetter1Id,
                tvLetter2Id, lvLetters2Id, frLetter2Id,
                tvLetter3Id, lvLetters3Id, frLetter3Id,
                tvLetter4Id, lvLetters4Id, frLetter4Id,
                btnRetrieveId;
    private LetterArrayAdapter adapter1, adapter2, adapter3, adapter4;
    private ArrayList<Character> alConsonantChars = new ArrayList<>();
    private ArrayList<Character> alVowelChars = new ArrayList<>();
    private static final String TAG = "## My Info ##";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getViews();
        getViewIds();
        setListeners();
        setCharArrayLists();
        setAdapters();
        setSizes();
    }

    private int getWidth(){
        FrameLayout fakeParent = new FrameLayout(this);
        View view = null;
        view = adapter1.getView(0, view, fakeParent);
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        return view.getMeasuredWidth();
    }

    private void getViews(){
        tvLetter1 = (TextView)findViewById(R.id.tvLetter1);
        lvLetters1 = (ListView)findViewById(R.id.lvLetters1);
        frLetter1 = (FrameLayout)findViewById(R.id.frFrame1);

        tvLetter2 = (TextView)findViewById(R.id.tvLetter2);
        lvLetters2 = (ListView)findViewById(R.id.lvLetters2);
        frLetter2 = (FrameLayout)findViewById(R.id.frFrame2);

        tvLetter3 = (TextView)findViewById(R.id.tvLetter3);
        lvLetters3 = (ListView)findViewById(R.id.lvLetters3);
        frLetter3 = (FrameLayout)findViewById(R.id.frFrame3);

        tvLetter4 = (TextView)findViewById(R.id.tvLetter4);
        lvLetters4 = (ListView)findViewById(R.id.lvLetters4);
        frLetter4 = (FrameLayout)findViewById(R.id.frFrame4);

        tvRetrieve = (TextView)findViewById(R.id.tvRetrieve);
        btnRetrieve = (Button)findViewById(R.id.btnRetrieve);
    }

    private void getViewIds(){
        tvLetter1Id = tvLetter1.getId();
        lvLetters1Id = lvLetters1.getId();
        frLetter1Id = frLetter1.getId();

        tvLetter2Id = tvLetter2.getId();
        lvLetters2Id = lvLetters2.getId();
        frLetter2Id = frLetter2.getId();

        tvLetter3Id = tvLetter3.getId();
        lvLetters3Id = lvLetters3.getId();
        frLetter3Id = frLetter3.getId();

        tvLetter4Id = tvLetter4.getId();
        lvLetters4Id = lvLetters4.getId();
        frLetter4Id = frLetter4.getId();

        btnRetrieveId = btnRetrieve.getId();
    }

    private void setListeners(){
        tvLetter1.setOnClickListener(this);
        frLetter1.setOnClickListener(this);
        lvLetters1.setOnItemClickListener(this);

        tvLetter2.setOnClickListener(this);
        frLetter2.setOnClickListener(this);
        lvLetters2.setOnItemClickListener(this);

        tvLetter3.setOnClickListener(this);
        frLetter3.setOnClickListener(this);
        lvLetters3.setOnItemClickListener(this);

        tvLetter4.setOnClickListener(this);
        frLetter4.setOnClickListener(this);
        lvLetters4.setOnItemClickListener(this);

        btnRetrieve.setOnClickListener(this);
    }

    private void setCharArrayLists(){

        char[] aConsonantChars;
        char[] aVowelChars;
        String consonants = "BCDFGHJKLMNPQRSTVWXYZ";
        String vowels = "AEIOU";
        aConsonantChars = consonants.toCharArray();

        for (int i = 0; i< aConsonantChars.length; i++){
            alConsonantChars.add(aConsonantChars[i]);
        }

        aVowelChars = vowels.toCharArray();
        for (int i = 0; i< aVowelChars.length; i++){
            alVowelChars.add(aVowelChars[i]);
        }
    }

    private void setAdapters(){
        adapter1 = new LetterArrayAdapter(this, alConsonantChars);
        lvLetters1.setAdapter(adapter1);

        adapter2 = new LetterArrayAdapter(this, alConsonantChars);
        lvLetters2.setAdapter(adapter2);

        adapter3 = new LetterArrayAdapter(this, alConsonantChars);
        lvLetters3.setAdapter(adapter3);

        adapter4 = new LetterArrayAdapter(this, alVowelChars);
        lvLetters4.setAdapter(adapter4);
    }

    private void setSizes(){
        tvLetter1.setMinEms(1);
        tvLetter1.setText(" ");

        tvLetter2.setMinEms(1);
        tvLetter2.setText(" ");

        tvLetter3.setMinEms(1);
        tvLetter3.setText(" ");

        tvLetter4.setMinEms(1);
        tvLetter4.setText(" ");

        int width = getWidth();
        lvLetters1.getLayoutParams().width = width;
        lvLetters2.getLayoutParams().width = width;
        lvLetters3.getLayoutParams().width = width;
        lvLetters4.getLayoutParams().width = width;
    }

    @Override
    public void onClick(View v){
        int id = v.getId();

        if (id == tvLetter1Id || id == frLetter1Id){
            setVisibility(lvLetters1);
            return;
        }

        if (id == tvLetter2Id || id == frLetter2Id){
            setVisibility(lvLetters2);
            return;
        }

        if (id == tvLetter3Id || id == frLetter3Id){
            setVisibility(lvLetters3);
            return;
        }

        if (id == tvLetter4Id || id == frLetter4Id){
            setVisibility(lvLetters4);
            return;
        }

        if(id == btnRetrieveId) {
            tvRetrieve.setText(tvLetter1.getText().toString() +
                               tvLetter2.getText().toString() +
                               tvLetter3.getText().toString() +
                               tvLetter4.getText().toString());
            lvLetters1.setVisibility(View.INVISIBLE);
            lvLetters2.setVisibility(View.INVISIBLE);
            lvLetters3.setVisibility(View.INVISIBLE);
            lvLetters4.setVisibility(View.INVISIBLE);
            tvLetter1.setText(" ");
            tvLetter2.setText(" ");
            tvLetter3.setText(" ");
            tvLetter4.setText(" ");

        }
    }

    private void setVisibility(View v){
        if (v.getVisibility() == View.VISIBLE) {
            v.setVisibility(View.INVISIBLE);
        } else {
            v.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        int vid = parent.getId();

        if (vid == lvLetters1Id){
            tvLetter1.setText(alConsonantChars.get(position).toString());
            return;
        }

        if (vid == lvLetters2Id){
            tvLetter2.setText(alConsonantChars.get(position).toString());
            return;
        }

        if (vid == lvLetters3Id){
            tvLetter3.setText(alConsonantChars.get(position).toString());
            return;
        }

        if (vid == lvLetters4Id){
            tvLetter4.setText(alVowelChars.get(position).toString());
        }
    }
}
