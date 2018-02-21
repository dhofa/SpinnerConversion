package id.ac.pens.student.it.ahmadmundhofa.spinnerconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nilai_awal;
    private TextView nilai_akhir;
    private Spinner satuan_awal, satuan_akhir;
    private String[] satuan_conversi = {"centimeter","meter"};
    private String str_satuan_awal,str_satuan_akhir;
    private Button btn_convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nilai_awal  = (EditText) findViewById(R.id.nilai_awal);
        nilai_akhir = (TextView) findViewById(R.id.nilai_akhir);
        satuan_awal = (Spinner) findViewById(R.id.satuan_awal);
        satuan_akhir= (Spinner) findViewById(R.id.satuan_akhir);
        btn_convert = (Button) findViewById(R.id.btn_convert);

        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,satuan_conversi);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        satuan_awal.setAdapter(adapter);
        satuan_akhir.setAdapter(adapter);

        satuan_awal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_satuan_awal = satuan_conversi[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        satuan_akhir.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_satuan_akhir = satuan_conversi[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_nilai_inputan = nilai_awal.getText().toString();

                if(!str_nilai_inputan.isEmpty()){
                    Double int_awal = Double.valueOf(str_nilai_inputan);

                    if(str_satuan_awal.equals(satuan_conversi[0])){
                        if(str_satuan_akhir.equals(satuan_conversi[0])){
                            //TODO: conversi dari cm to cm
                            nilai_akhir.setText(String.valueOf(int_awal)+" centimeter");
                        }else if(str_satuan_akhir.equals(satuan_conversi[1])){
                            //TODO: conversi dari cm to meter
                            nilai_akhir.setText(String.valueOf(int_awal/100)+" meter");
                        }
                    }else if(str_satuan_awal.equals(satuan_conversi[1])){
                        if(str_satuan_akhir.equals(satuan_conversi[0])){
                            //TODO: conversi dari meter to cm
                            nilai_akhir.setText(String.valueOf(int_awal*100)+" centimeter");
                        }else if(str_satuan_akhir.equals(satuan_conversi[1])){
                            //TODO: conversi dari meter to meter
                            nilai_akhir.setText(String.valueOf(int_awal)+" meter");
                        }
                    }
                }else{
                    nilai_awal.setError("isi terlebih dahulu gan..");
                    Toast.makeText(MainActivity.this, "Isi dahulu nilai awal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
