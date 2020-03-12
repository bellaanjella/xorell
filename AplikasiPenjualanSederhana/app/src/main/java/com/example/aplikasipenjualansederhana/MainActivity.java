package com.example.aplikasipenjualansederhana;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editpembeli, editebook, editjumlah, editharga,edituangbayar;
    private Button btnreset;
    private Button btnproses;
    private Button btnkeluar;
    private TextView txtnamapelanggan;
    private TextView txtebooks;
    private TextView txtjumlahbeli;
    private TextView txtuangbayar;
    private TextView txtharga;
    private TextView txtuangkembali;
    private TextView keterangan;
    private TextView bonus
    private TextView txttotalbelanja;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Sistem Penjualan Sederhana maju jaya");
        editpembeli = (EditText)findViewById(R.id.namapelanggan);
        editebook = (EditText)findViewById(R.id.Ebook);
        editjumlah = (EditText)findViewById(R.id.jmlhbeli);
        editharga = (EditText)findViewById(R.id.harga);
        edituangbayar = (EditText)findViewById(R.id.bayar);
        btnkeluar = (Button)findViewById(R.id.keluar);
        btnproses = (Button)findViewById(R.id.proses);
        btnreset = (Button)findViewById(R.id.reset);
        txtebooks = (TextView) findViewById(R.id.Ebook);
        txtnamapelanggan = (TextView) findViewById(R.id.namapelanggan);
        txtjumlahbeli = (TextView) findViewById(R.id.jmlhbeli);
        txtuangbayar = (TextView) findViewById(R.id.bayar);
        txtharga = (TextView) findViewById(R.id.harga);
        txtuangkembali = (TextView) findViewById(R.id.uangkembali);
        keterangan = (TextView) findViewById(R.id.keterangan);
        bonus = (TextView) findViewById(R.id.bonus);

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namapelanggan = editpembeli.getText().toString().trim();
                String Ebook = editebook.getText().toString().trim();
                String jmlhbeli = editjumlah.getText().toString().trim();
                String harga = editharga.getText().toString().trim();
                String bayar = edituangbayar.getText().toString().trim();

                double jb = Double.parseDouble(jmlhbeli);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(bayar);

                double total = (jb * h);
                txttotalbelanja.setText("Total Belanja : " + total);

                if (total >= 200000) {
                    bonus.setText("Bonus = Mouse");
                } else if (total >= 50000) {
                    bonus.setText("Bonus = Keyboard");
                }else if (total >= 40000){
                    bonus.setText("BOnus = Hardisl");
                }else{
                    bonus.setText("Bonus anda tidak Ada");
                }

                double uangkembalian = (ub-total);
                if (ub < total){
                    keterangan.setText("Keterangan : Uang Bayar anda Kurang : "+ uangkembalian );
                    txtuangkembali.setText("Uang Kembalian anda Rp : 0 ");
                } else {
                    keterangan.setText("Keterangan : Tunggu Kembalian");
                    keterangan.setText("Uang Kembali : " + uangkembalian);
                }
            }

        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtnamapelanggan.setText("");
                txtebooks.setText("");
                txttotalbelanja.setText("Total Belanja : Rp 0");
                txtharga.setText("");
                txtuangbayar.setText("");
                txtuangkembali.setText("Uang Kembali : Rp.0");
                bonus.setText("");
                txtjumlahbeli.setText("");
                keterangan.setText("Keterangan -");

                Toast.makeText(getApplicationContext(),"Data sudah direset",Toast.LENGTH_LONG).show();
            }
        });
        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
            }
        });
    }
}
