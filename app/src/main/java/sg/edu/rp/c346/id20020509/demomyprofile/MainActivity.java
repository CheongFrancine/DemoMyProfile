package sg.edu.rp.c346.id20020509.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Step 1a: Get the user input from the EditText and store it in a variable
        String gpa = etGPA.getText().toString();
        float fgpa = 0f;
        if (gpa.length() > 0) {
            fgpa = Float.parseFloat(gpa);
        }

        // Step 1b: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        // Step 1c: Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefeditor = prefs.edit();

        // Step 1d: Add the key-value pair
        prefeditor.putString("name", etName.getText().toString());
        prefeditor.putFloat("gpa", fgpa); // save GPA

        // Step 1e: Call commit() to save the changes into SharedPreferences
        prefeditor.commit();
    }


    @Override
    protected void onResume() {
        super.onResume();

        // Step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        // Step 2b: Retrieve the saved data from the SharedPreferences object
        String name = prefs.getString("name", "");
        float gpa = prefs.getFloat("gpa",0f); // retrieve GPA

        // Step 2c: Update the UI element with the value
        etName.setText(name);
        etGPA.setText(gpa + "");
    }

}