package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class TaskActivity extends AppCompatActivity {
    private int n = 0;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==  1) {
            if(resultCode == RESULT_OK) {
                return;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_to_solve);
        Button back = (Button) findViewById(R.id.button26);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        final String[] qust = new String[1];
        final String[] ans = new String[1];
        qust[0] = getResources().getString(R.string.tut);
        if(FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), 1);
        }

        Button next = (Button) findViewById(R.id.nexttask);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Query query=FirebaseDatabase.getInstance().getReference().orderByChild("number").equalTo(n);
                FirebaseListOptions<QnA> options = new FirebaseListOptions.Builder<QnA>().setQuery(query, QnA.class).build();
                FirebaseListAdapter<QnA> adapter = new FirebaseListAdapter<QnA>(options) {
                    @Override
                    protected void populateView(View v, QnA model, int position) {
                        qust[0] = model.question;
                        ans[0] = model.answer;
                        ((TextView) findViewById(R.id.textView2)).setText(qust[0]);
                        n += 1;
                    }
                };
            }
        });
        Button check = (Button) findViewById(R.id.checktask);
        EditText editText = (EditText)findViewById(R.id.answer);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans[0] == editText.getText().toString()) {
                    ((TextView) findViewById(R.id.textView3)).setText("OK");
                }
                else {
                    ((TextView) findViewById(R.id.textView3)).setText("BAD");
                }
            }
        });
    }
}
