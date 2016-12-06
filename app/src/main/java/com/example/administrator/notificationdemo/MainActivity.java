package com.example.administrator.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Context.NOTIFICATION_SERVICE;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {
    private Button btn_send;
    private Intent intent;
    private PendingIntent contentIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {

            private Notification notification;
            private NotificationManager notifyManager;

            @Override
            public void onClick(View view) {
                notifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                intent = new Intent(getApplicationContext(), MainActivity.class);
                contentIntent = PendingIntent.getActivity(getApplicationContext(), 100, intent, 0);
                notification = new Notification.Builder(MainActivity.this)
                        .setContentTitle("ContentTitle")
                        .setContentText("通知内容")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(contentIntent)
                        .setAutoCancel(true)//设置通知被点击后自动消失
                        .build();
                notifyManager.notify(100, notification);
            }

        });
    }
}
