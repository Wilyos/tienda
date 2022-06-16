package com.cesde.tienda;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cesde.tienda.databinding.ActivityMainBinding;
import com.cesde.tienda.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding registerBinding;
    DbTienda  dbTienda;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        registerBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = registerBinding.getRoot();
        setContentView(R.layout.activity_register);
        dbTienda  = new DbTienda(this);

    }

    public void registerUser(View view){

        SQLiteDatabase db = dbTienda.getWritableDatabase();
        ContentValues userData = new ContentValues();
        String name = registerBinding.etName.getText().toString();
        String email = registerBinding.etEmailR.getText().toString();
        String password = registerBinding.etPasswordR.getText().toString();
        String identification = registerBinding.etIdentification.getText().toString();
        userData.put("name", name);
        userData.put("email", email);
        userData.put("identification", identification);
        userData.put("password", password);
        long newUser = db.insert("users",null,userData);
        Toast.makeText(this, "" + newUser, Toast.LENGTH_SHORT).show();


    }

}
