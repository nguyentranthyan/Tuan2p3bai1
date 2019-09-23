package com.example.student.tuan2p3bai1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<NhanVien> nhanVienArrayList=null;
MyArrayAdapter adapter=null;
ListView lvnhanvien=null;
Button btnNhap;
ImageButton btnRemoveAll;
EditText txtma,txtten;
RadioGroup gendergroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNhap=findViewById(R.id.button_nhap);
        btnRemoveAll=findViewById(R.id.imageButton);
        txtma=findViewById(R.id.editText_manv);
        txtten=findViewById(R.id.editText_tennv);
        gendergroup=findViewById(R.id.radioGroup);
        lvnhanvien=findViewById(R.id.listview);
        nhanVienArrayList=new ArrayList<NhanVien>();
        adapter=new MyArrayAdapter(this,R.layout.my_item_layout,nhanVienArrayList);
        lvnhanvien.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulynhap();
            }
        });
        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyxoa();
            }
        });
    }

    private void xulynhap() {
        String ma=txtma.getText()+"";
        String ten=txtten.getText()+"";
        Boolean gioitinh=false;
        if(gendergroup.getCheckedRadioButtonId()==R.id.radioButton_nu){
            gioitinh=true;;
        }
        NhanVien nv=new NhanVien();
        nv.setId(ma);
        nv.setName(ten);
        nv.setGender(gioitinh);
        nhanVienArrayList.add(nv);
        adapter.notifyDataSetChanged();
        txtma.setText("");
        txtten.setText("");
        txtma.requestFocus();
    }
    private void xulyxoa() {
        for(int i = lvnhanvien.getChildCount()- 1; i>=0; i--){
            View v=lvnhanvien.getChildAt(i);
            CheckBox checkBox=v.findViewById(R.id.chk_item);
            if(checkBox.isChecked()){
                nhanVienArrayList.remove(i);
            }
        }
        adapter.notifyDataSetChanged();
    }


}
