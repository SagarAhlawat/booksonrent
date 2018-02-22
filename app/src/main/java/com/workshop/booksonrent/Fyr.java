package com.workshop.booksonrent;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import static com.workshop.booksonrent.R.id.list1;

public class Fyr extends AppCompatActivity
{
    ListView list;
    String[] titles;
    String[] description;
    int [] imgs={R.drawable.modernphy,R.drawable.modernphy2used,R.drawable.electrical,R.drawable.electrical,R.drawable.electronics,R.drawable.maths1,R.drawable.maths1,R.drawable.maths2,R.drawable.maths2,R.drawable.mechanics,R.drawable.mechanics,R.drawable.mathsvol2};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fyr);
        Intent intent=getIntent();
        Resources res=getResources();
        titles=res.getStringArray(R.array.titles);
        description=res.getStringArray(R.array.description);
        list=(ListView)findViewById(list1);

        MyAdapter adapter=new MyAdapter(this,titles,imgs,description);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position==0){
                    Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://booksonrent.gq/product/concept-of-modern-physics-2/"));
                    startActivity(i);
                }
                if (position==1){
                    Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://booksonrent.gq/product/concept-of-modern-physics-2-2/"));
                    startActivity(i);
                }
                if (position==2){
                    Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://booksonrent.gq/product/electrical-engineering/"));
                    startActivity(i);
                }
                if (position==3){
                    Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://booksonrent.gq/product/electrical-engineering-2/"));
                    startActivity(i);
                }
                if (position==4){
                    Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://booksonrent.gq/product/electronic-devices-circuit-theory/"));
                    startActivity(i);
                }
                if (position==5){
                    Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://booksonrent.gq/product/engineering-mathematics-i/"));
                    startActivity(i);
                } if (position==6){
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://booksonrent.gq/product/engineering-maths-2/"));
                startActivity(i);
            } if (position==7){
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://booksonrent.gq/product/engineering-maths-2-2/"));
                startActivity(i);
            } if (position==8){
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://booksonrent.gq/product/engineering-mechanics/"));
                startActivity(i);
            } if (position==9){
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://booksonrent.gq/product/engineering-mechanics-2/"));
                startActivity(i);
            } if (position==10){
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://booksonrent.gq/product/fundamental-of-engineering-mathematicsvol-2/"));
                startActivity(i);
            }

            }
        });



    }
    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        int [] imgs;
        String myTitles[];
        String myDescription[];

        MyAdapter(Context c,String []titles,int []imgs,String []description)
        {
            super(c,R.layout.row,R.id.text1,titles);
            this.context=c;
            this.imgs=imgs;
            this.myDescription=description;
            this.myTitles=titles;

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

