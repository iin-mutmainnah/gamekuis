package com.iinmillo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA,PilihanB,PilihanC,PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //Pertanyaan Kuis
    String[] pertanyaan_kuis = new String[]{
            "1. Ibu kota Negara Kesatuan Republik Indonesia adalah",
            "2. Presiden pertama Negara Indonesia adalah",
            "3. Lambang Negara Indonesia adalah",
            "4. Lagu Kebangsaan Indonesia adalah",
            "5. Bendera Negara Indonesia adalah"
    };

    // Pilihan jawaban a, b, c, d
    String[]Pilihan_jawaban = new String[]{
            "jakarta","medan","surabaya","papua",
            "jokowi","SBY","soeharto","soekarno",
            "harimau","garuda pancasila","elang merah","komodo",
            "indonesia raya","indonesia merdeka","majulah indonesiaku","bhineka tunggal ika",
            "putih abu abu","putih merah","merah putih","merah orange",
    };

    //jawaban yg benar
    String[] jawaban_benar = new String[] {
             "jakarta",
             "soekarno",
             "garuda pancasila",
             "indonesia raya",
             "merah putih",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pertanyaan = (TextView)findViewById(R.id.pertanyaan);
        rg = (RadioGroup)findViewById(R.id.radio_grup);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(Pilihan_jawaban[0]);
        PilihanB.setText(Pilihan_jawaban[1]);
        PilihanC.setText(Pilihan_jawaban[2]);
        PilihanD.setText(Pilihan_jawaban[3]);

        rg.check(  0);
        benar = 0;
        salah = 0;

    }

    public void next (View view) {
        if (PilihanA.isChecked()|| PilihanB.isChecked()|| PilihanC.isChecked()|| PilihanD.isChecked());
        RadioButton jawaban_user = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
        String ambil_jawaban_user = jawaban_user.getText().toString();
        rg.check(   0);
        if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor]))benar++;
        else salah++;
        nomor++;
        if (nomor<pertanyaan_kuis.length){
            pertanyaan.setText(pertanyaan_kuis[nomor]);
            PilihanA.setText(Pilihan_jawaban[(nomor*4)+0]);
            PilihanB.setText(Pilihan_jawaban[(nomor*4)+1]);
            PilihanC.setText(Pilihan_jawaban[(nomor*4)+2]);
            PilihanD.setText(Pilihan_jawaban[(nomor*4)+3]);
        }
        else {
            hasil=benar * 20;
            Intent selesai = new Intent(getApplicationContext(),HasilKuis.class);
            startActivity(selesai);
        }
    }
    {
        Toast.makeText(this, "Pilih Jawaban dulu",Toast.LENGTH_SHORT).show();
    }
}