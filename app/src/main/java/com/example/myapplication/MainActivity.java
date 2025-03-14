package com.example.myapplication;
import android.widget.EditText;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.net.Uri;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
      Button button=findViewById(R.id.button);
      EditText editText=findViewById(R.id.editTextText);
        EditText editText2=findViewById(R.id.editTextText2);
        Button button2=findViewById(R.id.button3);
      button.setOnClickListener(new View.OnClickListener(){
          public void onClick(View v){
              Toast.makeText(MainActivity.this,"Button Clicked by user",Toast.LENGTH_SHORT).show();
              String user=editText.getText().toString();
              Intent intent = new Intent(MainActivity.this, MainActivity2.class);
              intent.putExtra("name",user);
              startActivity(intent);
          editText.setText("");
          }
      });
      button2.setOnClickListener(new View.OnClickListener(){
          public void onClick(View v) {
              Toast.makeText(MainActivity.this, "Button Clicked by user", Toast.LENGTH_SHORT).show();
              String url=editText2.getText().toString();
              Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
              startActivity(intent);
              editText2.setText("");
          }
      });
      }
    }
