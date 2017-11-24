package com.example.arturmusayelyan.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class GevTaskExample extends AppCompatActivity {
    ImageView image;
    String selectedImagePath;
    String fileManagerString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gev_task_example);
        image = findViewById(R.id.imageView1);

    }

    public void onClick(View view) {
        if (view.getId() == R.id.getImage_btn) {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                Uri selectedImageUri = data.getData();
                fileManagerString=selectedImageUri.getPath();
                selectedImagePath=getPath(selectedImageUri);
                if (selectedImageUri != null) {
                    image.setImageURI(selectedImageUri);
                } else {
                    Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    public String getPath(Uri uri){
        String[] projection={MediaStore.Images.Media.DATA};
        Cursor cursor=managedQuery(uri,projection,null,null,null);
        if(cursor!=null){
            int column_index=cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        else return null;
    }

}
