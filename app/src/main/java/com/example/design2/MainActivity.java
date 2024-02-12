package com.example.design2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.design2.ui.dashboard.DashboardFragment;
import com.example.design2.ui.home.HomeFragment;
import com.example.design2.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.design2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding);
        start = findViewById(R.id.button);
        start.setOnClickListener(this::OnClick);
    }
    private void OnClick(View v)
    {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        final int[] TAB_TITLES = new int[]{R.string.title_home, R.string.title_dashboard, R.string.title_notifications};
        getItem(TAB_TITLES.length);
    }

    public Fragment getItem(int position)
    {

        if(position == 0)
        {
            DashboardFragment tab1 = new DashboardFragment();
            return tab1;
        }
        if(position == 1)
        {
            HomeFragment tab2 = new HomeFragment();
            return tab2;
        }
        if(position == 2)
        {
            NotificationsFragment tab3 = new NotificationsFragment();
            return tab3;
        }

        return null;
    }

}