package com.example.shyamshankar.saarangreturns;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.provider.CalendarContract.Events;
import java.util.Calendar;

/**
 * Created by Shyam Shankar on 22-05-2016.
 */
public class Panache extends AppCompatActivity {

    ImageButton call;
    ImageButton email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panache);
        call=(ImageButton)findViewById(R.id.callLogo);

        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v)
            {
                Intent callIntent=new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:8113936122"));
                startActivity(callIntent);
            }
        });
        email=(ImageButton)findViewById(R.id.gmailLogo);
        email.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v)
            {
                Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"shyamshankarcern@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Inquiry about Panache");
                emailIntent.setType("message/rfc822");
                startActivity(emailIntent);
            }
        });

    }
    public void showMap(View v)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
    public void registerClick(View v)
    {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
    public void CalendarClick(View view){

        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");

        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.YEAR,2017);
        calendar.set(Calendar.MONTH,Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH,4);
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, (0));
        long startTime=calendar.getTimeInMillis();
        long endTime= calendar.getTimeInMillis() + 3*60*60*1000;

        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);

        intent.putExtra(Events.TITLE, "Panache Reminder");
        intent.putExtra(Events.DESCRIPTION,  "Reach SAC on time for Panache");
        intent.putExtra(Events.EVENT_LOCATION, "SAC");

        startActivity(intent);
    }
}
