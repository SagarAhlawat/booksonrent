package com.workshop.booksonrent;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import static android.R.id.list;
import static com.workshop.booksonrent.R.id.list1;
import static com.workshop.booksonrent.R.id.list2;

public class Syr extends AppCompatActivity
{
    ListView list;
    String[] titles;
    String[] description;
    int [] imgs={R.drawable.maths,R.drawable.phy,R.drawable.chemistry};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syr);
        Intent b2=getIntent();

        Resources res=getResources();
        titles=res.getStringArray(R.array.titles2);
        description=res.getStringArray(R.array.description2);
        list=(ListView)findViewById(list2);

        Syr.MyAdapter adapter=new Syr.MyAdapter(this,titles,imgs,description);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent j=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(j);
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        int [] imgs;
        String myTitles[];
        String myDescription[];

        MyAdapter(Context c,String []titles2,int []imgs,String []description2)
        {
            super(c,R.layout.row,R.id.text1,titles);
            this.context=c;
            this.imgs=imgs;
            this.myDescription=description2;
            this.myTitles=titles2;

        }
        @Override
        public View getView(final int posistion, View convertView, ViewGroup parent)
        {
            LayoutInflater layoutInflater=(LayoutInflater)context. getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.row,parent,false);

            ImageView images=(ImageView)row.findViewById(R.id.icon);
            TextView myTitle=(TextView)row.findViewById(R.id.text1);
            TextView myDescription=(TextView)row.findViewById(R.id.text2);
            images.setImageResource(imgs[posistion]);
            myTitle.setText(titles[posistion]);
            myDescription.setText(description[posistion]);

            return row;




        }
    }


}
