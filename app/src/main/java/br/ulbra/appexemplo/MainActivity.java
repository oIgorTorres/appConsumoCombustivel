package br.ulbra.appexemplo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txtNome, txtDistancia, txtConsumo, txtPreco, txtPlaca;
    Button btnCalcular;
    TextView txtResp, txtResp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            txtNome = findViewById((R.id.txtNome));
            txtPlaca = findViewById((R.id.txtPlaca));
            txtDistancia = findViewById((R.id.txtDistancia));
            txtConsumo = findViewById((R.id.txtConsumo));
            txtPreco = findViewById((R.id.txtPreco));
            btnCalcular = findViewById((R.id.btnCalcular));
            txtResp = findViewById((R.id.txtResp));
            txtResp2 = findViewById((R.id.txtResp2));





            btnCalcular.setOnClickListener(new View.OnClickListener(){
                @Override
                        public void onClick(View v){

                    double combuNec, distancia, consumo, custoViagem, preco;

                    distancia = Double.parseDouble(txtDistancia.getText().toString());
                    consumo = Double.parseDouble(txtConsumo.getText().toString());
                    preco = Double.parseDouble(txtPreco.getText().toString());

                    combuNec = distancia / consumo;

                    custoViagem = combuNec * preco;

                    txtResp.setText("O combustível necessário será de: " +combuNec);
                    txtResp2.setText("O custo da viagem necessário será de: " +custoViagem);


                }
            });





            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}