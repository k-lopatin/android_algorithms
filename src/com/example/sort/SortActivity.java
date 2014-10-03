package com.example.sort;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SortActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }


    public void sortClick(View view) {
        EditText numbersText = (EditText) findViewById(R.id.unSortedNumbers);
        EditText sortedNumbersText = (EditText) findViewById(R.id.sortedNumbers);
        String numbersStr[] = numbersText.getText().toString().split("\\s+");
        int numbers[] = new int[numbersStr.length];
        int i = 0;
        for (String s : numbersStr) {
            try {
                numbers[i] = Integer.parseInt(s);
            } catch (NumberFormatException nfe) {

            }
            i++;
        }
        Sort.quickSort(numbers, 0, numbers.length - 1);
        String sortedStr = "";
        for (int n : numbers) {
            sortedStr += n;
            sortedStr += " ";
        }

        sortedNumbersText.setText(sortedStr);
    }

}
