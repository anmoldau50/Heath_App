package com.example.heath_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {


    private String[][] DDfamilyphysician = {
            {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
            {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No: 7898989898", "900"},
            {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No: 8898989898", "300"},
            {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No : 9898000000", "500"},
            {"Doctor Name : Ashok Panda", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No: 7798989898", "800"}
    };

    private String[][] DDDentist = {
            {"Doctor Name : Neelam Patil", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
            {"Doctor Name : Swati Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No: 7898989898", "900"},
            {"Doctor Name : Neeraja Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No: 8898989898", "300"},
            {"Doctor Name : Mayuri Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No: 9898000000", "500"},
            {"Doctor Name : Minakshi Panda", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No: 7798989898", "800"}
    };

    private String[][] DDsurgeon = {
            {"Doctor Name : Seema Patil", "Hospital Address : Pimpri", "Exp : 4yrs", "Mobile No: 9898989898", "200"},
            {"Doctor Name : Pnkaj Parab", "Hospital Address : Nigdi", "Exp : 5yrs", "Mobile No: 7898989898", "300"},
            {"Doctor Name : Monish Jain", "Hospital Address : Pune", "Exp : 7yrs", "Mobile No : 8898989898", "300"},
            {"Doctor Name : Vishal Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No: 9898000000", "500"},
            {"Doctor Name : Shrikant Panda", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No: 7798989898", "600"}
    };

    private String[][] DDcardiologist = {
            {"Doctor Name : Rohan Sharma", "Hospital Address : Andheri", "Exp : 10yrs", "Mobile No: 9123456789", "700"},
            {"Doctor Name : Meera Joshi", "Hospital Address : Bandra", "Exp : 12yrs", "Mobile No: 9234567890", "800"},
            {"Doctor Name : Anil Kapoor", "Hospital Address : Juhu", "Exp : 8yrs", "Mobile No: 9345678901", "600"},
            {"Doctor Name : Priya Singh", "Hospital Address : Malad", "Exp : 5yrs", "Mobile No: 9456789012", "500"},
            {"Doctor Name : Vikram Rao", "Hospital Address : Borivali", "Exp : 15yrs", "Mobile No: 9567890123", "900"}
    };

    private String[][] DDdietician = {
            {"Doctor Name : Arjun Mehta", "Hospital Address : Vashi", "Exp : 9yrs", "Mobile No: 9678901234", "750"},
            {"Doctor Name : Kavita Nair", "Hospital Address : Thane", "Exp : 11yrs", "Mobile No: 9789012345", "850"},
            {"Doctor Name : Rajesh Gupta", "Hospital Address : Dadar", "Exp : 6yrs", "Mobile No: 9890123456", "650"},
            {"Doctor Name : Sneha Iyer", "Hospital Address : Chembur", "Exp : 4yrs", "Mobile No: 9901234567", "550"},
            {"Doctor Name : Manish Patel", "Hospital Address : Ghatkopar", "Exp : 13yrs", "Mobile No: 9012345678", "950"}
    };


    TextView tv;
    Button bt;

    String[][] doctordetails={};

    HashMap <String,String> item;
    ArrayList list;
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        tv=findViewById(R.id.doctorDDCategory);
        bt=findViewById(R.id.buttonLTGoToCart);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Dentist")==0){
            doctordetails=DDDentist;
        }
        else

        if(title.compareTo("Dietician")==0){
            doctordetails=DDdietician;
        }
        else

        if(title.compareTo("Family Physician")==0){
            doctordetails=DDfamilyphysician;
        }
        else

        if(title.compareTo("Surgeon")==0){
            doctordetails=DDsurgeon;
        }
        else{
            doctordetails=DDcardiologist;
        }


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });


        list= new ArrayList();

        for(int i=0;i<doctordetails.length;i++){
            item= new HashMap<String,String>();
            item.put("line1",doctordetails[i][0]);
            item.put("line2",doctordetails[i][1]);
            item.put("line3",doctordetails[i][2]);
            item.put("line4",doctordetails[i][3]);
            item.put("line5","Const Fees "+doctordetails[i][4]+"/-");
            list.add(item);
        }

        sa= new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );

        ListView lst=findViewById(R.id.listViewLTD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it= new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("line1",title);
                it.putExtra("line2",doctordetails[i][0]);
                it.putExtra("line3",doctordetails[i][1]);
                it.putExtra("line4",doctordetails[i][3]);
                it.putExtra("line5",doctordetails[i][4]);
                startActivity(it);

            }
        });

    }
}