package drawing_program.x;

import drawingProgram.x.model.XProject;
import drawingProgram.x.model.XProject.Closed;
import drawingProgram.x.model.XProject.Init;
import drawingProgram.x.model.XProject.Opened;
import hu.elte.txtuml.api.layout.Above;
import hu.elte.txtuml.api.layout.Left;
import hu.elte.txtuml.api.layout.StateMachineDiagram;

public class XProjectSMDiagram extends StateMachineDiagram<XProject> {

	@Above(from = Closed.class, val = Init.class)
	@Left(from = Opened.class, val = Closed.class)
	class DrawingProgramLayout extends Layout {
	}
}
