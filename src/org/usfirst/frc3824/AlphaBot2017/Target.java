package org.usfirst.frc3824.AlphaBot2017;

public class Target {
	private int mFrameIndex;
	private int mTargetType;
	private double mXCenter;
	private double mYCenter;
	private double mHeight;
	
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
		mFrameIndex = ((int) udpBuf[0] * 256) + ((int) udpBuf[1]);
		mTargetType = (int) udpBuf[14];
		mXCenter = (double) (((int) udpBuf[2] * 256) + ((int) udpBuf[3])) + ( (double) (((int) udpBuf[8] * 256) + ((int) udpBuf[9])) / 10.0 );
		mYCenter = (double) (((int) udpBuf[4] * 256) + ((int) udpBuf[5])) + ( (double) (((int) udpBuf[10] * 256) + ((int) udpBuf[11])) / 10.0 );
		mHeight = (double) (((int) udpBuf[6] * 256) + ((int) udpBuf[7])) + ( (double) (((int) udpBuf[12] * 256) + ((int) udpBuf[13])) / 10.0 );
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
