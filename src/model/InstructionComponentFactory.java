package model;

import InstructionComponents.AddAddressInstructionComponent;
import InstructionComponents.AddConstantInstructionComponent;
import InstructionComponents.DivAddressInstructionComponent;
import InstructionComponents.DivConstantInstructionComponent;
import InstructionComponents.HaltInstructionComponent;
import InstructionComponents.InputInstructionComponent;
import InstructionComponents.JumpGreaterThanNullInstructionComponent;
import InstructionComponents.JumpInstructionComponent;
import InstructionComponents.JumpLessThanNullInstructionComponent;
import InstructionComponents.JumpNotNullInstructionComponent;
import InstructionComponents.JumpNullInstructionComponent;
import InstructionComponents.LoadAddressInstructionComponent;
import InstructionComponents.LoadConstantInstructionComponent;
import InstructionComponents.ModAddressInstructionComponent;
import InstructionComponents.ModCostantInstructionComponent;
import InstructionComponents.MultAddressInstructionComponent;
import InstructionComponents.MultConstantInstructionComponent;
import InstructionComponents.NoopInstructionComponent;
import InstructionComponents.NullInstructionComponent;
import InstructionComponents.OutputInstructionComponent;
import InstructionComponents.StoreInstructionComponent;
import InstructionComponents.SubAddressInstructionComponent;
import InstructionComponents.SubConstantInstructionComponent;

public class InstructionComponentFactory {
	public static InstructionComponent getInstructionComponent(InstructionComponent typeSample){
		InstructionComponent returnComponent=null;
		
		if(typeSample instanceof NoopInstructionComponent){
			returnComponent=new NoopInstructionComponent(false);
		}else if(typeSample instanceof HaltInstructionComponent){
			returnComponent=new HaltInstructionComponent();
		}else if(typeSample instanceof JumpInstructionComponent){
			returnComponent=new JumpInstructionComponent();
		}else if(typeSample instanceof JumpNullInstructionComponent){
			returnComponent=new JumpNullInstructionComponent();
		}else if(typeSample instanceof JumpNotNullInstructionComponent){
			returnComponent=new JumpNotNullInstructionComponent();
		}else if(typeSample instanceof JumpGreaterThanNullInstructionComponent){
			returnComponent=new JumpGreaterThanNullInstructionComponent();
		}else if(typeSample instanceof JumpLessThanNullInstructionComponent){
			returnComponent=new JumpLessThanNullInstructionComponent();
		}else if(typeSample instanceof NullInstructionComponent){
			returnComponent=new NullInstructionComponent();
		}else if(typeSample instanceof LoadConstantInstructionComponent){
			returnComponent=new LoadConstantInstructionComponent(false);
		}else if(typeSample instanceof LoadAddressInstructionComponent){
			returnComponent=new LoadAddressInstructionComponent();
		}else if(typeSample instanceof StoreInstructionComponent){
			returnComponent=new StoreInstructionComponent();
		}else if(typeSample instanceof AddConstantInstructionComponent){
			returnComponent=new AddConstantInstructionComponent(false);
		}else if(typeSample instanceof AddAddressInstructionComponent){
			returnComponent=new AddAddressInstructionComponent();
		}else if(typeSample instanceof SubConstantInstructionComponent){
			returnComponent=new SubConstantInstructionComponent(false);
		}else if(typeSample instanceof SubAddressInstructionComponent){
			returnComponent=new SubAddressInstructionComponent();
		}else if(typeSample instanceof MultConstantInstructionComponent){
			returnComponent=new MultConstantInstructionComponent(false);
		}else if(typeSample instanceof MultAddressInstructionComponent){
			returnComponent=new MultAddressInstructionComponent();
		}else if(typeSample instanceof DivConstantInstructionComponent){
			returnComponent=new DivConstantInstructionComponent(false);
		}else if(typeSample instanceof DivAddressInstructionComponent){
			returnComponent=new DivAddressInstructionComponent();
		}else if(typeSample instanceof ModCostantInstructionComponent){
			returnComponent=new ModCostantInstructionComponent(false);
		}else if(typeSample instanceof ModAddressInstructionComponent){
			returnComponent=new ModAddressInstructionComponent();
		}else if(typeSample instanceof InputInstructionComponent){
			returnComponent=new InputInstructionComponent(false);
		}else if(typeSample instanceof OutputInstructionComponent){
			returnComponent=new OutputInstructionComponent(false);
		}
		
		return returnComponent;
	}
	
	public static boolean hasDraggablePointer(InstructionComponent ic){
		if(ic instanceof NoopInstructionComponent){
			return false;
		}else if(ic instanceof HaltInstructionComponent){
			return false;
		}else if(ic instanceof JumpInstructionComponent){
			return true;
		}else if(ic instanceof JumpNullInstructionComponent){
			return true;
		}else if(ic instanceof JumpNotNullInstructionComponent){
			return true;
		}else if(ic instanceof JumpGreaterThanNullInstructionComponent){
			return true;
		}else if(ic instanceof JumpLessThanNullInstructionComponent){
			return true;
		}else if(ic instanceof NullInstructionComponent){
			return false;
		}else if(ic instanceof LoadConstantInstructionComponent){
			return false;
		}else if(ic instanceof LoadAddressInstructionComponent){
			return true;
		}else if(ic instanceof StoreInstructionComponent){
			return true;
		}else if(ic instanceof AddConstantInstructionComponent){
			return false;
		}else if(ic instanceof AddAddressInstructionComponent){
			return true;
		}else if(ic instanceof SubConstantInstructionComponent){
			return false;
		}else if(ic instanceof SubAddressInstructionComponent){
			return true;
		}else if(ic instanceof MultConstantInstructionComponent){
			return false;
		}else if(ic instanceof MultAddressInstructionComponent){
			return true;
		}else if(ic instanceof DivConstantInstructionComponent){
			return false;
		}else if(ic instanceof DivAddressInstructionComponent){
			return true;
		}else if(ic instanceof ModCostantInstructionComponent){
			return false;
		}else if(ic instanceof ModAddressInstructionComponent){
			return true;
		}else if(ic instanceof InputInstructionComponent){
			return false;
		}else if(ic instanceof OutputInstructionComponent){
			return false;
		}
		
		return false;
	}
}
