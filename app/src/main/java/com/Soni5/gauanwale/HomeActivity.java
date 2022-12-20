package com.Soni5.gauanwale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.Soni5.gauanwale.Fragment.AddFragment;
import com.Soni5.gauanwale.Fragment.HomeFragment;
import com.Soni5.gauanwale.Fragment.ProfileFragment;
import com.Soni5.gauanwale.databinding.ActivityHomeBinding;
import com.Soni5.gauanwale.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    String Frag;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        binding.bottomnavigation.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home:
                    if (Objects.equals(Frag, "Home")) {
                        //  Toast.makeText(this, "Khuli hoyi aa pra", Toast.LENGTH_SHORT).show();

                    } else {
                        replacefragment(new HomeFragment());
                        Frag = "Home";

                    }
                    break;


                case R.id.search:

                    if (Objects.equals(Frag, "Search")) {
                        // Toast.makeText(this, "Khuli hoyi aa pra", Toast.LENGTH_SHORT).show();

                    } else {
                        replacefragment(new AddFragment());
                        Frag = "Search";

                    }
                    break;


                case R.id.cam:

                    if (Objects.equals(Frag, "Cam")) {
                        //  Toast.makeText(this, "Khuli hoyi aa pra", Toast.LENGTH_SHORT).show();

                    } else {
                        replacefragment(new ProfileFragment());
                        Frag = "Cam";

                    }
                    break;


            }

            return true;
        });

    }


    private  void replacefragment(Fragment fragment)
    {
        FragmentManager fragmentmanger = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentmanger.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

}