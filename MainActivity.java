package com.zlaqh.baseconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.type;

public class MainActivity extends AppCompatActivity {

    //declaring array for spinner items
    String[] inputBase;
    String[] outputBase;

    //declaring spinner items
    Spinner inputSpinner;
    Spinner outputSpinner;

    //declaring strings for spinner selected
    String selectedInputBase;
    String selectedOutputBase;

    //declaring the number fields
    EditText inputEditText;
    TextView outputTextView;

    //trying something out
    int originalBase;
    int originalNum;
    String origNum;
    int targetBase;
    String targetNum;
    ArrayList<Integer> modList;

    //declaring and instantiating OTD and DTO
    OtherToDecimal OTD = new OtherToDecimal();
    DecimalToOther DTO = new DecimalToOther();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // DO NOT TOUCH THE ABOVE CODE

        //instantiating spinner items
        inputSpinner = (Spinner) findViewById(R.id.input_spinner);
        outputSpinner = (Spinner) findViewById(R.id.output_spinner);

        //instantiating number fields
        inputEditText = (EditText) findViewById(R.id.input_number);
        outputTextView = (TextView) findViewById(R.id.output_number);

        //setting the spinner items
        inputBase = new String[]{
                "Base 2 (Binary)",
                "Base 8 (Octal)",
                "Base 10 (Decimal)",
                "Base 12 (Duodecimal)",
                "Base 16 (Hexadecimal)"
        };

        outputBase = new String[]{
                "Base 2 (Binary)",
                "Base 8 (Octal)",
                "Base 10 (Decimal)",
                "Base 12 (Duodecimal)",
                "Base 16 (Hexadecimal)"
        };

        //populating spinners
        ArrayAdapter<String> inputAdapter = new ArrayAdapter<>(
                this, R.layout.spinner_layout, inputBase);
        inputAdapter.setDropDownViewResource(R.layout.spinner_layout);
        inputSpinner.setAdapter(inputAdapter);

        ArrayAdapter<String> outputAdapter = new ArrayAdapter<>(
                this, R.layout.spinner_layout, outputBase);
        inputAdapter.setDropDownViewResource(R.layout.spinner_layout);
        outputSpinner.setAdapter(outputAdapter);

        //getting string value from spinners
        inputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedInputBase = (String) parent.getItemAtPosition(position);
                GetOriginalBase(selectedInputBase);
                inputEditText.getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        outputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedOutputBase = (String) parent.getItemAtPosition(position);
                GetTargetBase(selectedOutputBase);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    //trying something out
    public void GetOriginalBase(String selectedInputBase) {

        switch (selectedInputBase) {
            case "Base 2 (Binary)": {
                originalBase = 2;
                break;
            }
            case "Base 8 (Octal)": {
                originalBase = 8;
                break;
            }
            case "Base 10 (Decimal)": {
                originalBase = 10;
                break;
            }
            case "Base 12 (Duodecimal)": {
                originalBase = 12;
                break;
            }
            case "Base 16 (Hexadecimal)": {
                originalBase = 16;
                break;
            }
        }


    }

    public void GetTargetBase(String selectedOutputBase) {

        switch (selectedOutputBase) {
            case "Base 2 (Binary)": {
                targetBase = 2;
                break;
            }
            case "Base 8 (Octal)": {
                targetBase = 8;
                break;
            }
            case "Base 10 (Decimal)": {
                targetBase = 10;
                break;
            }
            case "Base 12 (Duodecimal)": {
                targetBase = 12;
                break;
            }
            case "Base 16 (Hexadecimal)": {
                targetBase = 16;
                break;
            }
        }
    }


    public void Display(View view) {

        origNum = inputEditText.getText().toString();
        originalNum = Integer.parseInt(origNum);

        if (originalBase == 10) {
            targetNum = DTO.Convert(originalNum, targetBase);
            outputTextView.setText(targetNum);
        }
    }

    public void Reset(View view) {
        outputTextView.setText(null);
        inputEditText.setText(null);
    }
}
