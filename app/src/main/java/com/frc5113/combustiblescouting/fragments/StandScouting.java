package com.frc5113.combustiblescouting.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.frc5113.combustiblescouting.MainActivity;
import com.frc5113.combustiblescouting.R;
import com.frc5113.combustiblescouting.enums.Alliance;

/**
 * Created by espo1 on 4/1/2018.
 */

public class StandScouting extends Fragment
{
	EditText mTeamNumber;
	Button mRedAlliance;
	Button mBlueAlliance;

	Alliance chosenAlliance;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment

		return inflater.inflate(R.layout.stand_scouting, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		mTeamNumber = (EditText) view.findViewById(R.id.team_number);
		mRedAlliance = (Button) view.findViewById(R.id.red_alliance);
		mBlueAlliance = (Button) view.findViewById(R.id.blue_alliance);

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
