package com.morsemail.android.morsemail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Launcher activity listening the volume keys events
 * and decoding Morse code, which entered via volume keys
 */
public class MainActivity extends AppCompatActivity {

    /**
     * A char encoded in Morse code
     */
    private ArrayList<Integer> charCode;

    /**
     * Morse code
     */
    private MorseCode morseCode;

    /**
     * Mail input field
     */
    private EditText mOutEditText;

    /**
     * Mail send button
     */
    private Button mSendButton;

    /**
     * Flags of pressing volume buttons
     */
    private boolean isShortPress = false, isLongPress = false;

    /**
     * Array adapter for the message view
     */
    private ArrayAdapter<String> mMailArrayAdapter;

    /**
     * Mail history list view
     */
    private ListView mMailListView;

    Vibrator v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Don't show the keyboard at every startup
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        morseCode = new MorseCode();
        charCode = new ArrayList<>();
        mOutEditText = (EditText) findViewById(R.id.res_text_out);
        mSendButton = (Button) findViewById(R.id.button_send);
        mMailListView = (ListView) findViewById(R.id.mails);

        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        mMailArrayAdapter = new ArrayAdapter<>(this, R.layout.message);

        mMailListView.setAdapter(mMailArrayAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.res_text_out);
                String message = textView.getText().toString();
                if (message.length() > 0) {
                    sendEmail(message);
                    mMailArrayAdapter.add("Mail: " + message);
                    mOutEditText.setText("");
                }
            }
        });
    }

    private void sendEmail(String message){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hey, I wrote it in Morse code!");
        intent.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            event.startTracking();
            if (isLongPress) {
                isShortPress = false;
            } else {
                isShortPress = true;
                isLongPress = false;
            }

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            event.startTracking();
            if (isShortPress) {
                v.vibrate(100);
                charCode.add(0);
            }
            isShortPress = true;
            isLongPress = false;
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            event.startTracking();
            if (isShortPress) {
                v.vibrate(100);
                String code = morseCode.getChar(charCode);
                mOutEditText.append(code);
                charCode.clear();
            }
            isShortPress = true;
            isLongPress = false;
            return true;
        }

        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            v.vibrate(200);
            charCode.add(1);
            isShortPress = false;
            isLongPress = true;
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            v.vibrate(200);
            mOutEditText.append(" ");
            charCode.clear();
            isShortPress = false;
            isLongPress = true;
            return true;
        }

        return false;
    }

}
