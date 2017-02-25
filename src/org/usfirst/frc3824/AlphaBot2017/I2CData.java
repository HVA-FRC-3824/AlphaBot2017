package org.usfirst.frc3824.AlphaBot2017;
import java.nio.ByteBuffer;

import edu.wpi.first.wpilibj.I2C;


public class I2CData extends I2C{
	private int mDevAddress;
	private static I2CData instance = null;
	static Port m_port;
	static int m_deviceAddress;
	public static void config(Port port, int deviceAddress){
		instance = null;
		m_port = port;
		m_deviceAddress = deviceAddress;
		
	}
	public static I2CData getInstance(){
		if(instance == null){
			instance = new I2CData(m_port, m_deviceAddress);
		}
		return instance;
	}
	private I2CData(Port port, int deviceAddress) {
		super(port, deviceAddress);
		mDevAddress = deviceAddress;
		// TODO Auto-generated constructor stub
	}
		
	public void sendDouble(int id, double data, String descriptor){		
		byte[] ID = new byte[1];
		ID[0] = (byte)(id);
		writeBulk(ID);
		
		//Processes the data and sends it
		data *= 10;
		short shortdata = (short)data;
		byte[] Data = new byte[2];
		for (int i = 0; i < 2; i++) {
			Data[i] = (byte) ((shortdata>>((1-i)*8))&0xFF);
		}
		
//		//Write a empty byte to make sure spacing is right for Arduino
//		if(data<256){
//			int filler = 0;
//			byte[] Filler = new
//			writeBulk(filler);
//		}
		writeBulk(Data);
		
		
		
		byte[] Decriptor = descriptor.getBytes();
		writeBulk(Decriptor);

		
		
		
	}
	
	
	
	
	

}
