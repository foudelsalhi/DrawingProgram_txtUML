package drawing_program.x;

import drawingProgram.x.model.XPicture;
import drawingProgram.x.model.XPicture.Disabled;
import drawingProgram.x.model.XPicture.Displayed;
import drawingProgram.x.model.XPicture.Initialize;
import hu.elte.txtuml.api.layout.Above;
import hu.elte.txtuml.api.layout.Left;
import hu.elte.txtuml.api.layout.StateMachineDiagram;

public class XPictureSMDiagram extends StateMachineDiagram<XPicture> {

	@Above(from = Disabled.class, val = Initialize.class)
	@Left(from = Displayed.class, val = Disabled.class)
	// @Row({DispInit.class, Selected.class})
	// @Left(val=UnSelected.class, from = Selected.class)
	// @Above(from = UnSelected.class, val = DispInit.class)
	// @Left(from = Selected.class, val = UnSelected.class)

	class DrawingProgramLayout extends Layout {
	}
}
