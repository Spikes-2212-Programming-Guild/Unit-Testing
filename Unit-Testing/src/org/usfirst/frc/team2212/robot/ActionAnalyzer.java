package org.usfirst.frc.team2212.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class ActionAnalyzer {

	
	public ActionAnalyzer(Joystick[]joysticks, SpeedController []motors){
		
		for(Joystick current: joysticks){
			comingInput(current);
		}
		
		int currentPort = 0;
		
		for(SpeedController current: motors){
			comingOutput(current, currentPort);
			currentPort++;
		}
		
	}
	
	public void comingInput(Joystick joystick){
		JoystickButton button;
		for(int i = 0; i< joystick.getButtonCount(); i++){
			button = new JoystickButton(joystick, i);
			if(button.get()){
				System.out.println("Button number "+ i +" was pressed.");
			}
		}
		if(joystick.getX() != 0 || joystick.getY() != 0){
			System.out.println("The joystick "+ joystick.getName() +" moved on the X axis: "+ joystick.getX() +" and on the Y axis: "+ joystick.getY());
		}
	}
	
	public void comingOutput(SpeedController controller, int port){
		if(controller.get()!=0){
			System.out.println("Motor number "+ port +" moved, speed: "+ controller.get());
		}
	}
}