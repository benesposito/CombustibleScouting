package com.frc5113.combustiblescouting.fragments;

import android.icu.text.LocaleDisplayNames;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.frc5113.combustiblescouting.PitForm;
import com.frc5113.combustiblescouting.PitFormItem;
import com.frc5113.combustiblescouting.R;
import com.frc5113.combustiblescouting.enums.DriveTrain;

import java.util.ArrayList;

/**
 * Created by espo1 on 4/1/2018.
 */

public class PitScouting extends Fragment
{
	EditText mTeamNumber;
	Spinner mDriveTrain;
	CheckBox mArm;
	CheckBox mVisionRecognition;
	Button mSubmit;

	ArrayList<PitForm> forms = new ArrayList<PitForm>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment

		return inflater.inflate(R.layout.pit_scouting, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		mTeamNumber = (EditText) view.findViewById(R.id.team_number);
		mDriveTrain = (Spinner) view.findViewById(R.id.drivetrain_spinner);
		mArm = ((PitFormItem) view.findViewById(R.id.arm)).getCheckBox();
		mVisionRecognition = ((PitFormItem) view.findViewById(R.id.vision_recognition)).getCheckBox();
		mSubmit = (Button) view.findViewById(R.id.submit_pit_form);

		mSubmit.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				forms.add(new PitForm(Integer.parseInt(mTeamNumber.getText().toString()), getDriveTrainEnum(mDriveTrain.getSelectedItem().toString()), mArm.isChecked(), mVisionRecognition.isChecked()));

				mTeamNumber.setText("");
				mDriveTrain.setSelection(0);
				mArm.setChecked(false);
				mVisionRecognition.setChecked(false);
			}
		});
	}

	private DriveTrain getDriveTrainEnum(String selected)
	{
		DriveTrain driveTrain;

		switch(selected)
		{
			case "Tank Drive":
				return DriveTrain.TANK_DRIVE;
			case "H Drive":
				return DriveTrain.H_DRIVE;
			case "Mecanum Drive":
				return DriveTrain.MECANUM_DRIVE;
			case "Swerve Drive":
				return DriveTrain.SWERVE_DRIVE;
			default:
				return DriveTrain.TANK_DRIVE;
		}
	}
}
