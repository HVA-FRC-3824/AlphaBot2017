package org.usfirst.frc3824.AlphaBot2017;

public class Target {
	private boolean mValid;
	private int mFrameIndex;
	private int mTargetType;
	private int mXCenter;
	private int mYCenter;
	private int mHeight;
	
	// ------------
	// C Structure:
	//-------------
	// struct targetInformation {
	//		short frameNum;
	//		short targetXInt;
	//		short targetYInt;
	//		short targetHeightInt;
	//		short targetXDecimal;
	//		short targetYDecimal;
	//		short targetHeightDecimal;
	//		char  targetNum;
	//	};
	
	
	Target()
	{
		mFrameIndex = 0;
		mTargetType = 0;
		mXCenter = 0;
		mYCenter = 0;
		mHeight = 0;
	}
	
	Target(byte[] udpBuf)
	{
		if(udpBuf[0] == 0)
		{
			mValid       = true;
			mTargetType  = (int) (udpBuf[1] & 0xFF);
			mFrameIndex  = ((int) (udpBuf[2] & 0xFF) * 256) + ((int) (udpBuf[3] & 0xFF) );	// treat the low byte as unsigned
			mXCenter     = ((int) (udpBuf[4] & 0xFF) * 256) + ((int) (udpBuf[5] & 0xFF) );;
			mYCenter     = ((int) (udpBuf[6] & 0xFF) * 256) + ((int) (udpBuf[7] & 0xFF) );
			mHeight      = ((int) (udpBuf[8] & 0xFF) * 256) + ((int) (udpBuf[9] & 0xFF) );
		}
		else
		{
			mValid       = false;
		}
	}
	
	boolean isValid()
	{
		return mValid;
	}
		
	int getFrameIndex()
	{
		return mFrameIndex;
	}
	
	int getTargetType()
	{
		return mTargetType;
	}
	
	double getXCenter()
	{
		return mXCenter;
	}
	
	double getYCenter()
	{
		return mYCenter;
	}
	
	double getHeight()
	{
		return mHeight;
	}
}
