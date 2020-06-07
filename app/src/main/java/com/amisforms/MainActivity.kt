package com.amisforms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.amisforms.elements.CompositeInputLayout
import com.amisforms.form.amisForm
import com.amisforms.form.asserts.input.IntegerAssertions
import com.amisforms.form.asserts.input.LengthAssertions
import com.amisforms.form.asserts.input.NotEmptyAssertions
import com.amisforms.form.asserts.input.RegexAssertions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSubmit: Button = findViewById<Button>(R.id.btnSubmit)
        val compositeInput: CompositeInputLayout = findViewById(R.id.compositeInput)
        val compositeInputH: CompositeInputLayout = findViewById(R.id.compositeInputH)

        amisForm {
            compositeInput(compositeInput)
                .pushAssertion(NotEmptyAssertions("Внимание, данное поле не может быть пустым, это недопустимо"))
                .pushAssertion(LengthAssertions("Ошибка допустимых значений", 3))
                .pushAssertion(RegexAssertions("Введен некорректный Email", "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"))

            compositeInput(compositeInputH)
                .pushAssertion(IntegerAssertions("Допустимы только числовые значения"))

            submitWith(btnSubmit) {
                Toast.makeText(applicationContext, "sadsaasdsad", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
