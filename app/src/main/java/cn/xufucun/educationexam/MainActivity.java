package cn.xufucun.educationexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etStNm;

    private RadioGroup radioGroup1;
    private RadioButton rb12;

    private RadioGroup radioGroup2;
    private RadioButton rb21;

    private Checkable checkable31;
    private Checkable checkable32;
    private Checkable checkable33;
    private Checkable checkable34;

    private Checkable checkable41;
    private Checkable checkable42;
    private Checkable checkable43;
    private Checkable checkable44;

    private EditText editText5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etStNm = findViewById(R.id.et_st_nm);

        radioGroup1 = findViewById(R.id.rg1);
        rb12 = findViewById(R.id.rb12);

        radioGroup2 = findViewById(R.id.rg2);
        rb21 = findViewById(R.id.rb21);

        checkable31 = findViewById(R.id.cb31);
        checkable32 = findViewById(R.id.cb32);
        checkable33 = findViewById(R.id.cb33);
        checkable34 = findViewById(R.id.cb34);

        checkable41 = findViewById(R.id.cb41);
        checkable42 = findViewById(R.id.cb42);
        checkable43 = findViewById(R.id.cb43);
        checkable44 = findViewById(R.id.cb44);

        editText5 = findViewById(R.id.et_5_answer);

    }

    public void Submit(View view) {
        if(etName.getText().toString().isEmpty()){
            Toast.makeText(this, "姓名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if(etStNm.getText().toString().isEmpty()){
            Toast.makeText(this, "学号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String msg = "姓名：" + etName.getText().toString() + "\n"
                + "学号：" + etStNm.getText().toString() + "\n"
                + "得分：" + calculateScore();

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private int calculateScore() {

        int score = 0;


        if (radioGroup1.getCheckedRadioButtonId() == rb12.getId()){
            score = score +20;
        }

        if (radioGroup2.getCheckedRadioButtonId() == rb21.getId()){
            score = score +20;
        }

        boolean cb31 = checkable31.isChecked();
        boolean cb32 = checkable32.isChecked();
        boolean cb33 = checkable33.isChecked();
        boolean cb34 = checkable34.isChecked();

        boolean cb41 = checkable41.isChecked();
        boolean cb42 = checkable42.isChecked();
        boolean cb43 = checkable43.isChecked();
        boolean cb44 = checkable44.isChecked();

        String q5 = editText5.getText().toString();
        boolean question5 = q5.endsWith("那都不是事")||q5.endsWith("那都不叫事");

        if (cb31&cb32&cb33&cb34){
            score = score +20;
        }

        if (cb42&cb43&!cb41&!cb44){
            score = score +20;
        }

        if (question5){
            score = score +20;
        }

        return score;

    }


}
