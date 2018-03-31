package com.frc5113.combustiblescouting;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.frc5113.combustiblescouting.enums.Alliance;

public class MainActivity extends FragmentActivity
{
	EditText mTeamNumber;
	Button mRedAlliance;
	Button mBlueAlliance;

	Alliance chosenAlliance;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTeamNumber = (EditText) findViewById(R.id.team_number);
		mRedAlliance = (Button) findViewById(R.id.red_alliance);
		mBlueAlliance = (Button) findViewById(R.id.blue_alliance);

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
}
