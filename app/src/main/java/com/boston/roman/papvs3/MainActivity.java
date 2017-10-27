package com.boston.roman.papvs3;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.tv);
        registerForContextMenu(tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(1, 0, 0, "RegularMenu").setIcon(android.R.mipmap.sym_def_app_icon);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu cm, View v, ContextMenu.ContextMenuInfo cmi)
    {
        getMenuInflater().inflate(R.menu.mainmenu, cm);
    }

    @Override
    public boolean onContextItemSelected(MenuItem mi)
    {
        if(mi.getItemId() == R.id.second)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("About")
                    .setMessage("Roman Halaburda")
                    .setCancelable(false)
                    .setNegativeButton("OK", new DialogInterface.OnClickListener()
                    {
                        public  void onClick(DialogInterface dialog, int id)
                        {
                            dialog.cancel();
                        }
                    }
                    );
            AlertDialog alert = builder.create();
            alert.show();
        }
        return true;
    }

}
