package com.frc5113.combustiblescouting;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class PitScouting extends AppCompatActivity
{
	Toolbar toolbar;
	ActionBar actionbar;
	DrawerLayout mDrawerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pit_scouting);

		toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);
		actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

		mDrawerLayout = findViewById(R.id.drawer_layout);


	}
}
