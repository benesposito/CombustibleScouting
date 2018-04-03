package com.frc5113.combustiblescouting;

import com.frc5113.combustiblescouting.enums.DriveTrain;

/**
 * Created by espo1 on 4/3/2018.
 */

public class PitForm
{
	private int teamNumber;
	private DriveTrain driveTrain;
	private boolean hasArm;
	private boolean hasVisionRecognition;

	public PitForm(int teamNumber, DriveTrain driveTrain, boolean hasArm, boolean hasVisionRecognition)
	{
		this.teamNumber = teamNumber;
		this.driveTrain = driveTrain;
		this.hasArm = hasArm;
		this.hasVisionRecognition = hasVisionRecognition;
	}
}
