package com.amisforms.form.asserts.input

import android.widget.EditText
import com.amisforms.form.asserts.BaseAssert

class LengthAssertions(
    errorMessage: String,
    minLength: Int? = null,
    maxLength: Int? = null
) : BaseAssert()
{
    private var _minLength: Int? = null
    private var _maxLength: Int? = null

    init {
        this.setErrorMessage(errorMessage)
        this._minLength = minLength
        this._maxLength = maxLength
    }

    override fun check(input: EditText): Boolean
    {
        // Проверка что текст входит в указанный диапазон
        if (
            _minLength != null && _maxLength != null &&
            (input.text.length < _minLength!! || input.text.length > _maxLength!! )
           )
        {
            return false
        } else if (_minLength != null && input.text.length < _minLength!!) {
            // Проверка только на минимальную длинну
            return false
        } else if (_maxLength != null && input.text.length > _maxLength!!) {
            // Проверка только на максимальную длинну
            return false
        }

        return true
    }

}