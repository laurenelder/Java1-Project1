// Devin "Lauren" Elder
// Java 1 Week 1 Project

package com.elderDevin.linearlayoutproject;

import android.R.bool;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {
	
	// Element Inits and Global Variables
	
	EditText numInput;
    TextView byteDisplay;
    TextView kByteDisplay;
    TextView mByteDisplay;
    Button calcButton;
    boolean emptyField;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    // Calculation and Set Text Function
    
    public void calculate (int gigValue, int bValue, int kValue, int mValue) {
    	byteDisplay = (TextView)findViewById(R.id.byteView);
        kByteDisplay = (TextView)findViewById(R.id.kByteView);
        mByteDisplay = (TextView)findViewById(R.id.mByteView);
    	for(int i = 0; i < 4; i++) {
    		if(i == 1) {
    			int modifiedValue = gigValue * bValue;
    			byteDisplay.setText("Bytes: " + modifiedValue);
    		}
    		if(i == 2) {
    			int modifiedValue = gigValue * kValue;
    			kByteDisplay.setText("Kilobytes: " + modifiedValue);
    		}
			if(i == 3) {
				int modifiedValue = gigValue * mValue;
				mByteDisplay.setText("Megabytes: " + modifiedValue);
			}
    	}
    };
    
    // Onclick Function
    
    public void Clicked (View v) {
    	numInput = (EditText)findViewById(R.id.numInput);
    	byteDisplay = (TextView)findViewById(R.id.byteView);
        kByteDisplay = (TextView)findViewById(R.id.kByteView);
        mByteDisplay = (TextView)findViewById(R.id.mByteView);
    	String textValue = (numInput.getText().toString());
    	String textTrimmed = textValue.trim();
		// TODO Auto-generated method stub
		if (textTrimmed.isEmpty() || textTrimmed.length() == 0 || textTrimmed.equals("") || textTrimmed == null) {
			emptyField  = true;
		} else {
			emptyField = false;
		}
		if (emptyField == false) {
			int numValue = Integer.parseInt(numInput.getText().toString());
			int byteValue = getResources().getInteger(R.integer.byte_conversion);
			int kByteValue = getResources().getInteger(R.integer.kb_conversion);
			int mByteValue = getResources().getInteger(R.integer.mb_conversion);
			
			calculate (numValue, byteValue, kByteValue, mByteValue);
		}
    }
}


