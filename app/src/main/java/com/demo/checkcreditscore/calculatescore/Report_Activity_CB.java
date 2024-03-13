package com.demo.checkcreditscore.calculatescore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.demo.checkcreditscore.Glob;
import com.demo.checkcreditscore.R;
import com.demo.checkcreditscore.calculatescore.common.DataKeeper;
import com.demo.checkcreditscore.calculatescore.common.second_btn_class;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Report_Activity_CB extends AppCompatActivity {
    TextView report_text;
    Button see_full_report2;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_report_2);
//        new AdAdmob(this);
//        AdAdmob.FullscreenAd_Counter(this);
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(8192, 8192);
        TextView textView = (TextView) findViewById(R.id.report_text);
        this.report_text = textView;
        textView.setText("1." + getResources().getString(R.string.last_negative_item) + "  :-  " + second_btn_class.f1 + "\n\n2." + getResources().getString(R.string.count_following_accounts) + "\n\t\t1." + getResources().getString(R.string.credit_cards) + " :- " + second_btn_class.f2 + "\n2." + getResources().getString(R.string.mortgages) + " :- " + second_btn_class.f3 + "\n3." + getResources().getString(R.string.retail_finances) + " :- " + second_btn_class.f4 + "\n4." + getResources().getString(R.string.auto_loans) + " :- " + second_btn_class.f5 + "\n5." + getResources().getString(R.string.student_loans) + " :- " + second_btn_class.f6 + "\n6." + getResources().getString(R.string.other_loans) + " :- " + second_btn_class.f7 + "\n\n3." + getResources().getString(R.string.all_credit_limits) + "  :-  " + second_btn_class.f8 + "\n\n4." + getResources().getString(R.string.recent_balances) + "  :-  " + second_btn_class.f9 + "\n\n5." + getResources().getString(R.string.apply_credit) + "  :-  " + second_btn_class.f10 + "\n\n6." + getResources().getString(R.string.first_open_oldest_active) + "  :-  " + second_btn_class.f11 + "\n\n\n\t\t\t\t\t" + getResources().getString(R.string.your_score) + "  :-  " + DataKeeper.getInstance().getScore() + "\n\n");
        Button button = (Button) findViewById(R.id.see_full_report2);
        this.see_full_report2 = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Report_Activity_CB report_Activity_CB = Report_Activity_CB.this;
                report_Activity_CB.createandDisplayPdf("1." + Report_Activity_CB.this.getResources().getString(R.string.last_negative_item) + "  :-  " + second_btn_class.f1 + "\n\n2." + Report_Activity_CB.this.getResources().getString(R.string.count_following_accounts) + "\n\t\t1." + Report_Activity_CB.this.getResources().getString(R.string.credit_cards) + " :- " + second_btn_class.f2 + "\n\t\t2." + Report_Activity_CB.this.getResources().getString(R.string.mortgages) + " :- " + second_btn_class.f3 + "\n\t\t3." + Report_Activity_CB.this.getResources().getString(R.string.retail_finances) + " :- " + second_btn_class.f4 + "\n\t\t4." + Report_Activity_CB.this.getResources().getString(R.string.auto_loans) + " :- " + second_btn_class.f5 + "\n\t\t5." + Report_Activity_CB.this.getResources().getString(R.string.student_loans) + " :- " + second_btn_class.f6 + "\n\t\t6." + Report_Activity_CB.this.getResources().getString(R.string.other_loans) + " :- " + second_btn_class.f7 + "\n\n3." + Report_Activity_CB.this.getResources().getString(R.string.all_credit_limits) + "  :-  " + second_btn_class.f8 + "\n\n4." + Report_Activity_CB.this.getResources().getString(R.string.recent_balances) + "  :-  " + second_btn_class.f9 + "\n\n5." + Report_Activity_CB.this.getResources().getString(R.string.apply_credit) + "  :-  " + second_btn_class.f10 + "\n\n6." + Report_Activity_CB.this.getResources().getString(R.string.first_open_oldest_active) + "  :-  " + second_btn_class.f11 + "\n\n\n\t\t\t\t\t" + Report_Activity_CB.this.getResources().getString(R.string.your_score) + "  :-  " + DataKeeper.getInstance().getScore() + "\n\n");
            }
        });
    }

    public void createandDisplayPdf(String str) {
        Document document = new Document();
        try {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/PDF");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "mycreditreport.pdf");
            PdfWriter.getInstance(document, new FileOutputStream(file2));
            document.open();
            Paragraph paragraph = new Paragraph(str);
            Font font = new Font(Font.FontFamily.COURIER);
            paragraph.setAlignment(1);
            paragraph.setFont(font);
            document.add(paragraph);
            share(file2);
        } catch (DocumentException e) {
            Log.e("PDFCreator", "DocumentException:" + e);
        } catch (IOException e2) {
            Log.e("PDFCreator", "ioException:" + e2);
        } catch (Throwable th) {
            document.close();
            throw th;
        }
        document.close();
    }

    private void share(File file) {
        Uri uriForFile = FileProvider.getUriForFile(this, "stylistapp.creditscore.checkcredit.provider", file);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/pdf");
        intent.putExtra("android.intent.extra.TEXT", getString(R.string.app_name) + " Created By :" + Glob.app_link);
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        startActivity(Intent.createChooser(intent, "share Image using"));
    }
}
