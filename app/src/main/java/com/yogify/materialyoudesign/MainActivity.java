package com.yogify.materialyoudesign;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_MaterialYouDesign);
        setContentView(R.layout.activity_main);
        ShowBasicDialog();
        ShowfullscreenDialog();
        Setbottomnavigation();
    }

    private void Setbottomnavigation() {
        BadgeDrawable badge;
        BottomNavigationView bottomSheetDialog = findViewById(R.id.bottom_navigation);
        badge = bottomSheetDialog.getOrCreateBadge(R.id.notification);
        badge.setVisible(true);

        badge.setNumber(33);

    }

    public void fun_Navigationrailsview(View view) {
        startActivity(new Intent(getApplicationContext(), NavigationMainActivity.class));
    }

    public void fun_DateRangePickerDialog(View view) {
        MatirialARangPicker();
    }

    public void fun_DatepickerDialog(View view) {
        MatrialDatePicker();
    }


    public void MatirialARangPicker() {
        MaterialDatePicker dateRangePicker =
                MaterialDatePicker.Builder.dateRangePicker()
                        .setTitleText("Select dates")
                        .build();
        dateRangePicker.show(getSupportFragmentManager(), "This");
        dateRangePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                String datainmillis = selection.toString();
                Toast.makeText(getApplicationContext(), selection.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void MatrialDatePicker() {

        MaterialDatePicker datePicker =
                MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select date")
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .build();

        datePicker.show(getSupportFragmentManager(), "Hell dATA");
        datePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                String datainmillis = selection.toString();
                Toast.makeText(getApplicationContext(), selection.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void ShowBasicDialog() {

        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(getApplicationContext(), R.style.ThemeOverlay_App_MaterialAlertDialog)
                .setTitle("Hello Sir")
                .setMessage("we are in alert dialog series so injoy")
                .setNeutralButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("decline", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        Button button = findViewById(R.id.btn_showBasicdialog);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }

    public void ShowfullscreenDialog() {


        Button button = findViewById(R.id.btn_showFullScreendialog);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                DialogFragment newFragment = FullScreeDialogFragment.newInstance();
                newFragment.show(getSupportFragmentManager(), "dff");
            }
        });


    }
}