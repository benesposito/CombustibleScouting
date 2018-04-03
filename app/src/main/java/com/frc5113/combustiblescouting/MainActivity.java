package com.frc5113.combustiblescouting;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.frc5113.combustiblescouting.enums.Alliance;
import com.frc5113.combustiblescouting.fragments.LegoNightJudging;
import com.frc5113.combustiblescouting.fragments.PitScouting;
import com.frc5113.combustiblescouting.fragments.StandScouting;

public class MainActivity extends AppCompatActivity
{
	Toolbar toolbar;
	ActionBar actionbar;
	DrawerLayout mDrawerLayout;
	NavigationView navigationView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);
		actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

		mDrawerLayout = findViewById(R.id.drawer_layout);
		navigationView = findViewById(R.id.nav_view);

		StandScouting firstFragment = new StandScouting();
		firstFragment.setArguments(getIntent().getExtras());
		getSupportFragmentManager().beginTransaction().add(R.id.fl_content, firstFragment).commit();

		navigationView.setNavigationItemSelectedListener(
				new NavigationView.OnNavigationItemSelectedListener()
				{
					@Override
					public boolean onNavigationItemSelected(@NonNull MenuItem item)
					{
						setFragment(item);
						item.setChecked(true);
						mDrawerLayout.closeDrawers();

						return true;
					}
				}
		);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case android.R.id.home:
				mDrawerLayout.openDrawer(GravityCompat.START);
				return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public void setFragment(MenuItem item)
	{
		Fragment fragment = null;

		switch(item.getItemId())
		{
			case R.id.stand_scouting:
				fragment = new StandScouting();
				break;
			case R.id.pit_scouting:
				fragment = new PitScouting();
				break;
			case R.id.lego_night_judging:
				fragment = new LegoNightJudging();
				break;
			default:
				fragment = new StandScouting();
		}

		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.fl_content, fragment).commit();
	}
}
