package drawing_program.x;

import drawingProgram.x.model.XArc;
import drawingProgram.x.model.XEllipse;
import drawingProgram.x.model.XLine;
import drawingProgram.x.model.XPencil;
import drawingProgram.x.model.XPicture;
import drawingProgram.x.model.XPoint;
import drawingProgram.x.model.XPolygon;
import drawingProgram.x.model.XProject;
import drawingProgram.x.model.XProperties;
import drawingProgram.x.model.XRectangle;
import drawingProgram.x.model.XShape;
import drawingProgram.x.model.XText;
import hu.elte.txtuml.api.layout.Below;
import hu.elte.txtuml.api.layout.ClassDiagram;
import hu.elte.txtuml.api.layout.North;
import hu.elte.txtuml.api.layout.Right;
import hu.elte.txtuml.api.layout.Row;

public class drawingProgramClassDiagram extends ClassDiagram {
	@Row({ XProject.class, XPicture.class })
	@Right(val = XPicture.class, from = XProject.class)
	@Below(val = XShape.class, from = XPicture.class)
	@Row({ XShape.class, XProperties.class })
	@Row({ XRectangle.class, XEllipse.class, XPolygon.class, XArc.class, XLine.class, XText.class, XPencil.class })
	@North(val = XText.class, from = XPoint.class)
	@North(val = XLine.class, from = XPoint.class)
	@North(val = XArc.class, from = XPoint.class)
	@North(val = XPolygon.class, from = XPoint.class)
	@North(val = XEllipse.class, from = XPoint.class)
	@North(val = XRectangle.class, from = XPoint.class)

	class DrawingProgramLayout extends Layout {
	}
}
