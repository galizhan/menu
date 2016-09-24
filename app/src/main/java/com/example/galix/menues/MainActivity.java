package com.example.galix.menues;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int IDM_SETTINGS = 101;
    private static final int IDM_RED = 102;
    private static final int IDM_YELLOW = 103;
    private static final int IDM_GREEN = 104;
    private static final int IDT_TXT1 = 201;
    private static final int IDT_TXT2 = 202;
    private static final int IDT_TXT3 = 203;
    RelativeLayout rl;
    SubMenu subMenu;
    MenuItem item1;
    int temp = 0;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl = (RelativeLayout)findViewById(R.id.rel);
        btn = (Button)findViewById(R.id.btn1);
        registerForContextMenu(btn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        subMenu = menu.addSubMenu(0, 1, 0, "Colors");
        menu.add(0, IDM_SETTINGS, 1, "Settings");
        subMenu.add(1,3,0,"Red");
        subMenu.add(2,4,1,"Yellow");
        subMenu.add(3,5,2,"Green");

        return super.onCreateOptionsMenu(menu);
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Log.d("new",""+1);
        switch (item.getItemId()){
            case IDM_SETTINGS:
                Toast toast = Toast.makeText(getApplicationContext(),"You have pressed settings",Toast.LENGTH_LONG);
                toast.show();
                break;
            case 3:
                if(temp!=0) item1.setVisible(true);
                temp++;
                rl.setBackgroundColor(getResources().getColor(R.color.colorRed));
                item1 = item;
                item.setVisible(false);
                break;
            case  4:
                if(temp!=0) item1.setVisible(true);
                item1.setVisible(true);
                rl.setBackgroundColor(getResources().getColor(R.color.colorYellow));
                item1 = item;
                item.setVisible(false);
                break;

            case 5:
                if(temp!=0) item1.setVisible(true);
                item1.setVisible(true);
                rl.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                item.setVisible(false);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btn1:
                menu.add(0, IDT_TXT1, 0, "Text 1");
                menu.add(0, IDT_TXT2, 0, "Text 2");
                menu.add(0, IDT_TXT3, 0, "Text 3");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case IDT_TXT1:
                btn.setText("text 1");
                break;
            case IDT_TXT2:
                btn.setText("text 2");
                break;
            case IDT_TXT3:
                btn.setText("text 3");
                break;
        }
        return super.onContextItemSelected(item);
    }
}

