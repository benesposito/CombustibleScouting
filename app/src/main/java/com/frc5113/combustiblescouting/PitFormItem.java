package com.frc5113.combustiblescouting;

import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.Visibility;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Attr;

/**
 * Created by espo1 on 4/2/2018.
 */

public class PitFormItem extends RelativeLayout
{
	TextView mTextView;
	CheckBox mCheckBox;

	String text;

	public PitFormItem(Context context)
	{
		this(context, null);
	}

	public PitFormItem(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	public PitFormItem(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);

		LayoutInflater.from(getContext()).inflate(R.layout.pit_form_item, this);
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PitFormItem);

		text = a.getString(R.styleable.PitFormItem_text);
	}

	@Override
	protected void onFinishInflate()
	{
		super.onFinishInflate();

		mTextView = (TextView) this.findViewById(R.id.pit_form_item_text);
		mCheckBox = (CheckBox) this.findViewById(R.id.pit_form_check_box);

		mTextView.setVisibility(VISIBLE);
		mCheckBox.setVisibility(VISIBLE);

		mTextView.setText(text);
	}

	public CheckBox getCheckBox()
	{
		return mCheckBox;
	}
}
