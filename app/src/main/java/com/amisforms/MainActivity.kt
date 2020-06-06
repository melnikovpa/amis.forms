package com.amisforms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.amisforms.elements.CompositeInputLayout
import com.amisforms.form.amisForm
import com.amisforms.form.asserts.input.NotEmptyAssertions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSubmit: Button = findViewById<Button>(R.id.btnSubmit)
        val compositeInput: CompositeInputLayout = findViewById(R.id.compositeInput)
        amisForm {
            compositeInput(compositeInput)
                .pushAssertion(NotEmptyAssertions()) //.setErrorMessage("Внимание, данное поле не может быть пустым, это недопустимо")
            submitWith(btnSubmit) {
                Toast.makeText(applicationContext, "sadsaasdsad", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
