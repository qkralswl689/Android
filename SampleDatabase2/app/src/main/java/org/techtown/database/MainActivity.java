package org.techtown.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    TextView textView;

    DatabaseHelper dbHelper;
    SQLiteDatabase database;

    String tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String databaseName = editText.getText().toString();
                createDatabase(databaseName);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableName = editText2.getText().toString();

                createTable(tableName);

                insertRecord();

            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeQuery();
            }
        });
    }

    private void executeQuery() {
        println("executeQuery 호출됨");

        // SQL 실행하고 Cursor 객체 반환받기
        Cursor cursor = database.rawQuery("select _id, name, age, mobile from emp", null);
        int recoredCount = cursor.getCount();
        println("레코드 개수 : " + recoredCount);

        for(int i = 0; i < recoredCount; i++){
            // 다음 결과 레코드로 넘어가기
            cursor.moveToNext();
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String mobile = cursor.getString(3);

            println("레코드#" + i + " : " + id + ", " + name + ", " + age + ", " + mobile);
        }
        cursor.close();
    }

    private void createDatabase(String name)
    {
        println("creageDatabase 호출됨");

     /*   // DB를 만들기 위한 메서드 실행
        database = openOrCreateDatabase(name, MODE_PRIVATE, null);*/
        
        // DatabaseHelper 객체 생성하고 SQLiteDatabase 객체 참조하기
        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();

        println("DB 생성" + name);
    }
    private void createTable(String name){
        println("createTable 호출됨");

        if(database == null){
            println("DB를 먼저 생성하세요" );
            return;
        }

        // 테이블을 만들기 위한 SQL문 실행하기
        database.execSQL("create table if not exists " + name + "("
        + " _id integer PRIMARY KEY autoincrement, "
        + " name text, "
        + " age integer, "
        + " mobile text)");

        println("테이블 생성" + name);
    }

    private void insertRecord(){

        println("insertRecord 호출" );

        if(database == null){
            println("테이블을 먼저 생성하세요" );
            return;
        }
        database.execSQL("insert into " + tableName
                + "(name, age, mobile) "
                + " values "
                + "('John', 20, '010-1000-1000')");

        println("레코드 추가");
    }

    public void println(String data){
        textView.append(data + "\n");
    }
}