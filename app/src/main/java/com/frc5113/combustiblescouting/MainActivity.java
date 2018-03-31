package com.frc5113.combustiblescouting;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
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

public class MainActivity extends AppCompatActivity
{
	Toolbar toolbar;
	ActionBar actionbar;
	DrawerLayout mDrawerLayout;
	NavigationView navigationView;

	EditText mTeamNumber;
	Button mRedAlliance;
	Button mBlueAlliance;

	Alliance chosenAlliance;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Intent pitScouting = new Intent(this, PitScouting.class);

		toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);
		actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

		mDrawerLayout = findViewById(R.id.drawer_layout);
		navigationView = findViewById(R.id.nav_view);

		mTeamNumber = (EditText) findViewById(R.id.team_number);
		mRedAlliance = (Button) findViewById(R.id.red_alliance);
		mBlueAlliance = (Button) findViewById(R.id.blue_alliance);

		navigationView.setNavigationItemSelectedListener(
				new NavigationView.OnNavigationItemSelectedListener()
				{
					@Override
					public boolean onNavigationItemSelected(@NonNull MenuItem item)
					{
						item.setChecked(true);
						mDrawerLayout.closeDrawers();

						startActivity(pitScouting);

						return true;
					}
				}
		);

		chosenAlliance = Alliance.NONE;

		mRedAlliance.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				mRedAlliance.setBackgroundResource(R.drawable.selected_red_rectangle);
				mBlueAlliance.setBackgroundResource(R.drawable.blue_rectangle);
				chosenAlliance = Alliance.RED_ALLIANCE;
			}
		});

		mBlueAlliance.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				mBlueAlliance.setBackgroundResource(R.drawable.selected_blue_rectangle);
				mRedAlliance.setBackgroundResource(R.drawable.red_rectangle);
				chosenAlliance = Alliance.BLUE_ALLIANCE;
			}
		});
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
}
