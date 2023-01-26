package com.example.textviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.RadioAccessSpecifier
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the button object
        val button: Button = findViewById(R.id.button)
        // Initialize the textView3 object (display area)
        val textView3: TextView = findViewById(R.id.textView3)
        // Initialize the editText object
        val editText: EditText = findViewById(R.id.editTextName)

        // Set onClickListener for the button
        button.setOnClickListener() {
            // Get the input value from the editText
            val inputValue = editText.text.toString()

             // check if the inputValue is empty
            if (inputValue == null || inputValue.trim() == "") {
                Toast.makeText(this,
                    "Please input text, it can't be blank !",
                    Toast.LENGTH_SHORT).show()
            } else {
                textView3.text = inputValue
            // Set the inputValue to the textView3(display area)
                Toast.makeText(this, "Submitted !",
                    Toast.LENGTH_SHORT).show()
            }


            // Clear the text in the EditText view
            editText.setText("")

            //- - - - - - - - - - checkbox - - - - - - - - - - - - - - - - - - - -

            val checkbox1 :CheckBox = findViewById(R.id.checkBox)
            val checkbox2 :CheckBox = findViewById(R.id.checkBox2)
            val checkbox3 :CheckBox = findViewById(R.id.checkBox3)
            val checkbox4 :CheckBox = findViewById(R.id.checkBox4)
            val checkbox5 :CheckBox = findViewById(R.id.checkBox5)

            // to uncheck all checkBoxes after Submit button touched
            checkbox1.isChecked = false
            checkbox2.isChecked = false
            checkbox3.isChecked = false
            checkbox4.isChecked = false
            checkbox5.isChecked = false

//            var radioGroup: RadioGroup = findViewById(R.id.radioGroup)
//            radioGroup.clearCheck()
        }

        // Initialize the textView4 object (for Reset text)
        val textView4: TextView = findViewById(R.id.textView4)
        textView4.setOnClickListener {
            // check if the textView3 is empty
            if (textView3.text.toString() == null) {
                Toast.makeText(
                    this,
                    "Clicked on Reset Text,\nOutput Text Reset",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                textView3.setText("").toString() // Reset the text
                Toast.makeText(this, "Output Texted Reset",
                    Toast.LENGTH_SHORT).show()
            }
        }

        //- - - - - - - - - - RadioGroup for RadioButtons - - - - - - - - - - - - - - - - - - - - -

        //     Initialize the radioGroup object
        var radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        // to keep the radio button unchecked
        radioGroup.clearCheck()

        // Set onCheckedChangeListener for the radioGroup
        radioGroup.setOnCheckedChangeListener {
            group, checkedId ->
            val selectedRadioButton :RadioButton = findViewById(checkedId)
            Toast.makeText(this, "Selected ${selectedRadioButton.text}",
                Toast.LENGTH_SHORT).show()
        }

//        - - - - - - - - - - Spinner - - - - - - - - -

        // Initialize the spinner object
        val spinner = findViewById<Spinner>(R.id.spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter.createFromResource(
            this, R.array.spinner_items, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        spinner.adapter = adapter
    }
}



    
