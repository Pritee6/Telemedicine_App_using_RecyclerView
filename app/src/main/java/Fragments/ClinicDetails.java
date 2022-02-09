package Fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.tele_medicine_doctor.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ClinicDetails extends Fragment {

    private Button btn_upload_document, submit_Documents;

    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int REQUEST_GALLERY = 200;
    private long downloadId;

    TextView txt_file_name;
    String file_path = null;
    ProgressBar progress_bar;
    EditText edt_ClinicName, edt_ClinicAddress, edt_ClinicFees, edt_ClinicTiming;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.clinic_details, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Clinic Details");

        txt_file_name = (TextView) view.findViewById(R.id.file_name);
        edt_ClinicName = (EditText) view.findViewById(R.id.edt_ClinicName);
        edt_ClinicAddress = (EditText) view.findViewById(R.id.edt_ClinicAddress);
        edt_ClinicFees = (EditText) view.findViewById(R.id.edt_ClinicFees);
        edt_ClinicTiming = (EditText) view.findViewById(R.id.edt_ClinicTiming);

        submit_Documents = (Button) view.findViewById(R.id.submit_Documents);
        btn_upload_document = (Button) view.findViewById(R.id.btn_upload_document);

        submit_Documents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= 23) {
                    if (checkPermission()) {
                        filePicker();
                    } else {
                        requestPermission();
                    }
                } else {
                    filePicker();
                }
            }
        });

        progress_bar = (ProgressBar) view.findViewById(R.id.progress_bar);
        btn_upload_document = (Button) view.findViewById(R.id.btn_upload_document);
        txt_file_name = (TextView) view.findViewById(R.id.file_name);

        btn_upload_document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (file_path != null) {
                    UploadFile();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Please Select File First", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void UploadFile() {
        UploadTask uploadTask = new UploadTask();
        uploadTask.execute(new String[]{file_path});
    }

    private void filePicker() {

        Toast.makeText(getActivity().getApplicationContext(), "File Picker Call", Toast.LENGTH_SHORT).show();

        Intent opengallery = new Intent(Intent.ACTION_PICK);
        opengallery.setType("image/*");
        startActivityForResult(opengallery, REQUEST_GALLERY);
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(getActivity().getApplicationContext(), "Please Give Permission to Upload File", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getActivity().getApplicationContext(), "Permission Successfull", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Permission Failed", Toast.LENGTH_SHORT).show();
                }
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_GALLERY && resultCode == Activity.RESULT_OK) {
            String filePath = getRealPathFromUri(data.getData(), getActivity());
            Log.d("File Path : ", " " + filePath);
            //now we will upload the file
            //lets import okhttp first
            this.file_path = filePath;

            File file = new File(filePath);
            txt_file_name.setText(file.getName());

        }
    }
    public String getRealPathFromUri(Uri uri, Activity activity) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = activity.getContentResolver().query(uri, proj, null, null, null);
        if (cursor == null) {
            return uri.getPath();
        } else {
            cursor.moveToFirst();
            int id = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(id);
        }
    }


    public class UploadTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progress_bar.setVisibility(View.GONE);
            if (s.equalsIgnoreCase("true")) {
                Toast.makeText(getActivity().getApplicationContext(), "File uploaded", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "Failed Upload", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress_bar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            if (uploadFile(strings[0])) {
                return "true";
            } else {
                return "failed";
            }
        }
        private boolean uploadFile(String path){
            File file=new File(path);
            try{
                RequestBody requestBody=new MultipartBody.Builder().setType(MultipartBody.FORM)
                        .addFormDataPart("files",file.getName(),RequestBody.create(MediaType.parse("image/*"),file))
                        .addFormDataPart("some_key","some_value")
                        .addFormDataPart("submit","submit")
                        .build();

                Request request=new Request.Builder()
                        .url("http://192.168.0.2/project/upload.php")
                        .post(requestBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                    }
                });
                return true;
            }
            catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
    }

}
