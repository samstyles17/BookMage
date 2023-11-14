package com.example.bookmage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MenuActivity extends AppCompatActivity
{
//    Toast toast;
    Toolbar toolbar;
    ImageView imageView, imageView2;
    FloatingActionButton fab,fab2,fab3,fab4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Set up the Toolbar

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = findViewById(R.id.imageView);
        registerForContextMenu(imageView);

        imageView2 = findViewById(R.id.imageView2);
        registerForContextMenu(imageView2);



       // Long click listener to open the floating context menu
        imageView.setOnLongClickListener(v -> {
            openContextMenu(v);
            return true;
        });
        // Long click listener to open the floating context menu
       imageView2.setOnLongClickListener(v -> {
            openContextMenu(v);
            return true;
        });

        fab = findViewById(R.id.fab1);
        fab2 = findViewById(R.id.fab2);
        fab3 = findViewById(R.id.fab3);
        fab4 = findViewById(R.id.fab4);



        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MenuActivity.this, fab);
                popupMenu.inflate(R.menu.popup_menu);

                popupMenu.setOnMenuItemClickListener(item -> {
                    int id = item.getItemId();

                    if (id == R.id.action_popup1) {
                       Toast toast = Toast.makeText(getApplicationContext(),"Shared through Whatsapp",Toast.LENGTH_LONG);
                       toast.show();
                        return true;
                    } else if (id == R.id.action_popup2) {
                        Toast toast = Toast.makeText(getApplicationContext(),"Shared through Gmail",Toast.LENGTH_LONG);
                        toast.show();
                        return true;
                    }

                    return false;
                });

                popupMenu.show();
            }
        });

        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MenuActivity.this, fab);
                popupMenu.inflate(R.menu.popup_menu);

                popupMenu.setOnMenuItemClickListener(item -> {
                    int id = item.getItemId();

                    if (id == R.id.action_popup1) {
                        Toast toast = Toast.makeText(getApplicationContext(),"Shared through Whatsapp",Toast.LENGTH_LONG);
                        toast.show();
                        return true;
                    } else if (id == R.id.action_popup2) {
                        Toast toast = Toast.makeText(getApplicationContext(),"Shared through Gmail",Toast.LENGTH_LONG);
                        toast.show();
                        return true;
                    }

                    return false;
                });

                popupMenu.show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MenuActivity.this, fab);
                popupMenu.inflate(R.menu.popup_menu2);

                popupMenu.setOnMenuItemClickListener(item -> {
                    int id = item.getItemId();

                    if (id == R.id.action2_popup1) {
                        Toast toast = Toast.makeText(getApplicationContext(),"Added to cart",Toast.LENGTH_LONG);
                        toast.show();
                        return true;
                    }

                    return false;
                });

                popupMenu.show();
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MenuActivity.this, fab);
                popupMenu.inflate(R.menu.popup_menu2);

                popupMenu.setOnMenuItemClickListener(item -> {
                    int id = item.getItemId();

                    if (id == R.id.action2_popup1) {
                        Toast toast = Toast.makeText(getApplicationContext(),"Added to Cart",Toast.LENGTH_LONG);
                        toast.show();
                        return true;
                    }
                    return false;
                });

                popupMenu.show();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                        DescriptionFragment descrfr = new DescriptionFragment();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction MainFragments = fragmentManager.beginTransaction();
                        MainFragments.replace(R.id.fragmentContainer, descrfr);
                        MainFragments.commit();


            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_option1) {
            Toast toast = Toast.makeText(this,"Information Updated",Toast.LENGTH_LONG);
            toast.show();
            return true;
        } else if (id == R.id.action_option2) {
            Toast toast = Toast.makeText(this,"Added to Cart",Toast.LENGTH_LONG);
            toast.show();
            // Handle Option 2 click
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_context1) {
            Toast toast = Toast.makeText(this,"Download Image",Toast.LENGTH_LONG);
            toast.show();
            // Handle Context 1 click
//            return true;
        } else if (id == R.id.action_context2) {
            Toast toast = Toast.makeText(this,"Copy Image",Toast.LENGTH_LONG);
            toast.show();
            // Handle Context 2 click
//            return true;
        }

        return super.onContextItemSelected(item);
    }


}