package com.example.seblakmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //MAKANAN
        final CheckBox makanan1 = findViewById(R.id.seblakchikuwa);
        final CheckBox makanan2 = findViewById(R.id.seblakdumpling);
        final CheckBox makanan3 = findViewById(R.id.seblaksosis);
        final CheckBox makanan4 = findViewById(R.id.seblakkomplit);
        final CheckBox makanan5 = findViewById(R.id.seblaktelur);





        //JUMLAH MAKANAN
        final EditText jml_mkn1 = findViewById(R.id.jumlahseblakchikuwa);
        final EditText jml_mkn2 = findViewById(R.id.jumlahseblakdumpling);
        final EditText jml_mkn3 = findViewById(R.id.jumlahseblaksosis);
        final EditText jml_mkn4 = findViewById(R.id.jumlahseblakkomplit);
        final EditText jml_mkn5 = findViewById(R.id.jumlahseblaktelur);



        //HARGA MAKANAN
        final int harga_seblakchikuwa = 10000;
        final int harga_seblakdumpling = 10000;
        final int harga_seblaksosis = 25000;
        final int harga_seblakkomplit = 12000;
        final int harga_seblaktelur = 10000;

        Button btn = findViewById(R.id.submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!makanan1.isChecked() && !makanan2.isChecked() && !makanan3.isChecked() && !makanan4.isChecked() && !makanan5.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Silahkan Pilih Makanan", Toast.LENGTH_SHORT).show();
                }else {
                    String text = "";
                    int totOrder = 0;
                    int discount = 0;
                    if (makanan1.isChecked()) {
                        String hasil = "Seblak Chikuwa ";
                        int jml = Integer.parseInt(String.valueOf(jml_mkn1.getText()));
                        int cal = jml * harga_seblakchikuwa;
                        text += jml + "\t\t" + hasil + "\n" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;

                    }
                    if (makanan2.isChecked()) {
                        String hasil = "Seblak Dumping ";
                        int jml = Integer.parseInt(String.valueOf(jml_mkn2.getText()));
                        int cal = jml * harga_seblakdumpling;
                        text += jml + "\t\t" + hasil + "\n" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }
                    if (makanan3.isChecked()) {
                        String hasil = "Seblak Kompit ";
                        int jml = Integer.parseInt(String.valueOf(jml_mkn3.getText()));
                        int cal = jml * harga_seblakkomplit;
                        text += jml + "\t\t" + hasil + "\n" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }


                    if (makanan4.isChecked()) {
                        String hasil = "Seblak Sosis ";
                        int jml = Integer.parseInt(String.valueOf(jml_mkn4.getText()));
                        int cal = jml * harga_seblaksosis;
                        text += jml + "\t\t" + hasil + "\n" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }
                    if (makanan5.isChecked()) {
                        String hasil = "Seblak Telur ";
                        int jml = Integer.parseInt(String.valueOf(jml_mkn5.getText()));
                        int cal = jml * harga_seblaktelur;
                        text += jml + "\t\t" + hasil + "\n" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }
                    if (totOrder >= 100000) {
                        discount = totOrder * 10/100;
                    }
                    Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                    intent.putExtra("Coba", text);
                    intent.putExtra("Bayar", totOrder);
                    intent.putExtra("Discount", discount);
                    startActivity(intent);
                }
            }
        });
    }
}