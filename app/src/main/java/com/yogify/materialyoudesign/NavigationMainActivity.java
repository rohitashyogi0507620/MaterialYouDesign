package com.yogify.materialyoudesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigationrail.NavigationRailView;

public class NavigationMainActivity extends AppCompatActivity {

    NavigationRailView navigationRailView;
    BadgeDrawable badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);

        navigationRailView = findViewById(R.id.navigation_rail);
        GetDatafromChip();
        CardViewmethods();
        Expendedfab();

    }

    private void Expendedfab() {
        FloatingActionButton extendedFab = findViewById(R.id.extended_fab);
        extendedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                extendedFab.setExpanded(false);

                // extendedFab.setshrshrink()
            }
        });

    }

    private void CardViewmethods() {
        CardView cardView = findViewById(R.id.card_cheable);
        cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                //  cardView.setChecked(cardView.isch)
                return true;
            }
        });
    }

    private void GetDatafromChip() {
        Chip chip = findViewById(R.id.chip_2);
        chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String chiptext = compoundButton.getText().toString();
                Toast.makeText(getApplicationContext(), chiptext, Toast.LENGTH_SHORT).show();
            }
        });
        Chip chipfilter = findViewById(R.id.chip_3);
        chipfilter.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chiptext = view.toString().toString();
                Toast.makeText(getApplicationContext(), chiptext, Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void fun_Setnotification(View view) {
        badge = navigationRailView.getOrCreateBadge(R.id.notification);
        badge.setVisible(true);
        badge.setNumber(33);


    }

    public void fub_removenotifiaction(View view) {
        badge = navigationRailView.getBadge(R.id.notification);
        if (badge != null) {
            badge.setVisible(false);
            badge.clearNumber();
        }

        navigationRailView.removeBadge(R.id.notification);
    }
}