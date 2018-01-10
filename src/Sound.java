import java.io.File;
import java.util.LinkedList;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Sound
{	
	String path = new String("musics\\");
	String  file = new String("nor.mid");
	Sequence seq;
    Sequencer midi;//定义播放器
	boolean sign;
	
	void loadSound()
	{
		try 
		{
            seq = MidiSystem.getSequence(new File(path+file));
            midi = MidiSystem.getSequencer();//加载默认播放器
            midi.open();
            midi.setSequence(seq);
			midi.start();
			midi.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        }
        catch (Exception ex) 
		{
        	ex.printStackTrace();//异常处理
        }
		sign = true;
	}
	
	void mystop()//停止播放
	{
		midi.stop();
		midi.close();
		sign = false;
	}
	
	boolean isplay()
	{
		return sign;
	}
	
	void setMusic(String e)
	{
		file = e;
	}
}

