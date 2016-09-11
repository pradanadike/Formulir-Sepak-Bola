package id.sch.smktelkom_mlg.tugas01.xirpl5025.formulirsepakbola;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etND;
    EditText etNB;
    Button bDaftar;
    //    RadioButton rbLK, rbPM;
    RadioGroup rgJK;
    CheckBox cbST, cbGN, cbBK, cbKP;
    Spinner spAN;
    TextView tvHasil, tvPosisi;
    int nPosisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etND = (EditText) findViewById(R.id.editTextND);
        etNB = (EditText) findViewById(R.id.editTextNB);
       /* rbLK = (RadioButton) findViewById(R.id.radioButtonLK);
        rbPM = (RadioButton) findViewById(R.id.radioButtonPM);*/
        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);
        cbST = (CheckBox) findViewById(R.id.checkBoxST);
        cbGN = (CheckBox) findViewById(R.id.checkBoxGN);
        cbBK = (CheckBox) findViewById(R.id.checkBoxBK);
        cbKP = (CheckBox) findViewById(R.id.checkBoxKP);
        spAN = (Spinner) findViewById(R.id.spinnerAN);
        bDaftar = (Button) findViewById(R.id.buttonDaftar);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvPosisi = (TextView) findViewById(R.id.textViewPosisi);

        cbST.setOnCheckedChangeListener(this);
        cbGN.setOnCheckedChangeListener(this);
        cbBK.setOnCheckedChangeListener(this);
        cbKP.setOnCheckedChangeListener(this);

        bDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String namaDP = etND.getText().toString();
            String namaNB = etNB.getText().toString();

            String posisi = "Posisi Anda :\n";
            int startlen = posisi.length();
            if (cbST.isChecked()) posisi += cbST.getText() + "\n";
            if (cbGN.isChecked()) posisi += cbGN.getText() + "\n";
            if (cbBK.isChecked()) posisi += cbBK.getText() + "\n";
            if (cbKP.isChecked()) posisi += cbKP.getText() + "\n";

            if (posisi.length() == startlen) posisi += "Tidak ada pada Pilihan";

            String hasil = null;

            if (rgJK.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(rgJK.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }

        /*if(rbLK.isChecked())
        {
            hasil = rbLK.getText().toString();
        }
        else if(rbLK.isChecked())
        {
            hasil = rbLK.getText().toString();
        }
        else if(rbPM.isChecked())
        {
            hasil = rbPM.getText().toString();
        }*/

            tvHasil.setText("Nama Anda : " + namaDP + "  " + namaNB + "\n" + "Asal Negara Anda : " + spAN.getSelectedItem().toString() + "\n" + "Jenis Kelamin Anda : " + hasil + "\n" + posisi);
        }
    }


    private boolean isValid() {
        boolean valid = true;

        String namaND = etND.getText().toString();
        String namaNB = etNB.getText().toString();

        if (namaND.isEmpty()) {
            etND.setError("Nama belum diisi");
            valid = false;
        } else {
            etND.setError(null);
        }

        if (namaNB.isEmpty()) {
            etNB.setError("Nama belum diisi");
            valid = false;
        } else {
            etNB.setError(null);
        }
        return valid;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nPosisi += 1;
        else nPosisi -= 1;

        tvPosisi.setText("Posisi (" + nPosisi + " terpilih)");
    }
}
